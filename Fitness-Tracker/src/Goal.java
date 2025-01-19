public abstract class Goal {
    private double targetValue;
    private double currentValue;

    public Goal(double targetValue, double currentValue) {
        this.targetValue = targetValue;
        this.currentValue = currentValue;
    }

    public double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(double targetValue) {
        this.targetValue = targetValue;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public abstract String getGoalTypeName();

    public boolean checkGoalCompletion() {
        return Math.abs(currentValue - targetValue) < 0.01;
    }

    public abstract double calculateDietPercentage();

    @Override
    public String toString() {
        return "Goal Type: " + getGoalTypeName() + ", Target: " + targetValue + ", Current: " + currentValue;
    }
}
