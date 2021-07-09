package adapter.windowadapter;

public class AdapterTest {
    public static void main(String[] args) {
        Window win = new MyAdapter();
        win.close();
    }
}