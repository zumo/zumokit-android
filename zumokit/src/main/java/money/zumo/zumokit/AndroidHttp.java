package money.zumo.zumokit;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AndroidHttp implements HttpImpl {
    private Executor mExecutor;

    public AndroidHttp() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
        mExecutor = new ThreadPoolExecutor(1, 20, 60, TimeUnit.SECONDS, workQueue);
    }

    public void request(final String urlString, final String method, HashMap<String, String> headers, final String postData, final HttpCallback callback) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Boolean success = false;
                short httpCode = 0;
                String response = "";

                try {
                    URL url = new URL(urlString);

                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                    switch(method) {
                        case "GET":
                            break;
                        case "PUT":
                            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        case "POST":
                        case "DELETE":
                            urlConnection.setChunkedStreamingMode(0);
                        default:
                            urlConnection.setRequestMethod(method);
                            urlConnection.setDoOutput(true);
                    }

                    for (java.util.Map.Entry<String, String> entry : headers.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        urlConnection.setRequestProperty(key, value);
                    }

                    if (postData != null) {
                        OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());

                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
                        writer.write(postData);
                        writer.flush();
                        writer.close();
                        out.close();
                    }

                    httpCode = (short)urlConnection.getResponseCode();

                    try {
                        InputStream inputStream;
                        if (httpCode != HttpURLConnection.HTTP_OK)
                            inputStream = urlConnection.getErrorStream();
                        else
                            inputStream = urlConnection.getInputStream();

                        BufferedInputStream iStream = new BufferedInputStream(inputStream);
                        response = getString(iStream, "UTF-8");
                        iStream.close();
                    } catch (Exception e) {
                        response = "";
                    } finally {
                        urlConnection.disconnect();
                    }

                    success = true;
                } catch (Exception e) {
                    callback.onNetworkError(e.getMessage());
                }

                if (success) {
                    callback.onSuccess(httpCode, response);
                }
            }
        });
    }

    private static String getString(InputStream stream, String charsetName) throws IOException
    {
        int n = 0;
        char[] buffer = new char[1024 * 4];
        InputStreamReader reader = new InputStreamReader(stream, charsetName);
        StringWriter writer = new StringWriter();
        while (-1 != (n = reader.read(buffer))) {
            writer.write(buffer, 0, n);
        }
        return writer.toString();
    }
}