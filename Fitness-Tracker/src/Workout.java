
public class Workout {
    private String exerciseType;
    private double duration;
    private double caloriesBurned;

    public Workout(String exerciseType, double duration) {
        this.exerciseType = exerciseType;
        this.duration = duration;
        this.caloriesBurned = calculateCaloriesBurned();
    }

    public double calculateCaloriesBurned() {
        // Simplified calculation: duration * 5
        return duration * 5;
    }

    public void logWorkout() {
        System.out.println("Workout logged: " + exerciseType + " for " + duration + " mins.");
    }

    public String getExerciseType() {
        return this.exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public double getDuration() {
        return this.duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getCaloriesBurned() {
        return this.caloriesBurned;
    }

    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

}
