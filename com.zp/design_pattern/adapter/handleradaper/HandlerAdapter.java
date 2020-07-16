package adapter.handleradaper;

public interface HandlerAdapter{
    boolean support(Object controller);
    void handle(Object controller);
}