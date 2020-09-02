package money.zumo.zumokit;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Entry point to ZumoKit Android SDK.
 * <p>
 * Once ZumoKit is {@linkplain #ZumoKit initialized}, this class provides access to {@linkplain #getUser user retrieval},
 * {@linkplain #getState ZumoKit state object}, {@linkplain #utils crypto utility class} and
 * {@linkplain #getHistoricalExchangeRates historical exchange rates}.
 * State change listeners can be  {@linkplain #addStateListener added} and {@linkplain #removeStateListener removed}.
 * <p>
 * See <a target="_top" href="https://developers.zumo.money/docs/guides/getting-started">Getting Started</a> guide for usage details.
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
     * @param apiKey          ZumoKit Api-Key
     * @param apiRoot         ZumoKit API url
     * @param txServiceUrl  ZumoKit Transaction Service url
     */
    public ZumoKit(String apiKey, String apiRoot, String txServiceUrl) {
        // HTTP implementation
        HttpImpl httpImpl = new HttpService();

        // WebSocket implementation
        URI uri;
        try {
            uri = new URI(txServiceUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        WebSocketService wsImpl = new WebSocketService(uri);

        // initialise C++ core library
        zumoCore = ZumoCore.init(httpImpl, wsImpl, apiKey, apiRoot, txServiceUrl);

        // Connect to WebSocket
        wsImpl.connect();
    }

    /**
     * Get user corresponding to user token set.
     * Refer to <a target="_top" href="https://developers.zumo.money/docs/setup/server#get-zumokit-user-token">Server</a> guide for details on how to get user token set.
     *
     * @param userTokenSet   user token set
     * @param callback       an interface to receive the result or error
     *
     * @see User
     */
    public void getUser(String userTokenSet, UserCallback callback) { zumoCore.getUser(userTokenSet, callback); }

    /**
     * Get crypto utils.
     *
     * @return crypto utils
     */
    public Utils utils() { return zumoCore.getUtils(); }

    /**
     * Returns current ZumoKit state. Refer to <a target="_top" href="https://developers.zumo.money/docs/guides/zumokit-state">ZumoKit State</a> guide for details.
     *
     * @return current ZumoKit state
     */
    public State getState() { return zumoCore.getState(); };

    /**
     * Fetch historical exchange rates for supported time intervals.
     * On success callback returns historical exchange rates are contained in a mapping between
     *  time interval on a top level, from currency on second level, to currency on third level and {@link  ExchangeRate ExchangeRate} objects.
     *
     * @param callback         an interface to receive the result or error
     *
     * @see HistoricalExchangeRatesInterval
     */
    public void getHistoricalExchangeRates(HistoricalExchangeRatesCallback callback) { zumoCore.getHistoricalExchangeRates(callback); }

    /**
     * Listen to all state changes. Refer to <a target="_top" href="https://developers.zumo.money/docs/guides/zumokit-state#listen-to-state-changes">ZumoKit State</a> guide for details.
     *
     * @param listener interface to listen to state changes
     */
    public void addStateListener(StateListener listener) { zumoCore.addStateListener(listener); };

    /**
     * Remove listener to state changes. Refer to <a target="_top" href="https://developers.zumo.money/docs/guides/zumokit-state#remove-state-listener">ZumoKit State</a> guide for details.
     *
     * @param listener interface to listen to state changes
     */
    public void removeStateListener(StateListener listener) { zumoCore.removeStateListener(listener); };
}
