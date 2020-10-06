package money.zumo.zumokit;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Entry point to ZumoKit Android SDK.
 * <p>
 * See <a href="https://developers.zumo.money/docs/guides/getting-started">Getting Started</a> guide for usage details.
 * */
public class ZumoKit {
    private ZumoCore zumoCore;

    /**
     * Get ZumoKit SDK version.
     * @return semantic version tag if exists, commit hash otherwise
     */
    public static String getVersion()
    {
        return ZumoCore.getVersion();
    }

    static {
        System.loadLibrary("zumocore");
    }

    /**
     * Initializes ZumoKit SDK. Should only be called once.
     *
     * @param apiKey        ZumoKit Api-Key
     * @param apiUrl        ZumoKit API url
     * @param txServiceUrl  ZumoKit Transaction Service url
     */
    public ZumoKit(String apiKey, String apiUrl, String txServiceUrl) {
        // HTTP implementation
        HttpImpl httpImpl = new HttpService();

        // WebSocket implementation
        URI uri;
        try {
            uri = new URI(txServiceUrl.replace("https", "wss"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        WebSocketService wsImpl = new WebSocketService(uri);

        // initialise C++ core library
        zumoCore = ZumoCore.init(httpImpl, wsImpl, apiKey, apiUrl, txServiceUrl);

        // Connect to WebSocket
        wsImpl.connect();
    }

    /**
     * Authenticates user token set and returns corresponding user. On success user is set as active user.
     * Refer to <a href="https://developers.zumo.money/docs/setup/server#get-zumokit-user-token">Server</a> guide for details on how to get user token set.
     *
     * @param userTokenSet   user token set
     * @param callback       an interface to receive the result or error
     *
     * @see User
     */
    public void authUser(String userTokenSet, UserCallback callback) {
        zumoCore.authUser(userTokenSet, callback);
    }

    /**
     * Get active user if exists.
     *
     * @return active user or null
     */
    public User getActiveUser() {
        return zumoCore.getActiveUser();
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
     * @param fromCurrency   currency code
     * @param toCurrency     currency code
     */
    public ExchangeRate getExchangeRate(String fromCurrency, String toCurrency) {
        return zumoCore.getExchangeRate(fromCurrency, toCurrency);
    }

    /**
     * Get exchange settings for selected currency pair.
     *
     * @param fromCurrency   currency code
     * @param toCurrency     currency code
     */
    public ExchangeSettings getExchangeSettings(String fromCurrency, String toCurrency) {
        return zumoCore.getExchangeSettings(fromCurrency, toCurrency);
    }

    /**
     * Get exchange fee rates for selected currency.
     *
     * @param currency   currency code
     */
    public FeeRates getFeeRates(String currency) {
        return zumoCore.getFeeRates(currency);
    }

    /**
     * Fetch historical exchange rates for supported time intervals.
     * On success callback returns historical exchange rates are contained in a mapping between
     *  time interval on a top level, from currency on second level, to currency on third level and {@link  ExchangeRate ExchangeRate} objects.
     *
     * @param callback         an interface to receive the result or error
     *
     * @see HistoricalExchangeRatesInterval
     */
    public void fetchHistoricalExchangeRates(HistoricalExchangeRatesCallback callback) {
        zumoCore.fetchHistoricalExchangeRates(callback);
    }

}
