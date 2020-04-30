package money.zumo.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import money.zumo.zumokit.AccountType;
import money.zumo.zumokit.ComposeExchangeCallback;
import money.zumo.zumokit.ComposedExchange;
import money.zumo.zumokit.ComposedTransaction;
import money.zumo.zumokit.Exchange;
import money.zumo.zumokit.ExchangeFees;
import money.zumo.zumokit.ExchangeRate;
import money.zumo.zumokit.NetworkType;
import money.zumo.zumokit.ComposeTransactionCallback;
import money.zumo.zumokit.ComposeExchangeCallback;
import money.zumo.zumokit.StateListener;
import money.zumo.zumokit.SubmitExchangeCallback;
import money.zumo.zumokit.SubmitTransactionCallback;
import money.zumo.zumokit.Transaction;
import money.zumo.zumokit.Wallet;
import money.zumo.zumokit.WalletCallback;
import money.zumo.zumokit.Account;
import money.zumo.zumokit.State;
import money.zumo.zumokit.User;
import money.zumo.zumokit.ZumoKit;
import money.zumo.zumokit.UserCallback;
import money.zumo.zumokit.exceptions.ZumoKitException;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ZumoKit mZumoKit;
    private Wallet mWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("zumokit/version", ZumoKit.getVersion());

        mZumoKit = new ZumoKit(BuildConfig.API_KEY, BuildConfig.API_URL, BuildConfig.TX_SERVICE_URL);

        mZumoKit.addStateListener(state -> {
            // Do something?
        });

        mZumoKit.getUser(BuildConfig.USER_TOKEN, new UserCallback() {
            @Override
            public void onError(Exception e) {
                String errorType = ((ZumoKitException) e).getErrorType();
                String errorCode = ((ZumoKitException) e).getErrorCode();
                String errorMessage = e.getMessage();
                Log.e("zumokit/auth", errorType);
                Log.e("zumokit/auth", errorCode);
                Log.e("zumokit/auth", errorMessage);
                Log.e("zumokit/auth", e.toString());
            }

            @Override
            public void onSuccess(User user) {
                Log.i("zumokit/auth", user.getId());

                if (user.hasWallet()) {
                    // Ethereum account
                    Account ethAccount = user.getAccount("ETH", NetworkType.RINKEBY, AccountType.STANDARD);
                    Log.i("zumokit/eth-account", ethAccount.toString());

                    // Bitcoin Testnet Compatibilty account
                    Account btcAccount = user.getAccount("BTC", NetworkType.TESTNET, AccountType.COMPATIBILITY);
                    Log.i("zumokit/btc-account", btcAccount.toString());

                    // Exchanges
                    Log.i("zumokit/exchanges", mZumoKit.getState().getExchanges().toString());

                    Log.i("zumokit/user", "User has wallet. Unlocking wallet...");
                    user.unlockWallet(BuildConfig.USER_PASSWORD, new WalletCallback() {
                        @Override
                        public void onError(Exception e) {
                            Log.e("zumokit", e.toString());
                        }

                        @Override
                        public void onSuccess(Wallet wallet) {
                            mWallet = wallet;

                            //composeEthTransaction(ethAccount, true);
                            //composeBtcTransaction(btcAccount);

                            State state = mZumoKit.getState();
                            Log.i("zumokit/exchange-rates", state.getExchangeRates());
//                            composeExchange(
//                                    ethAccount,
//                                    btcAccount,
//                                    state.getExchangeRates().get("ETH").get("BTC"),
//                                    state.getExchangeFees().get("ETH").get("BTC"),
//                                    "0.0222",
//                                    true
//                            );
//                            composeExchange(
//                                    btcAccount,
//                                    ethAccount,
//                                    state.getExchangeRates().get("BTC").get("ETH"),
//                                    state.getExchangeFees().get("BTC").get("ETH"),
//                                    "0.002",
//                                    false
//                            );
                        }
                    });
                } else {
                    Log.i("zumokit/user", "User has no wallet. Creating new wallet...");

                    String mnemonic = mZumoKit.utils().generateMnemonic(12);
                    // String mnemonic = "breeze lady dial claim eyebrow news urban warm scout barrel gorilla prevent";

                    user.createWallet(mnemonic, BuildConfig.USER_PASSWORD, new WalletCallback() {
                        @Override
                        public void onError(Exception e) {
                            Log.e("zumokit", e.toString());
                        }

                        @Override
                        public void onSuccess(Wallet wallet) {
                            for (Account account : user.getAccounts()) {
                                Log.i("zumokit/account-created", account.toString());
                            }
                        }
                    });
                }
            }
        });

    }

    private void composeEthTransaction(Account account, Boolean submit) {
        String gasPrice = "60";
        String gasLimit = "21000";
        String to = "0x361f6f8f32ffd5b5d003c8d87abacd35698a6d26";
        String value = "0.0069";

        mWallet.composeEthTransaction(account.getId(), gasPrice, gasLimit, to, value, null, null,
                new ComposeTransactionCallback() {
                    @Override
                    public void onError(Exception e) {
                        Log.e("zumokit", e.toString());
                    }

                    @Override
                    public void onSuccess(ComposedTransaction ctx) {
                        Log.i("zumokit", ctx.toString());

                        if (!submit)
                            return;

                        mWallet.submitTransaction(ctx, new SubmitTransactionCallback() {
                            @Override
                            public void onError(Exception e) {
                                Log.e("zumokit", e.toString());
                            }

                            @Override
                            public void onSuccess(Transaction tx) {
                                Log.i("zumokit", tx.toString());
                            }
                        });
                    }
                });
    }

    private void composeBtcTransaction(Account account) {
        String to = "2N6BfH356AicEzuC1dYt4gYkw6WFWZrfeSY";
        String value = "0.0002";
        String feeRate = "20";

        mWallet.composeBtcTransaction(account.getId(), account.getId(), to, value, feeRate,
                new ComposeTransactionCallback() {
                    @Override
                    public void onError(Exception e) {
                        Log.e("zumokit", e.toString());
                    }

                    @Override
                    public void onSuccess(ComposedTransaction ctx) {
                Log.i("zumokit", ctx.toString());
            }
        });
    }

    private void composeExchange(Account depositAccount, Account withdrawAccount, ExchangeRate exchangeRate, ExchangeFees exchangeFees, String value, Boolean submit) {
        mWallet.composeExchange(
                depositAccount.getId(), withdrawAccount.getId(), exchangeRate, exchangeFees, value,
                new ComposeExchangeCallback() {
                    @Override
                    public void onError(Exception e) {
                        Log.e("zumokit", e.toString());
                    }

                    @Override
                    public void onSuccess(ComposedExchange composedExchange) {
                        Log.i("zumokit", composedExchange.toString());

                        if (!submit)
                            return;

                        mWallet.submitExchange(composedExchange, new SubmitExchangeCallback() {
                            @Override
                            public void onError(Exception e) {
                                Log.e("zumokit", e.toString());
                            }

                            @Override
                            public void onSuccess(Exchange exchange) {
                                Log.i("zumokit", exchange.toString());
                            }
                        });
                    }
                });
    }
}
