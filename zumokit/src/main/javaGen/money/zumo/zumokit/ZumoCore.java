// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from zumo_core.djinni

package money.zumo.zumokit;

import java.util.concurrent.atomic.AtomicBoolean;

public interface ZumoCore {
    public void getUser(String userToken, UserCallback callback);

    public Utils getUtils();

    public State getState();

    public void addStateListener(StateListener listener);

    public void removeStateListener(StateListener listener);

    public static String getVersion()
    {
        return CppProxy.getVersion();
    }

    public static ZumoCore init(HttpImpl httpImpl, WebSocketImpl wsImpl, String apiKey, String apiRoot, String txServiceRoot)
    {
        return CppProxy.init(httpImpl,
                             wsImpl,
                             apiKey,
                             apiRoot,
                             txServiceRoot);
    }

    static final class CppProxy implements ZumoCore
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
        public void getUser(String userToken, UserCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_getUser(this.nativeRef, userToken, callback);
        }
        private native void native_getUser(long _nativeRef, String userToken, UserCallback callback);

        @Override
        public Utils getUtils()
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_getUtils(this.nativeRef);
        }
        private native Utils native_getUtils(long _nativeRef);

        @Override
        public State getState()
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_getState(this.nativeRef);
        }
        private native State native_getState(long _nativeRef);

        @Override
        public void addStateListener(StateListener listener)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_addStateListener(this.nativeRef, listener);
        }
        private native void native_addStateListener(long _nativeRef, StateListener listener);

        @Override
        public void removeStateListener(StateListener listener)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_removeStateListener(this.nativeRef, listener);
        }
        private native void native_removeStateListener(long _nativeRef, StateListener listener);

        public static native String getVersion();

        public static native ZumoCore init(HttpImpl httpImpl, WebSocketImpl wsImpl, String apiKey, String apiRoot, String txServiceRoot);
    }
}
