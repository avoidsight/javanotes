import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet{
    public static List<HandlerAdapter> handlerList = new ArrayList<HandlerAdapter>();

    public DispatcherServlet(){
        handlerList.add(new AnnotationHandlerAdapter());
        handlerList.add(new SimpleHandlerAdapter());
        handlerList.add(new HttpHandlerAdapter());
    }

    public static void doDispatcher(Controller controller){
        //获得对应适配器
        HandlerAdapter adapter = getHandler(controller);
        //通过适配器去执行相应的方法
        adapter.handle(controller);
    }

    public static HandlerAdapter getHandler(Controller controller){
        for(HandlerAdapter handlerAdapter : handlerList){
            if(handlerAdapter.support(controller)){
                return handlerAdapter;
            }
        }
        return null;
    }
   
    public static void main(String[] args) {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        Controller c = new SimpleController();
        doDispatcher(c);
    }
}