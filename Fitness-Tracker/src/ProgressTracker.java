
public class ProgressTracker {
    private double[] weeklyProgress;
    private double[] monthlyProgress;
    private String goalStatus;

    public ProgressTracker() {
        weeklyProgress = new double[7];
        monthlyProgress = new double[30];
        goalStatus = "In Progress";
    }

    public void generateProgressReport() {
        double totalProgress = 0;
        for (double progress : weeklyProgress) {
            totalProgress += progress;
        }
        System.out.println("Weekly progress: " + totalProgress + " points.");
    }

    public void displayProgressChart() {
        System.out.println("Displaying progress chart...");
    }

    public double[] getWeeklyProgress() {
        return this.weeklyProgress;
    }

    public void setWeeklyProgress(double[] weeklyProgress) {
        this.weeklyProgress = weeklyProgress;
    }

    public double[] getMonthlyProgress() {
        return this.monthlyProgress;
    }

    public void setMonthlyProgress(double[] monthlyProgress) {
        this.monthlyProgress = monthlyProgress;
    }

    public String getGoalStatus() {
        return this.goalStatus;
    }

    public void setGoalStatus(String goalStatus) {
        this.goalStatus = goalStatus;
    }

}
