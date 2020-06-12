package money.zumo.zumokit;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import android.util.Log;

import java.net.URI;
import java.nio.ByteBuffer;

public class WebSocketService extends WebSocketClient implements WebSocketImpl {
    private WebSocketListener wsListener;
    private final FuzzingBackOffGenerator backOffGenerator;

    public WebSocketService(URI serverURI) {
        super(serverURI);
        backOffGenerator = new FuzzingBackOffGenerator(1 * 1000, 30 * 60 * 1000, 0.5);
    }

    public void subscribe(WebSocketListener listener) {
        wsListener = listener;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        backOffGenerator.reset();
        wsListener.onOpen(this.uri.toString());
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        WebSocketService activeWs = this;
        wsListener.onClose("closed with exit code " + code + ", additional info: " + reason);
        setTimeout(new Runnable() {
            @Override
            public void run() {
               activeWs.reconnect();
            }
        }, backOffGenerator.next().targetDelay);
    }

    @Override
    public void onMessage(String message) {
        wsListener.onMessage(message);
    }

    @Override
    public void onMessage(ByteBuffer message) {
        Log.i("zumokit-ws", "received ByteBuffer");
    }

    @Override
    public void onError(Exception e) { wsListener.onError(e.toString()); }

    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }
}
