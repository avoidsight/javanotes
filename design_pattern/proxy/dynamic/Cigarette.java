package proxy.dynamic;

//这是卖烟的
public class Cigarette implements License {
    private String name;

    Cigarette(String name) {
        this.name = name;
    }

    public void sell() {
        System.out.println("这里卖的是" + this.name + "。");
    }
}