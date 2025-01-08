
public class ProgressTracker {
    private double dietProgress;
    private String goalStatus;

    public double getDietProgress() {
        return this.dietProgress;
    }

    public void setDietProgress(double dietProgress) {
        this.dietProgress = dietProgress;
    }

    public String getGoalStatus() {
        return this.goalStatus;
    }

    public void setGoalStatus(String goalStatus) {
        this.goalStatus = goalStatus;
    }

    public void updateProgress(Goal goal) {
        this.dietProgress = goal.calculateDietPercentage();
        if (goal.checkGoalCompletion()) {
            this.goalStatus = "Goal Completed!";
        } else {
            this.goalStatus = "In Progress";
        }
    }

    public void displayProgress() {
        System.out.println("Progress: " + dietProgress + "%");
        System.out.println("Status: " + goalStatus);
    }

}
