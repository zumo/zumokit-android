// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from user.djinni

package money.zumo.zumokit;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * User class provides methods for managing user wallet and accounts.
 * <p>
 * User instance can be obtained via <code>getUser</code> method on {@link  ZumoKit ZumoKit} instance.
 * <p>
 * See <a target="_top" href="https://developers.zumo.money/docs/guides/manage-user-wallet">Manage User Wallet</a>,
 * <a target="_top" href="https://developers.zumo.money/docs/guides/create-fiat-account">Create Fiat Account</a> and
 * <a target="_top" href="https://developers.zumo.money/docs/guides/view-user-data">View User Data</a>
 * guides for usage details.
 */
public interface User {
    /**
     * Get user id.
     * @return user id
     */
    public String getId();

    /**
     * Get user integrator id.
     * @return user integrator id
     */
    public String getIntegratorId();

    /**
     * Check if user has wallet
     * @return true if user has wallet
     */
    public boolean hasWallet();

    /**
     * Check if user is a fiat customer on 'MAINNET' or 'TESTNET' network.
     * @param  network 'MAINNET' or 'TESTNET'
     * @return true if user is currenly active user.
     * @see    NetworkType
     */
    public boolean isFiatCustomer(String network);

    /**
     * Make user fiat customer on specified network by providing user's personal details.
     * @param  network        'MAINNET' or 'TESTNET'
     * @param  firstName     first name
     * @param  middleName    middle name or null
     * @param  lastName      last name
     * @param  dateOfBirth  date of birth in ISO 8601 format, e.g '2020-08-12'
     * @param  email          email
     * @param  phone          phone number
     * @param  address        home address
     * @param  callback       an interface to receive the result or error
     * @see    NetworkType
     */
    public void makeFiatCustomer(String network, String firstName, String middleName, String lastName, String dateOfBirth, String email, String phone, Address address, SuccessCallback callback);

    /**
     * Create fiat account on specified network and currency code. User must already be fiat customer on specified network.
     * @param  network        'MAINNET' or 'TESTNET'
     * @param  currencyCode  country code in ISO 4217 format, e.g. 'GBP'
     * @param  callback       an interface to receive the result or error
     * @see    Account
     * @see    NetworkType
     */
    public void createFiatAccount(String network, String currencyCode, AccountCallback callback);

    /**
     * Get nominated account details for specified account if it exists.
     * Refer to
     * <a target="_top" href="https://developers.zumo.money/docs/guides/send-transactions#bitcoin">Create Fiat Account</a>
     * for explanation about nominated account.
     * @param  accountId     {@link  Account Account} id
     * @param  callback       an interface to receive the result or error
     * @see AccountFiatProperties
     */
    public void getNominatedAccountFiatProperties(String accountId, AccountFiatPropertiesCallback callback);

    /**
     * Fetch Strong Customer Authentication (SCA) config.
     *
     * @param callback         an interface to receive the result or error
     */
    public void fetchAuthenticationConfig(AuthenticationConfigCallback callback);

    /**
     * Create card for a fiat account.
     * <p>
     * At least one Knowled-Based Authentication (KBA) answer should be defined, answers are limited to 256 characters and 
     * cannot be null or empty and only one answer per question type should be provided.
     * @param  fiatAccountId fiat account id
     * @param  cardType       'VIRTUAL' or 'PHYSICAL'
     * @param  mobileNumber   card holder mobile number, starting with a '+', followed by the country code and then the mobile number
     * @param  callback        an interface to receive the result or error
     * @param  knowledgeBase  list of KBA answers
     * @see    Card
     * @see    CardType
     */
    public void createCard(String fiatAccountId, String cardType, String mobileNumber, ArrayList<KbaAnswer> knowledgeBase, CardCallback callback);

    /**
     * Set card status to 'ACTIVE', 'BLOCKED' or 'CANCELLED'. 
     * - To block card, set card status to 'BLOCKED'. 
     * - To activate a physical card, set card status to 'ACTIVE' and provide PAN and CVV2 fields.
     * - To cancel a card, set card status to 'CANCELLED'.
     * - To unblock a card, set card status to 'ACTIVE.'. 
     * @param  cardId         card id
     * @param  cardStatus     new card status
     * @param  pan             PAN when activating a physical card, null otherwise
     * @param  cvv2            CVV2 when activating a physical card, null otherwise
     * @param  callback        an interface to receive the result or error
     * @see    CardStatus
     */
    public void setCardStatus(String cardId, String cardStatus, String pan, String cvv2, SuccessCallback callback);

    /**
     * Reveals sensitive card details.
     * @param  cardId         card id
     * @param  callback        an interface to receive the result or error
     * @see    CardDetails
     */
    public void revealCardDetails(String cardId, CardDetailsCallback callback);

