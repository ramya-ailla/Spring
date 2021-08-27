package IOC;

public class MyApp {
    public static void main(String[] args) {
        ICoach o = new TrackCoach();
        System.out.println( o.getDailyWorkout());
    }
}
