package IOC;

public class TrackCoach implements ICoach {
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