    /**
     * Reveal card PIN.
     * @param  cardId         card id
     * @param  callback        an interface to receive the result or error
     */
    public void revealPin(String cardId, PinCallback callback);

    /**
     * Unblock card PIN.
     * @param  cardId         card id
     * @param  callback        an interface to receive the result or error
     */
    public void unblockPin(String cardId, SuccessCallback callback);

    /**
     * Add KBA answers to a card without SCA.
     * <p>
     * This endpoint is used to set Knowledge-Based Authentication (KBA) answers to 
     * a card without Strong Customer Authentication (SCA). Once it is set SCA flag 
     * on corresponding card is set to true.
     * <p>
     * At least one answer should be defined, answers are limited to 256 characters and 
     * cannot be null or empty and only one answer per question type should be provided.
     * @param  cardId         card id
     * @param  knowledgeBase  list of KBA answers
     * @param  callback        an interface to receive the result or error
     */
    public void setAuthentication(String cardId, ArrayList<KbaAnswer> knowledgeBase, SuccessCallback callback);

    /**
     * Create user wallet seeded by provided mnemonic and encrypted with user's password.
     * <p>
     * Mnemonic can be generated by <code>generateMnemonic</code> method in {@link  Utils Utils} class.
     * @param  mnemonic       mnemonic seed phrase
     * @param  password       user provided password
     * @param  callback       an interface to receive the result or error
     * @see    Wallet
     */
    public void createWallet(String mnemonic, String password, WalletCallback callback);

    /**
     * Unlock user wallet with user's password.
     * @param  password       user provided password
     * @param  callback       an interface to receive the result or error
     * @see    Wallet
     */
    public void unlockWallet(String password, WalletCallback callback);

    /**
     * Reveal menmonic seed phrase used to seed user wallet.
     * @param  password       user provided password
     * @param  callback       an interface to receive the result or error
     */
    public void revealMnemonic(String password, MnemonicCallback callback);

    /**
     * Check if mnemonic seed phrase corresponds to user's wallet.
     * This is useful for validating seed phrase before trying to recover wallet.
     * @param  mnemonic       mnemonic seed phrase
     * @return true if mnemonic seed phrase corresponds to user's wallet
     */
    public boolean isRecoveryMnemonic(String mnemonic);

    /**
     * Recover user wallet with mnemonic seed phrase corresponding to user's wallet.
     * This can be used if user forgets his password or wants to change his wallet password.
     * @param  mnemonic       mnemonic seed phrase corresponding to user's wallet
     * @param  password       user provided password
     * @param  callback       an interface to receive the result or error
     */
    public void recoverWallet(String mnemonic, String password, WalletCallback callback);

    /**
     * Get account in specific currency, on specific network, with specific type.
     * @param  currencyCode       currency code, e.g. 'BTC', 'ETH' or 'GBP'
     * @param  network             network type, e.g. 'MAINNET', 'TESTNET' or 'RINKEBY'
     * @param  type                account type, e.g. 'STANDARD', 'COMPATIBILITY' or 'SEGWIT'
     * @return account with selected parameters if it exists, null otherwise
     * @see CurrencyCode
     * @see NetworkType
     * @see AccountType
     */
    public Account getAccount(String currencyCode, String network, String type);

    /**
     * Get all user accounts.
     * @return all user accounts
     */
    public ArrayList<Account> getAccounts();

    /**
     * Listen to all account data changes.
     * @param listener interface to listen to user changes
     */
    public void addAccountDataListener(AccountDataListener listener);

    /**
     * Remove listener to account data changes.
     * @param listener interface to listen to user changes
     */
    public void removeAccountDataListener(AccountDataListener listener);

