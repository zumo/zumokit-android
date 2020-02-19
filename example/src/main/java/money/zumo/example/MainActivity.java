package money.zumo.example;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import money.zumo.zumokit.AccountType;
import money.zumo.zumokit.NetworkType;
import money.zumo.zumokit.SendTransactionCallback;
import money.zumo.zumokit.StateListener;
import money.zumo.zumokit.Transaction;
import money.zumo.zumokit.Wallet;
import money.zumo.zumokit.WalletCallback;
import money.zumo.zumokit.Account;
import money.zumo.zumokit.State;
import money.zumo.zumokit.User;
import money.zumo.zumokit.ZumoKit;
import money.zumo.zumokit.AuthCallback;

import money.zumo.example.BuildConfig;

import java.io.IOException;
import java.util.HashMap;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainActivity extends AppCompatActivity {

    private ZumoKit zumoKit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("zumokit/version", ZumoKit.getVersion());

        HashMap<String, String> headers = new HashMap<String, String>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            headers = mapper.readValue(BuildConfig.CUSTOM_HEADERS, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        zumoKit = new ZumoKit(BuildConfig.TX_SERVICE_URL, BuildConfig.API_KEY, BuildConfig.API_URL,
                BuildConfig.BUNDLE_URL);

        zumoKit.addStateListener(new StateListener() {
            Account prev_account = null;
            Account next_account = null;

            @Override
            public void update(State state) {
                prev_account = next_account;
                next_account = state.getAccounts().stream().filter(a -> a.getCoin().equals("Ether")).findFirst()
                        .orElse(null);
                if (prev_account != next_account && next_account != null) {
                    Log.i("zumokit/eth-account-updated", next_account.toString());
                }
            }
        });

        zumoKit.auth(BuildConfig.USER_TOKEN, headers, new AuthCallback() {
            @Override
            public void onError(short errorCode, String errorMessage) {
                Log.e("zumokit/auth", errorMessage);
            }

            @Override
            public void onSuccess(User user) {
                Log.i("zumokit/auth", user.getId());

                if (user.hasWallet()) {
                    // Ethereum account
                    Account ethAccount = user.getAccount("ETH", NetworkType.RINKEBY, AccountType.STANDARD);
                    Log.i("zumokit/eth-account", ethAccount.toString());
                    Log.i("zumokit/eth-transactions", user.getAccountTransactions(ethAccount.getId()).toString());

                    // Bitcoin Testnet Compatibilty account
                    Account btcAccount = user.getAccount("BTC", NetworkType.TESTNET, AccountType.COMPATIBILITY);
                    Log.i("zumokit/btc-account", btcAccount.toString());
                    Log.i("zumokit/btc-transactions", user.getAccountTransactions(btcAccount.getId()).toString());

                    for (Account account : user.getAccounts()) {
                        Log.i("zumokit/account", account.toString());
                    }

                    Log.i("zumokit/user", "User has wallet. Unlocking wallet...");
                    user.unlockWallet(BuildConfig.USER_PASSWORD, new WalletCallback() {
                        @Override
                        public void onError(String errorName, String errorMessage) {
                            Log.e("zumokit", errorMessage);
                        }

                        @Override
                        public void onSuccess(Wallet wallet) {
                            for (Account account : user.getAccounts()) {
                                Log.i("zumokit/account", account.toString());
                            }

                            //sendEthTransaction(ethAccount, wallet);
                            //sendBtcTransaction(btcAccount, wallet);
                        }
                    });
                } else {
                    Log.i("zumokit/user", "User has no wallet. Creating new wallet...");

                    String mnemonic = zumoKit.utils().generateMnemonic(12);
                    // String mnemonic = "breeze lady dial claim eyebrow news urban warm scout barrel gorilla prevent";

                    user.createWallet(mnemonic, BuildConfig.USER_PASSWORD, new WalletCallback() {
                        @Override
                        public void onError(String errorName, String errorMessage) {
                            Log.e("zumokit", errorMessage);
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

    private void sendEthTransaction(Account account, Wallet wallet) {
        String gasPrice = "60";
        String gasLimit = "21000";
        String to = "0x361f6f8f32ffd5b5d003c8d87abacd35698a6d26";
        String value = "0.0069";

        wallet.sendEthTransaction(account.getId(), gasPrice, gasLimit, to, value, null, null,
                new SendTransactionCallback() {
                    @Override
                    public void onError(String errorName, String errorMessage) {
                        Log.e("zumokit", errorMessage);
                    }

                    @Override
                    public void onSuccess(Transaction transaction) {
                        Log.i("zumokit", transaction.toString());
                    }
                });
    }

    private void sendBtcTransaction(Account account, Wallet wallet) {
        String to = "2N6BfH356AicEzuC1dYt4gYkw6WFWZrfeSY";
        String value = "0.0002";
        String feeRate = "20";

        wallet.sendBtcTransaction(account.getId(), account.getId(), to, value, feeRate, new SendTransactionCallback() {
            @Override
            public void onError(String errorName, String errorMessage) {
                Log.e("zumokit", errorMessage);
            }

            @Override
            public void onSuccess(Transaction transaction) {
                Log.i("zumokit", transaction.toString());
            }
        });
    }
}
