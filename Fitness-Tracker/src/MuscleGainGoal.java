public class MuscleGainGoal extends Goal {
    public MuscleGainGoal(double targetValue, double currentValue) {
        super(targetValue, currentValue);
    }

    @Override
    public String getGoalTypeName() {
        return "Muscle Gain";
    }

    @Override
    public double calculateDietPercentage() {
        return ((getCurrentValue() / getTargetValue()) * 100);
    }
}