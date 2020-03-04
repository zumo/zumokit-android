// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from networking.djinni

package money.zumo.zumokit;

import java.util.concurrent.atomic.AtomicBoolean;

public interface HttpCallback {
    public void onNetworkError(String message);

    public void onSuccess(short httpCode, String data);

    static final class CppProxy implements HttpCallback
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
        public void onNetworkError(String message)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_onNetworkError(this.nativeRef, message);
        }
        private native void native_onNetworkError(long _nativeRef, String message);

        @Override
        public void onSuccess(short httpCode, String data)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_onSuccess(this.nativeRef, httpCode, data);
        }
        private native void native_onSuccess(long _nativeRef, short httpCode, String data);
    }
}
