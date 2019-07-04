public class SimpleHandlerAdapter implements HandlerAdapter{
    public boolean support(Object controller){
        return controller instanceof SimpleController;
    }
    public void handle(Object controller){
        ((SimpleController)controller).doSimpleHandler();
    }
}