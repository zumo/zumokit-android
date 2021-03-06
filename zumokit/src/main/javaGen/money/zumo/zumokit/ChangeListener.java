// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from zumo_core.djinni

package money.zumo.zumokit;

import java.util.concurrent.atomic.AtomicBoolean;

/** Callback interface used to listen for changes in {@link  ZumoKit ZumoKit} class. */
public interface ChangeListener {
    public void onChange();

    static final class CppProxy implements ChangeListener
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
        public void onChange()
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_onChange(this.nativeRef);
        }
        private native void native_onChange(long _nativeRef);
    }
}
