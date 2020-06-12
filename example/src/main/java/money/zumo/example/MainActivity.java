package money.zumo.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import money.zumo.zumokit.AccountType;
import money.zumo.zumokit.HttpService;
import money.zumo.zumokit.ComposeExchangeCallback;
import money.zumo.zumokit.ComposedExchange;
import money.zumo.zumokit.ComposedTransaction;
import money.zumo.zumokit.Exchange;
import money.zumo.zumokit.ExchangeRate;
import money.zumo.zumokit.ExchangeSettings;
import money.zumo.zumokit.HttpCallback;
import money.zumo.zumokit.MnemonicCallback;
import money.zumo.zumokit.NetworkType;
import money.zumo.zumokit.ComposeTransactionCallback;
import money.zumo.zumokit.SubmitExchangeCallback;
import money.zumo.zumokit.SubmitTransactionCallback;
import money.zumo.zumokit.Transaction;
import money.zumo.zumokit.Wallet;
import money.zumo.zumokit.WalletCallback;
import money.zumo.zumokit.Account;
import money.zumo.zumokit.User;
import money.zumo.zumokit.ZumoKit;
import money.zumo.zumokit.UserCallback;
import money.zumo.zumokit.exceptions.ZumoKitException;

import java.util.HashMap;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainActivity extends AppCompatActivity {

    private ZumoKit mZumoKit;
    private User mUser;
    private Wallet mWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("zumokit/version", ZumoKit.getVersion());

        // Initialize ZumoKit
        mZumoKit = new ZumoKit(BuildConfig.API_KEY, BuildConfig.API_URL, BuildConfig.TX_SERVICE_URL);

        // Listen to ZumoKit state changes
        mZumoKit.addStateListener(state -> {
            // React to state changes
        });

        // Get ZumoKit user token from Client API
        HttpService httpService = new HttpService();

        HashMap<String, String> clientHeaders = new HashMap<String, String>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            clientHeaders = mapper.readValue(BuildConfig.CLIENT_HEADERS, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        httpService.request(BuildConfig.CLIENT_ZUMOKIT_AUTH_ENDPOINT, BuildConfig.CLIENT_METHOD, clientHeaders, BuildConfig.CLIENT_BODY, new HttpCallback() {
            @Override
            public void onNetworkError(String message) {
                Log.e("zumokit/auth", message);
            }

            @Override
            public void onSuccess(short httpCode, String responseData) {
                if (httpCode == 200) {
                    String tokenSet = responseData;
                    mZumoKit.getUser(tokenSet, new UserCallback() {
                        @Override
                        public void onError(Exception e) {
                            String errorType = ((ZumoKitException) e).getErrorType();
                            String errorCode = ((ZumoKitException) e).getErrorCode();
                            String errorMessage = e.getMessage();
                            Log.e("zumokit/user", errorType);
                            Log.e("zumokit/user", errorCode);
                            Log.e("zumokit/user", errorMessage);
                            Log.e("zumokit/user", e.toString());
                        }

                        @Override
                        public void onSuccess(User user) {
                            mUser = user;
                            Log.i("zumokit/user", user.getId());

                            if (user.hasWallet()) {
                                // Ethereum account
                                Account ethAccount = user.getAccount("ETH", NetworkType.RINKEBY, AccountType.STANDARD);
                                Log.i("zumokit/eth-account", ethAccount.toString());

                                // Bitcoin Testnet Compatibilty account
                                Account btcAccount = user.getAccount("BTC", NetworkType.TESTNET, AccountType.COMPATIBILITY);
                                Log.i("zumokit/btc-account", btcAccount.toString());

                                // Exchanges
                                Log.i("zumokit/exchanges", mZumoKit.getState().getExchanges().toString());

                                Log.i("zumokit/average", mZumoKit.getState().getFeeRates().get("BTC").getAverage());

                                Log.i("zumokit/user", "User has wallet. Unlocking wallet...");
                                user.unlockWallet(BuildConfig.USER_WALLET_PASSWORD, new WalletCallback() {
                                    @Override
                                    public void onError(Exception e) {
                                        Log.e("zumokit", e.toString());
                                    }

                                    @Override
                                    public void onSuccess(Wallet wallet) {
                                        mWallet = wallet;

                                        // Compose ETH and BTC transactions
                                        composeEthTransaction(ethAccount, false);
                                        //composeBtcTransaction(btcAccount, false);

                                        // Display current exchange rates & exchange settings
                                        //State state = mZumoKit.getState();
                                        //Log.i("zumokit/exchange-rates", state.getExchangeSettings().toString());
                                        //Log.i("zumokit/exchange-rates",  state.getExchangeRates().get("BTC").get("ETH").toString());
                                        //Log.i("zumokit/exchange-rates",  state.getExchangeSettings().get("BTC").get("ETH").toString());

                                        // Compose ETH -> BTC exchange
                                        //composeExchange(
                                        //        ethAccount,
                                        //        btcAccount,
                                        //        state.getExchangeRates().get("ETH").get("BTC"),
                                        //        state.getExchangeSettings().get("ETH").get("BTC"),
                                        //        "0.02",
                                        //        false
                                        //);

                                        // Compose BTC -> ETH Exchange
                                        //composeExchange(
                                        //        btcAccount,
                                        //        ethAccount,
                                        //        state.getExchangeRates(),
                                        //        "0.001",
                                        //        false
                                        //);
                                    }
                                });
                            } else {
                                Log.i("zumokit/user", "User has no wallet. Creating new wallet...");

                                String mnemonic = mZumoKit.utils().generateMnemonic(12);

                                user.createWallet(mnemonic, BuildConfig.USER_WALLET_PASSWORD, new WalletCallback() {
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
                } else {
                    Log.e("zumokit/auth", responseData);
                }
            }
        });
    }

    private void composeEthTransaction(Account account, Boolean submit) {
        String gasPrice = "60";
        String gasLimit = "21000";
        String to = "0xDa57228C976ba133b46B26066bBac337e62D8357";
        String value = "0.02";

        mWallet.composeEthTransaction(account.getId(), gasPrice, gasLimit, to, value, null, null, false,
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

    private void composeBtcTransaction(Account account, Boolean submit) {
        String to = "2NBQtvK3wMXs43YGt9aotsoWSS79Qmh7z1J";
        String value = "0.0002";
        String feeRate = mZumoKit.getState().getFeeRates().get("BTC").getAverage();

        mWallet.composeBtcTransaction(account.getId(), account.getId(), to, value, feeRate, false,
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

    private void composeExchange(Account depositAccount, Account withdrawAccount, ExchangeRate exchangeRate, ExchangeSettings exchangeSettings, String value, Boolean sendMax, Boolean submit) {
        mWallet.composeExchange(
                depositAccount.getId(), withdrawAccount.getId(), exchangeRate, exchangeSettings, value, sendMax,
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
