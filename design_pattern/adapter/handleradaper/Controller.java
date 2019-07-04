//空接口，只是一个标识，一般用insteadOf来测试这个对象属不属于该类
//比如Serializable接口，他也是个空接口，在序列化时会判断这个对象是不是实现Serializable接口的对象，如果没实现，则报异常。
public interface Controller {

}