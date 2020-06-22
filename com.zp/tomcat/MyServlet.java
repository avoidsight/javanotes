public abstract class MyServlet{
    public abstract void doGet(MyRequest myRequest,MyRespond myRespond);

    public abstract void doPost(MyRequest myRequest,MyRespond myRespond);

    public void service(MyRequest myRequest,MyRespond myRespond){
        if(myRequest.getMethod().equalsIgnoreCase("GET")){
            doGet(myRequest, myRespond);
        }else if(myRequest.getMethod().equalsIgnoreCase("POST")){
            doPost(myRequest, myRespond);
        }
    }
}