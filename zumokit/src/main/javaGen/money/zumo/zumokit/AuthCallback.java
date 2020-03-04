// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from zumo_core.djinni

package money.zumo.zumokit;

import java.util.concurrent.atomic.AtomicBoolean;

public interface AuthCallback {
    public void onError(ZumoKitError error);

    public void onSuccess(User user);

    static final class CppProxy implements AuthCallback
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
        public void onError(ZumoKitError error)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_onError(this.nativeRef, error);
        }
        private native void native_onError(long _nativeRef, ZumoKitError error);

        @Override
        public void onSuccess(User user)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_onSuccess(this.nativeRef, user);
        }
        private native void native_onSuccess(long _nativeRef, User user);
    }
}
