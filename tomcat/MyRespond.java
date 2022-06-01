import java.io.IOException;
import java.io.OutputStream;

public class MyRespond {

    private OutputStream outputStream;

    public MyRespond(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String content) throws IOException {
        StringBuffer httpRespond = new StringBuffer();
        httpRespond.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("</body></html>");

        outputStream.write(httpRespond.toString().getBytes());
        outputStream.close();
    }
}