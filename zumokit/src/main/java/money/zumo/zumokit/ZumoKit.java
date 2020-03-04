package money.zumo.zumokit;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public class ZumoKit {
    private ZumoCore zumoCore;

    public static String getVersion()
    {
        return ZumoCore.getVersion();
    }

    static {
        System.loadLibrary("zumocore");
    }

    public ZumoKit(String txServiceUrl, String apiKey, String apiRoot, String myRoot) {
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
        zumoCore = ZumoCore.init(httpImpl, wsImpl, apiKey, apiRoot, myRoot, txServiceUrl);

        // Connect to WebSocket
        wsImpl.connect();
    }

    public void auth(String userToken, HashMap<String, String> headers, AuthCallback callback) { zumoCore.auth(userToken, headers, callback); }

    public Utils utils() { return zumoCore.getUtils(); }

    public State getState() { return zumoCore.getState(); };

    public void addStateListener(StateListener listener) { zumoCore.addStateListener(listener); };

    public void removeStateListener(StateListener listener) { zumoCore.removeStateListener(listener); };
}
