package adapter.handleradaper;

public class HttpHandlerAdapter implements HandlerAdapter{
    public boolean support(Object controller){
        return controller instanceof HttpController;
    }
    public void handle(Object controller){
        ((HttpController)controller).doHttpHandler();
    }
}