// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from utils.djinni

package money.zumo.zumokit;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Utility class providing blockchain related utility methods. Accessed from @link ZumoKit class.
 * <p>
 * This class provides mnemonic phrase generation utility, Bitcoin & Ethereum address
 * validation utilities and Ethereum unit conversion methods.
 */
public interface Utils {
    /**
     * Generates mnemonic seed phrase used in wallet creation process.
     * @param wordCount   12, 15, 18, 21 or 24
     */
    public String generateMnemonic(int wordCount);

    /**
     * Validates Ethereum address.
     * @param address Ethereum address
     * @return true if Ethereum address is valid
     */
    public boolean isValidEthAddress(String address);

    /**
     * Validates Bitcoin address on a given network.
     * @param address Bitcoin address
     * @param network network type, either 'MAINNET' or 'TESTNET'
     * @return true if Bitcoin address is valid on a given network
     * @see network_type
     */
    public boolean isValidBtcAddress(String address, String network);

    /**
     * Converts wei value to ETH.
     * @param number wei value to be converted
     * @return ETH value
     */
    public java.math.BigDecimal weiToEth(java.math.BigDecimal number);

    /**
     * Converts ETH value to wei.
     * @param number ETH value to be converted
     * @return wei value
     */
    public java.math.BigDecimal ethToWei(java.math.BigDecimal number);

    /**
     * Converts gwei value to ETH.
     * @param number gwei value to be converted
     * @return ETH value
     */
    public java.math.BigDecimal gweiToEth(java.math.BigDecimal number);

    /**
     * Converts ETH value to gwei.
     * @param number ETH value to be converted
     * @return gwei value
     */
    public java.math.BigDecimal ethToGwei(java.math.BigDecimal number);

    /**
     * Converts wei value to gwei.
     * @param number wei value to be converted
     * @return gwei value
     */
    public java.math.BigDecimal weiToGwei(java.math.BigDecimal number);

    /**
     * Converts gwei value to wei.
     * @param number gwei value to be converted
     * @return wei value
     */
    public java.math.BigDecimal gweiToWei(java.math.BigDecimal number);

    static final class CppProxy implements Utils
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
        public String generateMnemonic(int wordCount)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_generateMnemonic(this.nativeRef, wordCount);
        }
        private native String native_generateMnemonic(long _nativeRef, int wordCount);

        @Override
        public boolean isValidEthAddress(String address)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_isValidEthAddress(this.nativeRef, address);
        }
        private native boolean native_isValidEthAddress(long _nativeRef, String address);

        @Override
        public boolean isValidBtcAddress(String address, String network)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_isValidBtcAddress(this.nativeRef, address, network);
        }
        private native boolean native_isValidBtcAddress(long _nativeRef, String address, String network);

        @Override
        public java.math.BigDecimal weiToEth(java.math.BigDecimal number)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_weiToEth(this.nativeRef, number);
        }
        private native java.math.BigDecimal native_weiToEth(long _nativeRef, java.math.BigDecimal number);

        @Override
        public java.math.BigDecimal ethToWei(java.math.BigDecimal number)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_ethToWei(this.nativeRef, number);
        }
        private native java.math.BigDecimal native_ethToWei(long _nativeRef, java.math.BigDecimal number);

        @Override
        public java.math.BigDecimal gweiToEth(java.math.BigDecimal number)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_gweiToEth(this.nativeRef, number);
        }
        private native java.math.BigDecimal native_gweiToEth(long _nativeRef, java.math.BigDecimal number);

        @Override
        public java.math.BigDecimal ethToGwei(java.math.BigDecimal number)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_ethToGwei(this.nativeRef, number);
        }
        private native java.math.BigDecimal native_ethToGwei(long _nativeRef, java.math.BigDecimal number);

        @Override
        public java.math.BigDecimal weiToGwei(java.math.BigDecimal number)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_weiToGwei(this.nativeRef, number);
        }
        private native java.math.BigDecimal native_weiToGwei(long _nativeRef, java.math.BigDecimal number);

        @Override
        public java.math.BigDecimal gweiToWei(java.math.BigDecimal number)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_gweiToWei(this.nativeRef, number);
        }
        private native java.math.BigDecimal native_gweiToWei(long _nativeRef, java.math.BigDecimal number);
    }
}
