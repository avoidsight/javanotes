public class HelloWorldServlet extends MyServlet {

    @Override
    public void doGet(MyRequest myRequest, MyRespond myRespond) {
        try {
            myRespond.write("get world...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyRespond myRespond) {
        try {
            myRespond.write("post world...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}