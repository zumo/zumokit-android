package money.zumo.zumokit;

import java.util.HashMap;

/**
 * Entry point to ZumoKit Android SDK.
 * <p>
 * See <a href="https://developers.zumo.money/docs/guides/getting-started">Getting Started</a> guide for usage details.
 */
public class ZumoKit {
    static {
        System.loadLibrary("zumocore");
    }

    private ZumoCore zumoCore;

    /**
     * Get ZumoKit SDK version.
     *
     * @return semantic version tag if exists, commit hash otherwise
     */
    public static String getVersion() {
        return ZumoCore.getVersion();
    }

    /**
     * Sets log level for current logger.
     *
     * @param logLevel log level, 'trace', 'debug', 'info', 'warning', 'error', 'critical' or 'off'
     */
    public static void setLogLevel(String logLevel) {
        ZumoCore.setLogLevel(logLevel);
    }

    /**
     * Sets log handler for all ZumoKit related logs.
     *
     * @param logListener interface to listen to changes
     * @param logLevel    log level, 'trace', 'debug', 'info', 'warning', 'error', 'critical' or 'off'
     */
    public static void onLog(LogListener logListener, String logLevel) {
        ZumoCore.onLog(logListener, logLevel);
    }

    /**
     * Initializes ZumoKit SDK. Should only be called once.
     *
     * @param apiKey                 ZumoKit API Key
     * @param apiUrl                 ZumoKit API URL
     * @param transactionServiceUrl  ZumoKit Transaction Service URL
     * @param cardServiceUrl         ZumoKit Card Service URL
     * @param notificationServiceUrl ZumoKit Notification Service URL
     */
    public ZumoKit(
            String apiKey,
            String apiUrl,
            String transactionServiceUrl,
            String cardServiceUrl,
            String notificationServiceUrl) {
        // Init the providers needed for the C++ core
        HttpProvider httpProvider = new DefaultHttpProvider();
        WebSocketFactory wsFactory = new DefaultWebSocketFactory();

        // Initialise C++ core library
        zumoCore = ZumoCore.init(
                httpProvider,
                wsFactory,
                apiKey,
                apiUrl,
                transactionServiceUrl,
                cardServiceUrl,
                notificationServiceUrl
        );
    }

    /**
     * Signs in user corresponding to user token set. Sets current user to the newly signed in user.
     * Refer to <a href="https://developers.zumo.money/docs/setup/server#get-zumokit-user-token">Server</a> guide for details on how to get user token set.
     *
     * @param userTokenSet user token set
     * @param callback     an interface to receive the result or error
     * @see User
     */
    public void signIn(String userTokenSet, UserCallback callback) {
        zumoCore.signIn(userTokenSet, callback);
    }

    /**
     * Signs out current user.
     */
    public void signOut() {
        zumoCore.signOut();
    }

    /**
     * Get currently signed-in user or null.
     *
     * @return current user or null
     */
    public User getCurrentUser() {
        return zumoCore.getCurrentUser();
    }

    /**
     * Get crypto utils.
     *
     * @return crypto utils
     */
    public Utils getUtils() {
        return zumoCore.getUtils();
    }

    /**
     * Get exchange rate for selected currency pair.
     *
     * @param fromCurrency currency code
     * @param toCurrency   currency code
     * @return exchange rate or null
     */
    public ExchangeRate getExchangeRate(String fromCurrency, String toCurrency) {
        return zumoCore.getExchangeRate(fromCurrency, toCurrency);
    }

    /**
     * Get all available exchange rates.
     *
     * @return mapping between currency pairs and exchange rates
     */
    public HashMap<String, HashMap<String, ExchangeRate>> getExchangeRates() {
        return zumoCore.getExchangeRates();
    }

    /**
     * Get exchange setting for selected currency pair.
     *
     * @param fromCurrency currency code
     * @param toCurrency   currency code
     * @return exchange setting or null
     */
    public ExchangeSetting getExchangeSetting(String fromCurrency, String toCurrency) {
        return zumoCore.getExchangeSetting(fromCurrency, toCurrency);
    }

    /**
     * Get all available exchange settings.
     *
     * @return mapping between currency pairs and exchange settings
     */
    public HashMap<String, HashMap<String, ExchangeSetting>> getExchangeSettings() {
        return zumoCore.getExchangeSettings();
    }

    /**
     * Get transaction fee rate for selected crypto currency.
     *
     * @param currency currency code
     * @return transaction fee rate or null
     */
    public TransactionFeeRate getTransactionFeeRate(String currency) {
        return zumoCore.getTransactionFeeRate(currency);
    }

    /**
     * Get all available crypto transaction fee rates.
     *
     * @return mapping between cryptocurrencies and transaction fee rate
     */
    public HashMap<String, TransactionFeeRate> getTransactionFeeRates() {
        return zumoCore.getTransactionFeeRates();
    }

    /**
     * Fetch historical exchange rates for supported time intervals.
     * On success callback returns historical exchange rates are contained
     * in a mapping between time interval on a top level, from currency on second level,
     * to currency on third level and {@link  ExchangeRate ExchangeRate} objects.
     *
     * @param callback an interface to receive the result or error
     * @see TimeInterval
     */
    public void fetchHistoricalExchangeRates(HistoricalExchangeRatesCallback callback) {
        zumoCore.fetchHistoricalExchangeRates(callback);
    }

    /**
     * Listen to changes in current user’s sign in state, exchange rates, exchange
     * settings or transaction fee rates.
     *
     * @param listener interface to listen to changes
     */
    public void addChangeListener(ChangeListener listener) {
        zumoCore.addChangeListener(listener);
    }

    /**
     * Remove change listener.
     *
     * @param listener interface to listen to changes
     */
    public void removeChangeListener(ChangeListener listener) {
        zumoCore.removeChangeListener(listener);
    }
}