    static final class CppProxy implements User
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
        public String getId()
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_getId(this.nativeRef);
        }
        private native String native_getId(long _nativeRef);

        @Override
        public String getIntegratorId()
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_getIntegratorId(this.nativeRef);
        }
        private native String native_getIntegratorId(long _nativeRef);

        @Override
        public boolean hasWallet()
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_hasWallet(this.nativeRef);
        }
        private native boolean native_hasWallet(long _nativeRef);

        @Override
        public boolean isFiatCustomer(String network)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_isFiatCustomer(this.nativeRef, network);
        }
        private native boolean native_isFiatCustomer(long _nativeRef, String network);

        @Override
        public void makeFiatCustomer(String network, String firstName, String middleName, String lastName, String dateOfBirth, String email, String phone, Address address, SuccessCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_makeFiatCustomer(this.nativeRef, network, firstName, middleName, lastName, dateOfBirth, email, phone, address, callback);
        }
        private native void native_makeFiatCustomer(long _nativeRef, String network, String firstName, String middleName, String lastName, String dateOfBirth, String email, String phone, Address address, SuccessCallback callback);

        @Override
        public void createFiatAccount(String network, String currencyCode, AccountCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_createFiatAccount(this.nativeRef, network, currencyCode, callback);
        }
        private native void native_createFiatAccount(long _nativeRef, String network, String currencyCode, AccountCallback callback);

        @Override
        public void getNominatedAccountFiatProperties(String accountId, AccountFiatPropertiesCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_getNominatedAccountFiatProperties(this.nativeRef, accountId, callback);
        }
        private native void native_getNominatedAccountFiatProperties(long _nativeRef, String accountId, AccountFiatPropertiesCallback callback);

        @Override
        public void fetchAuthenticationConfig(AuthenticationConfigCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_fetchAuthenticationConfig(this.nativeRef, callback);
        }
        private native void native_fetchAuthenticationConfig(long _nativeRef, AuthenticationConfigCallback callback);

        @Override
        public void createCard(String fiatAccountId, String cardType, String mobileNumber, ArrayList<KbaAnswer> knowledgeBase, CardCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_createCard(this.nativeRef, fiatAccountId, cardType, mobileNumber, knowledgeBase, callback);
        }
        private native void native_createCard(long _nativeRef, String fiatAccountId, String cardType, String mobileNumber, ArrayList<KbaAnswer> knowledgeBase, CardCallback callback);

        @Override
        public void setCardStatus(String cardId, String cardStatus, String pan, String cvv2, SuccessCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_setCardStatus(this.nativeRef, cardId, cardStatus, pan, cvv2, callback);
        }
        private native void native_setCardStatus(long _nativeRef, String cardId, String cardStatus, String pan, String cvv2, SuccessCallback callback);

        @Override
        public void revealCardDetails(String cardId, CardDetailsCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_revealCardDetails(this.nativeRef, cardId, callback);
        }
        private native void native_revealCardDetails(long _nativeRef, String cardId, CardDetailsCallback callback);

        @Override
        public void revealPin(String cardId, PinCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_revealPin(this.nativeRef, cardId, callback);
        }
        private native void native_revealPin(long _nativeRef, String cardId, PinCallback callback);

        @Override
        public void unblockPin(String cardId, SuccessCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_unblockPin(this.nativeRef, cardId, callback);
        }
        private native void native_unblockPin(long _nativeRef, String cardId, SuccessCallback callback);

        @Override
        public void setAuthentication(String cardId, ArrayList<KbaAnswer> knowledgeBase, SuccessCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_setAuthentication(this.nativeRef, cardId, knowledgeBase, callback);
        }
        private native void native_setAuthentication(long _nativeRef, String cardId, ArrayList<KbaAnswer> knowledgeBase, SuccessCallback callback);

        @Override
        public void createWallet(String mnemonic, String password, WalletCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_createWallet(this.nativeRef, mnemonic, password, callback);
        }
        private native void native_createWallet(long _nativeRef, String mnemonic, String password, WalletCallback callback);

        @Override
        public void unlockWallet(String password, WalletCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_unlockWallet(this.nativeRef, password, callback);
        }
        private native void native_unlockWallet(long _nativeRef, String password, WalletCallback callback);

        @Override
        public void revealMnemonic(String password, MnemonicCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_revealMnemonic(this.nativeRef, password, callback);
        }
        private native void native_revealMnemonic(long _nativeRef, String password, MnemonicCallback callback);

        @Override
        public boolean isRecoveryMnemonic(String mnemonic)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_isRecoveryMnemonic(this.nativeRef, mnemonic);
        }
        private native boolean native_isRecoveryMnemonic(long _nativeRef, String mnemonic);

        @Override
        public void recoverWallet(String mnemonic, String password, WalletCallback callback)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_recoverWallet(this.nativeRef, mnemonic, password, callback);
        }
        private native void native_recoverWallet(long _nativeRef, String mnemonic, String password, WalletCallback callback);

        @Override
        public Account getAccount(String currencyCode, String network, String type)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_getAccount(this.nativeRef, currencyCode, network, type);
        }
        private native Account native_getAccount(long _nativeRef, String currencyCode, String network, String type);

        @Override
        public ArrayList<Account> getAccounts()
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            return native_getAccounts(this.nativeRef);
        }
        private native ArrayList<Account> native_getAccounts(long _nativeRef);

        @Override
        public void addAccountDataListener(AccountDataListener listener)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_addAccountDataListener(this.nativeRef, listener);
        }
        private native void native_addAccountDataListener(long _nativeRef, AccountDataListener listener);

        @Override
        public void removeAccountDataListener(AccountDataListener listener)
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_removeAccountDataListener(this.nativeRef, listener);
        }
        private native void native_removeAccountDataListener(long _nativeRef, AccountDataListener listener);
    }
}
