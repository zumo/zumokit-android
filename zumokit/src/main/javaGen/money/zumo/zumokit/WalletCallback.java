// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from user.djinni

package money.zumo.zumokit;

import java.util.concurrent.atomic.AtomicBoolean;

public interface WalletCallback {
    public void onError(String errorName, String errorMessage);

    public void onSuccess(Wallet wallet);

    static final class CppProxy implements WalletCallback
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
        public void onError(String errorName, String errorMessage)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_onError(this.nativeRef, errorName, errorMessage);
        }
        private native void native_onError(long _nativeRef, String errorName, String errorMessage);

        @Override
        public void onSuccess(Wallet wallet)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_onSuccess(this.nativeRef, wallet);
        }
        private native void native_onSuccess(long _nativeRef, Wallet wallet);
    }
}
