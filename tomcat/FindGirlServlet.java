import java.io.IOException;

public class FindGirlServlet extends MyServlet {

    @Override
    public void doGet(MyRequest myRequest, MyRespond myRespond) {
        try {
            myRespond.write("get girl...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyRespond myRespond) {
        try {
            myRespond.write("post girl...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}