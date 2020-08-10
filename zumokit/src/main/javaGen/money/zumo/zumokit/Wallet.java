// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from wallet.djinni

package money.zumo.zumokit;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * User wallet
 * So many comments
 */
public interface Wallet {
    /**
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     */
    public void submitTransaction(ComposedTransaction composedTransaction, SubmitTransactionCallback callback);

    public void composeEthTransaction(String fromAccountId, java.math.BigDecimal gasPrice, java.math.BigDecimal gasLimit, String destination, java.math.BigDecimal amount, String data, Long nonce, boolean sendMax, ComposeTransactionCallback callback);

    public void composeBtcTransaction(String fromAccountId, String changeAccountId, String destination, java.math.BigDecimal amount, java.math.BigDecimal feeRate, boolean sendMax, ComposeTransactionCallback callback);

    public void composeInternalFiatTransaction(String fromAccountId, String toAccountId, java.math.BigDecimal amount, boolean sendMax, ComposeTransactionCallback callback);

    public void composeTransactionToNominatedAccount(String fromAccountId, java.math.BigDecimal amount, boolean sendMax, ComposeTransactionCallback callback);

    public void submitExchange(ComposedExchange composedExchange, SubmitExchangeCallback callback);

    public void composeExchange(String depositAccountId, String withdrawAccountId, ExchangeRate exchangeRate, ExchangeSettings exchangeSettings, java.math.BigDecimal amount, boolean sendMax, ComposeExchangeCallback callback);

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
        public void composeEthTransaction(String fromAccountId, java.math.BigDecimal gasPrice, java.math.BigDecimal gasLimit, String destination, java.math.BigDecimal amount, String data, Long nonce, boolean sendMax, ComposeTransactionCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_composeEthTransaction(this.nativeRef, fromAccountId, gasPrice, gasLimit, destination, amount, data, nonce, sendMax, callback);
        }
        private native void native_composeEthTransaction(long _nativeRef, String fromAccountId, java.math.BigDecimal gasPrice, java.math.BigDecimal gasLimit, String destination, java.math.BigDecimal amount, String data, Long nonce, boolean sendMax, ComposeTransactionCallback callback);

        @Override
        public void composeBtcTransaction(String fromAccountId, String changeAccountId, String destination, java.math.BigDecimal amount, java.math.BigDecimal feeRate, boolean sendMax, ComposeTransactionCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_composeBtcTransaction(this.nativeRef, fromAccountId, changeAccountId, destination, amount, feeRate, sendMax, callback);
        }
        private native void native_composeBtcTransaction(long _nativeRef, String fromAccountId, String changeAccountId, String destination, java.math.BigDecimal amount, java.math.BigDecimal feeRate, boolean sendMax, ComposeTransactionCallback callback);

        @Override
        public void composeInternalFiatTransaction(String fromAccountId, String toAccountId, java.math.BigDecimal amount, boolean sendMax, ComposeTransactionCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_composeInternalFiatTransaction(this.nativeRef, fromAccountId, toAccountId, amount, sendMax, callback);
        }
        private native void native_composeInternalFiatTransaction(long _nativeRef, String fromAccountId, String toAccountId, java.math.BigDecimal amount, boolean sendMax, ComposeTransactionCallback callback);

        @Override
        public void composeTransactionToNominatedAccount(String fromAccountId, java.math.BigDecimal amount, boolean sendMax, ComposeTransactionCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_composeTransactionToNominatedAccount(this.nativeRef, fromAccountId, amount, sendMax, callback);
        }
        private native void native_composeTransactionToNominatedAccount(long _nativeRef, String fromAccountId, java.math.BigDecimal amount, boolean sendMax, ComposeTransactionCallback callback);

        @Override
        public void submitExchange(ComposedExchange composedExchange, SubmitExchangeCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_submitExchange(this.nativeRef, composedExchange, callback);
        }
        private native void native_submitExchange(long _nativeRef, ComposedExchange composedExchange, SubmitExchangeCallback callback);

        @Override
        public void composeExchange(String depositAccountId, String withdrawAccountId, ExchangeRate exchangeRate, ExchangeSettings exchangeSettings, java.math.BigDecimal amount, boolean sendMax, ComposeExchangeCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_composeExchange(this.nativeRef, depositAccountId, withdrawAccountId, exchangeRate, exchangeSettings, amount, sendMax, callback);
        }
        private native void native_composeExchange(long _nativeRef, String depositAccountId, String withdrawAccountId, ExchangeRate exchangeRate, ExchangeSettings exchangeSettings, java.math.BigDecimal amount, boolean sendMax, ComposeExchangeCallback callback);
    }
}
