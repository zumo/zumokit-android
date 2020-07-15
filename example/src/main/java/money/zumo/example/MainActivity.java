package money.zumo.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import money.zumo.zumokit.AccountCallback;
import money.zumo.zumokit.AccountFiatProperties;
import money.zumo.zumokit.AccountFiatPropertiesCallback;
import money.zumo.zumokit.AccountType;
import money.zumo.zumokit.CurrencyCode;
import money.zumo.zumokit.HttpService;
import money.zumo.zumokit.ComposeExchangeCallback;
import money.zumo.zumokit.ComposedExchange;
import money.zumo.zumokit.ComposedTransaction;
import money.zumo.zumokit.Exchange;
import money.zumo.zumokit.ExchangeRate;
import money.zumo.zumokit.ExchangeSettings;
import money.zumo.zumokit.HttpCallback;
import money.zumo.zumokit.State;
import money.zumo.zumokit.NetworkType;
import money.zumo.zumokit.ComposeTransactionCallback;
import money.zumo.zumokit.SubmitExchangeCallback;
import money.zumo.zumokit.SubmitTransactionCallback;
import money.zumo.zumokit.SuccessCallback;
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
            for (Transaction tx : state.getTransactions()) {
                Log.i("zumokit/transaction", tx.toString());
            }
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
                            Log.i("zumokit/user", mUser.getId());

                            Log.i("zumokit/modulr-user", mUser.isModulrCustomer(NetworkType.TESTNET) ? "YES" : "NO");

//                            user.makeModulrCustomer(
//                                    NetworkType.TESTNET,
//                                    "Ivan",
//                                    null,
//                                    "Romanovski",
//                                    "1989-02-02",
//                                    "ivan.romanovski@staging.zumo.money",
//                                    "+56123456",
//                                    "Downing st. 23",
//                                    null,
//                                    "GB",
//                                    "B33 8TH",
//                                    "London",
//                                    new SuccessCallback() {
//                                        @Override
//                                        public void onError(Exception e) {
//                                            Log.e("zumokit/modulr", e.toString());
//                                        }
//
//                                        @Override
//                                        public void onSuccess() {
//                                            Log.i("zumokit/modulr", "User created!");
//                                        }
//                                    }
//                            );

//                            mUser.createFiatAccount(NetworkType.TESTNET, CurrencyCode.GBP, new AccountCallback() {
//                                @Override
//                                public void onError(Exception e) {
//                                    Log.e("zumokit/modulr", e.toString());
//                                }
//
//                                @Override
//                                public void onSuccess(Account account) {
//                                    Log.i("zumokit/modulr", account.toString());
//                                }
//                            });

                            if (mUser.hasWallet()) {
                                // Ethereum account
                                Account ethAccount = user.getAccount("ETH", NetworkType.RINKEBY, AccountType.STANDARD);
                                Log.i("zumokit/eth-account", ethAccount.toString());

                                // Bitcoin Testnet Compatibilty account
                                Account btcAccount = user.getAccount("BTC", NetworkType.TESTNET, AccountType.COMPATIBILITY);
                                Log.i("zumokit/btc-account", btcAccount.toString());

                                // Fiat account
                                Account fiatAccount = mUser.getAccount(CurrencyCode.GBP, NetworkType.TESTNET, AccountType.STANDARD);
                                Log.i("zumokit/fiat-account", fiatAccount.toString());

                                user.getNominatedAccountFiatProperties(fiatAccount.getId(), new AccountFiatPropertiesCallback() {
                                    @Override
                                    public void onError(Exception e) {
                                        Log.e("zumokit/nominated-account", e.toString());
                                    }

                                    @Override
                                    public void onSuccess(AccountFiatProperties account) {
                                        Log.i("zumokit/nominated-account", account.toString());
                                    }
                                });

                                // Exchanges
                                Log.i("zumokit/exchanges", mZumoKit.getState().getExchanges().toString());

                                Log.i("zumokit/average", mZumoKit.getState().getFeeRates().get("BTC").getAverage());

                                Log.i("zumokit/user", "User has wallet. Unlocking wallet...");
                                mUser.unlockWallet(BuildConfig.USER_WALLET_PASSWORD, new WalletCallback() {
                                    @Override
                                    public void onError(Exception e) {
                                        Log.e("zumokit", e.toString());
                                    }

                                    @Override
                                    public void onSuccess(Wallet wallet) {
                                        mWallet = wallet;

                                        // Compose ETH and BTC transactions
                                        //composeEthTransaction(ethAccount, true);
                                        //composeBtcTransaction(btcAccount, false);
                                        composeFiatTransaction(fiatAccount, true, false);

                                        State state = mZumoKit.getState();

                                        // Display current exchange rates & exchange settings
                                        Log.i("zumokit/exchange-rates",  state.getExchangeRates().get("BTC").get("ETH").toString());
                                        Log.i("zumokit/exchange-rates",  state.getExchangeSettings().get("ETH").get("BTC").toString());

                                        composeExchange(
                                                ethAccount,
                                                btcAccount,
                                                state.getExchangeRates().get("ETH").get("BTC"),
                                                state.getExchangeSettings().get("ETH").get("BTC"),
                                                "0.08",
                                                false,
                                                false
                                        );
                                    }
                                });
                            } else {
                                Log.i("zumokit/user", "User has no wallet. Creating new wallet...");

                                String mnemonic = mZumoKit.utils().generateMnemonic(12);

                                mUser.createWallet(mnemonic, BuildConfig.USER_WALLET_PASSWORD, new WalletCallback() {
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


    private void composeFiatTransaction(Account account, Boolean toNominated, Boolean submit) {
        String destination = "d8473a8e-f78d-4d5c-84cb-921b4c5dfbb3";
        String value = "50.2";

        if (toNominated) {
            mWallet.composeTransactionToNominatedAccount(account.getId(), value, false, new ComposeTransactionCallback() {
                @Override
                public void onError(Exception e) {
                    Log.e("zumokit", e.toString());
                }

                @Override
                public void onSuccess(ComposedTransaction composedTransaction) {
                    Log.i("zumokit", composedTransaction.toString());

                    if (!submit)
                        return;

                    mWallet.submitTransaction(composedTransaction, new SubmitTransactionCallback() {
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
        } else {
            mWallet.composeInternalFiatTransaction(account.getId(), destination, value, false, new ComposeTransactionCallback() {
                @Override
                public void onError(Exception e) {
                    Log.e("zumokit", e.toString());
                }

                @Override
                public void onSuccess(ComposedTransaction composedTransaction) {
                    Log.i("zumokit", composedTransaction.toString());

                    if (!submit)
                        return;

                    mWallet.submitTransaction(composedTransaction, new SubmitTransactionCallback() {
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
