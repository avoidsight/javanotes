package adapter.windowadapter;

//有些窗口只需要关闭
public class MyAdapter extends WindowAdapter {
    public void close() {
        System.out.println("窗口关闭！");
    }
}