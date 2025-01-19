public class WeightLossGoal extends Goal {
    public WeightLossGoal(double targetValue, double currentValue) {
        super(targetValue, currentValue);
    }

    @Override
    public String getGoalTypeName() {
        return "Weight Loss";
    }

    @Override
    public double calculateDietPercentage() {
        return 100 - (((getCurrentValue() - getTargetValue()) / getTargetValue()) * 100);
    }
}