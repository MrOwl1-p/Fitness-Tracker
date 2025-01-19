public abstract class PhysicalActivity {
    private String exerciseType;
    private double duration;

    // Constructor
    public PhysicalActivity(String exerciseType, double duration) {
        this.exerciseType = exerciseType;
        this.duration = duration;
    }

    // Abstract method to calculate calories burned
    public abstract double calculateCaloriesBurned();

    // Getter methods
    public String getExerciseType() {
        return exerciseType;
    }

    public double getDuration() {
        return duration;
    }

    // Log activity details (can be overridden by subclasses)
    public void logActivity() {
        System.out.printf("\nActivity logged: %s for %.2f mins.\n", exerciseType, duration);
    }

    // Overriding `toString` for activity details
    @Override
    public String toString() {
        return "PhysicalActivity{" +
                "exerciseType='" + exerciseType + '\'' +
                ", duration=" + duration +
                '}';
    }
}
