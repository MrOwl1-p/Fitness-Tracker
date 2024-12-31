public class Goal {
    private String goalType;
    private int targetValue;
    private int currentValue;

    public Goal(String goalType, int targetValue) {
        this.goalType = goalType;
        this.targetValue = targetValue;
        this.currentValue = 0;
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

        // Implement the logic to convert a string to a Goal object

        // For example, you can use a switch statement or if-else conditions

        switch (goalType.toUpperCase()) {

            case "WEIGHT_LOSS":

                return new Goal("WEIGHT_LOSS", 0); 

            case "MUSCLE_GAIN":

                return new Goal("MUSCLE_GAIN", 0);

            // Add more cases as needed

            default:

                throw new IllegalArgumentException("Unknown goal type: " + goalType);

        }

    }

}
