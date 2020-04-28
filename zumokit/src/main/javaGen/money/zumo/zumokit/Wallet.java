// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from wallet.djinni

package money.zumo.zumokit;

import java.util.concurrent.atomic.AtomicBoolean;

public interface Wallet {
    public void submitTransaction(ComposedTransaction composedTransaction, SubmitTransactionCallback callback);

    public void composeEthTransaction(String accountId, String gasPrice, String gasLimit, String to, String value, String data, Long nonce, ComposeTransactionCallback callback);

    public void composeBtcTransaction(String accountId, String changeAccountId, String to, String value, String feeRate, ComposeTransactionCallback callback);

    public void submitExchange(ComposedExchange composedExchange, SubmitExchangeCallback callback);

    public void composeExchange(String depositAccountId, String withdrawAccountId, ExchangeRate exchangeRate, String value, ComposeExchangeCallback callback);

    public String maxSpendableEth(String accountId, String gasPrice, String gasLimit);

    public String maxSpendableBtc(String accountId, String to, String feeRate);

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
        public void submitTransaction(ComposedTransaction composedTransaction, SubmitTransactionCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_submitTransaction(this.nativeRef, composedTransaction, callback);
        }
        private native void native_submitTransaction(long _nativeRef, ComposedTransaction composedTransaction, SubmitTransactionCallback callback);

        @Override
        public void composeEthTransaction(String accountId, String gasPrice, String gasLimit, String to, String value, String data, Long nonce, ComposeTransactionCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_composeEthTransaction(this.nativeRef, accountId, gasPrice, gasLimit, to, value, data, nonce, callback);
        }
        private native void native_composeEthTransaction(long _nativeRef, String accountId, String gasPrice, String gasLimit, String to, String value, String data, Long nonce, ComposeTransactionCallback callback);

        @Override
        public void composeBtcTransaction(String accountId, String changeAccountId, String to, String value, String feeRate, ComposeTransactionCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_composeBtcTransaction(this.nativeRef, accountId, changeAccountId, to, value, feeRate, callback);
        }
        private native void native_composeBtcTransaction(long _nativeRef, String accountId, String changeAccountId, String to, String value, String feeRate, ComposeTransactionCallback callback);

        @Override
        public void submitExchange(ComposedExchange composedExchange, SubmitExchangeCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_submitExchange(this.nativeRef, composedExchange, callback);
        }
        private native void native_submitExchange(long _nativeRef, ComposedExchange composedExchange, SubmitExchangeCallback callback);

        @Override
        public void composeExchange(String depositAccountId, String withdrawAccountId, ExchangeRate exchangeRate, String value, ComposeExchangeCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_composeExchange(this.nativeRef, depositAccountId, withdrawAccountId, exchangeRate, value, callback);
        }
        private native void native_composeExchange(long _nativeRef, String depositAccountId, String withdrawAccountId, ExchangeRate exchangeRate, String value, ComposeExchangeCallback callback);

        @Override
        public String maxSpendableEth(String accountId, String gasPrice, String gasLimit)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_maxSpendableEth(this.nativeRef, accountId, gasPrice, gasLimit);
        }
        private native String native_maxSpendableEth(long _nativeRef, String accountId, String gasPrice, String gasLimit);

        @Override
        public String maxSpendableBtc(String accountId, String to, String feeRate)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_maxSpendableBtc(this.nativeRef, accountId, to, feeRate);
        }
        private native String native_maxSpendableBtc(long _nativeRef, String accountId, String to, String feeRate);
    }
}
