import java.io.IOException;
import java.io.InputStream;

public class MyRequest {
    private String url;
    private String method;

    public MyRequest(InputStream inputStream) throws IOException {

        String httpRequest = "";
        byte[] httpRequestbytes = new byte[1024];
        int length = 0;
        if ((length = inputStream.read(httpRequestbytes)) > 0) {
            httpRequest = new String(httpRequestbytes, 0, length);
        }
        String httpHead = httpRequest.split("\n")[0];
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];

    }

    public String getUrl() {
        return this.url;
    }

    public String getMethod() {
        return this.method;
    }
}