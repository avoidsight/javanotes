public class CinemaProxy implements Movie{
    public CurrentMovie currentMovie;

    CinemaProxy(CurrentMovie currentMovie){
        this.currentMovie = currentMovie;
    }

    public void play(){
        before();
        currentMovie.play();
        after();
    }

    public void before() {
        System.out.println("电影即将开始...");        
    }

    public void after() {
        System.out.println("电影即将技术...");
    }
}

