import java.util.Scanner;

public class Goal {
    private String goalType;
    private int targetValue;
    private int currentValue;

    public Goal(String goalType, int targetValue, int currentValue) {
        this.goalType = goalType;
        this.targetValue = targetValue;
        this.currentValue = currentValue;
    }

    public void updateProgress(int progress) {
        this.currentValue += progress;
    }

    public boolean checkGoalCompletion() {
        return currentValue >= targetValue;
    }

    public String getGoalType() {
        return this.goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public int getTargetValue() {
        return this.targetValue;
    }

    public void setTargetValue(int targetValue) {
        this.targetValue = targetValue;
    }

    public int getCurrentValue() {
        return this.currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public static Goal valueOf(String goalType) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter target value: ");
        int targetValue = scanner.nextInt();

        System.out.print("Enter current value: ");
        int currentValue = scanner.nextInt();
        scanner.close();

        switch (goalType.toUpperCase()) { // switch case for goal type
            case "1":
                System.out.println("Weight Loss");
                return new Goal("1", targetValue, currentValue);
            case "2":
                System.out.println("Muscle Gain");
                return new Goal("2", targetValue, currentValue);
            default:
                System.out.println("Invalid goal type. Please enter a valid goal type.");
                return null;
        }

    }

}
