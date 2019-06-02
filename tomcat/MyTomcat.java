import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MyTomcat{
    private int port = 8080;
    private Map<String,String> urlServlet = new HashMap<>();

    public MyTomcat(int port){
        this.port = port;
    }

    public void initServletMapping(){
        for(ServletMapping servletMapping : ServletMappingConfig.servletMappingList){
            urlServlet.put(servletMapping.getUrl(), servletMapping.getClazz());
        }
    }

    public void dispatch(MyRequest myRequest,MyRespond myRespond){
        String clazz = urlServlet.get(myRequest.getUrl());

        try {
            Class myServletClass = Class.forName(clazz);
            MyServlet myServlet = (MyServlet)myServletClass.newInstance();
            myServlet.service(myRequest, myRespond);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){

        initServletMapping();
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("My tomcat is running...");

            while(true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                MyRequest myRequest = new MyRequest(inputStream);
                MyRespond myRespond = new MyRespond(outputStream);

                dispatch(myRequest, myRespond);

                socket.close();
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }finally{
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
    }
}