package money.zumo.zumokit;

import java.net.URI;

public class DefaultWebSocketFactory implements WebSocketFactory {
    public DefaultWebSocket createWebSocket(String url) {
        DefaultWebSocket wsImpl;
        wsImpl = new DefaultWebSocket(URI.create(url));
        return wsImpl;
    }
}
