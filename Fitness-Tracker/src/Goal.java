import java.util.Scanner;

public class Goal {
    private int goalType;
    private double targetValue;
    private double currentValue;
    private static final String[] GOAL_TYPES = { "Weight Loss", "Muscle Gain" }; // Array untuk goal types

    public Goal(int goalType, double targetValue, double currentValue) {
        this.goalType = goalType;
        this.targetValue = targetValue;
        this.currentValue = currentValue;
    }

    public void updateProgress(int progress) {
        this.currentValue += progress;
        if (goalType == 1 && this.currentValue < targetValue) {
            this.currentValue = targetValue; // For weight loss, currentValue cannot go below targetValue
        } else if (goalType == 2 && this.currentValue > targetValue) {
            this.currentValue = targetValue; // For weight gain, currentValue cannot exceed targetValue
        }
    }

    public boolean checkGoalCompletion() {
        return (goalType == 1 && currentValue == targetValue) || (goalType == 2 && currentValue == targetValue);
    }

    public int getGoalType() {
        return this.goalType;
    }

    public void setGoalType(int goalType) {
        this.goalType = goalType;
    }

    public double getTargetValue() {
        return this.targetValue;
    }

    public void setTargetValue(double targetValue) {
        this.targetValue = targetValue;
    }

    public double getCurrentValue() {
        return this.currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;

    }

    public double calculateDietPercentage() {
        if (goalType == 1) { // Weight Loss
            return 100 - (((currentValue - targetValue) / (targetValue)) * 100);
        } else { // Weight Gain
            return ((currentValue / targetValue) * 100);
        }
    }

    public static Goal userGoal(int goalType, double currentWeight) {
        Scanner scanner = new Scanner(System.in);

        if (goalType < 1 || goalType > GOAL_TYPES.length) {
            System.out.println("Invalid goal type. Please enter a valid goal type.");
            return null;
        }

        System.out.print("Enter target Weight: ");
        double targetValue = scanner.nextDouble();

        String goalName = GOAL_TYPES[goalType - 1];
        System.out.println(goalName);

        return new Goal(goalType, targetValue, currentWeight);

    }

    public String getGoalTypeName() {
        return (goalType >= 1 && goalType <= GOAL_TYPES.length) ? GOAL_TYPES[goalType - 1] : "Unknown";
    }

    @Override
    public String toString() {
        String goalTypeName = (goalType >= 1 && goalType <= GOAL_TYPES.length) ? GOAL_TYPES[goalType - 1] : "Unknown";
        return "Goal Type: " + goalTypeName + ", Target: " + targetValue + ", Current: " + currentValue;
    }

}
