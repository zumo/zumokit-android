package money.zumo.zumokit;

import java.net.URI;
import java.net.URISyntaxException;

public class ZumoKit {
    private ZumoCore zumoCore;

    public static String getVersion()
    {
        return ZumoCore.getVersion();
    }

    static {
        System.loadLibrary("zumocore");
    }

    public ZumoKit(String apiKey, String apiRoot, String txServiceUrl) {
        // HTTP implementation
        HttpImpl httpImpl = new AndroidHttp();

        // WebSocket implementation
        URI uri;
        try {
            uri = new URI(txServiceUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        AndroidWebSocket wsImpl = new AndroidWebSocket(uri);

        // initialise C++ core library
        zumoCore = ZumoCore.init(httpImpl, wsImpl, apiKey, apiRoot, txServiceUrl);

        // Connect to WebSocket
        wsImpl.connect();
    }

    public void getUser(String userToken, UserCallback callback) { zumoCore.getUser(userToken, callback); }

    public Utils utils() { return zumoCore.getUtils(); }

    public State getState() { return zumoCore.getState(); };

    public void getHistoricalExchangeRates(HistoricalExchangeRatesCallback callback) { zumoCore.getHistoricalExchangeRates(callback); }

    public void addStateListener(StateListener listener) { zumoCore.addStateListener(listener); };

    public void removeStateListener(StateListener listener) { zumoCore.removeStateListener(listener); };
}
