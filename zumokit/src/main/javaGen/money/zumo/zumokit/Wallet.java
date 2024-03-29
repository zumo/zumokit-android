// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from wallet.djinni

package money.zumo.zumokit;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * User wallet provides methods for transfer and exchange of fiat and cryptocurrency funds.
 * Sending a transaction or making an exchange is a two step process. First a transaction or
 * exchange has to be composed via one of the compose methods, then {@link  ComposedTransaction ComposedTransaction} or
 * {@link  ComposedExchange ComposedExchange} can be submitted.
 * <p>
 * User wallet instance can be obtained by creating, unlocking or recovering user wallet via {@link  User User} instance.
 */
public interface Wallet {
    /**
     * Compose BTC or BSV transaction. Refer to <a target="_top" href="https://developers.zumo.money/docs/guides/send-transactions#crypto">Send Transactions</a> guide for usage details.
     * <p>
     * On success {@link  ComposedTransaction ComposedTransaction}  is returned via callback.
     *
     * @param fromAccountId   {@link  Account Account} identifier
     * @param changeAccountId change {@link  Account Account} identifier, which can be the same as fromAccountId
     * @param destination       destination wallet address
     * @param amount            amount in BTC or BSV
     * @param feeRate          fee rate in satoshis/byte
     * @param sendMax          send maximum possible funds to destination
     * @param callback          an interface to receive the result or error
     */
    public void composeTransaction(String fromAccountId, String changeAccountId, String destination, java.math.BigDecimal amount, java.math.BigDecimal feeRate, boolean sendMax, ComposeTransactionCallback callback);

    /**
     * Compose Ethereum transaction. Refer to <a target="_top" href="https://developers.zumo.money/docs/guides/send-transactions#ethereum">Send Transactions</a> guide for usage details.
     * <p>
     * On success {@link  ComposedTransaction ComposedTransaction} is returned via callback.
     *
     * @param fromAccountId {@link  Account Account} identifier
     * @param gasPrice       gas price in gwei
     * @param gasLimit       gas limit
     * @param destination     destination wallet address
     * @param amount          amount in ETH
     * @param data            data in string format or null
     * @param nonce           next transaction nonce or null
     * @param sendMax        send maximum possible funds to destination
     * @param callback        an interface to receive the result or error
     */
    public void composeEthTransaction(String fromAccountId, java.math.BigDecimal gasPrice, int gasLimit, String destination, java.math.BigDecimal amount, String data, Integer nonce, boolean sendMax, ComposeTransactionCallback callback);

    static final class CppProxy implements Wallet
    {
        private final long nativeRef;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);

        private CppProxy(long nativeRef)
        {
            if (nativeRef == 0) throw new RuntimeException("nativeRef is zero");
            this.nativeRef = nativeRef;
        }

        private native void nativeDestroy(long nativeRef);
        public void _djinni_private_destroy()
        {
            boolean destroyed = this.destroyed.getAndSet(true);
            if (!destroyed) nativeDestroy(this.nativeRef);
        }
        protected void finalize() throws java.lang.Throwable
        {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override
        public void composeTransaction(String fromAccountId, String changeAccountId, String destination, java.math.BigDecimal amount, java.math.BigDecimal feeRate, boolean sendMax, ComposeTransactionCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_composeTransaction(this.nativeRef, fromAccountId, changeAccountId, destination, amount, feeRate, sendMax, callback);
        }
        private native void native_composeTransaction(long _nativeRef, String fromAccountId, String changeAccountId, String destination, java.math.BigDecimal amount, java.math.BigDecimal feeRate, boolean sendMax, ComposeTransactionCallback callback);

        @Override
        public void composeEthTransaction(String fromAccountId, java.math.BigDecimal gasPrice, int gasLimit, String destination, java.math.BigDecimal amount, String data, Integer nonce, boolean sendMax, ComposeTransactionCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_composeEthTransaction(this.nativeRef, fromAccountId, gasPrice, gasLimit, destination, amount, data, nonce, sendMax, callback);
        }
        private native void native_composeEthTransaction(long _nativeRef, String fromAccountId, java.math.BigDecimal gasPrice, int gasLimit, String destination, java.math.BigDecimal amount, String data, Integer nonce, boolean sendMax, ComposeTransactionCallback callback);
    }
}
