/**
 * 用户只关心接口的功能，并不关心接口是谁实现的
 */
public class Customer{

    public static void main(String[] args) {
        CurrentMovie c = new CurrentMovie("绿皮书");
        Movie movie = new CinemaProxy(c);
        movie.play();
    }
}