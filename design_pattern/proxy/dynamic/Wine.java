//这是一个卖酒的
public class Wine implements License{
    public String name;

    Wine(String name){
        this.name = name;
    }

    public void sell(){
        System.out.println("这里卖的是"+this.name+"。");
    }
}