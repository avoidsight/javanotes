package adapter.handleradaper;

public class AnnotationHandlerAdapter implements HandlerAdapter{
    public boolean support(Object controller){
        return controller instanceof AnnotationController;
    }
    public void handle(Object controller){
        ((AnnotationController)controller).doAnnotationHandler();
    }
}