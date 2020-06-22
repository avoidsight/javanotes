import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig{
    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    static{
    servletMappingList.add(new ServletMapping("findGirl", "/girl", "FindGirlServlet"));
    servletMappingList.add(new ServletMapping("helloworld", "/world", "HelloWorldServlet"));
    }
}
