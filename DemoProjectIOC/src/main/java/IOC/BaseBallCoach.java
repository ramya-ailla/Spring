package IOC;

public class BaseBallCoach implements ICoach {
    @Override
    public String getDailyWorkout(){
        return "spend an hour for pitching practise";
    }
}
