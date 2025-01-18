import java.util.Scanner;

public class Workout {
    private String exerciseType;
    private double duration;
    private double caloriesBurned;
    private double weight;

    // Constructor
    public Workout(String exerciseType, double duration, double weight) {
        this.exerciseType = exerciseType;
        this.duration = duration;
        this.weight = weight;
        calculateCaloriesBurned(); // Calculate calories burned immediately upon creation
    }

    // Method to calculate calories burned
    private void calculateCaloriesBurned() {
        double mets = getMETs(exerciseType); // Retrieve METs based on exercise type
        double intensityModifier = promptIntensity(); // Get user-selected intensity

        // Calories burned calculation
        this.caloriesBurned = (mets * intensityModifier * 3.5 * this.weight) / 200 * this.duration;
    }

    // Method to get METs (Metabolic Equivalent of Task) for various exercises
    private double getMETs(String exerciseType) {
        switch (exerciseType.toLowerCase()) {
            case "jogging":
                return 8.0;
            case "cycling":
                return 5.0;
            case "gym workout":
                return 7.0;
            case "walking":
                return 3.5;
            default:
                return 5.0; // Default MET value for unrecognized activities
        }
    }

    // Method to prompt user for intensity level and adjust METs accordingly
    private double promptIntensity() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSelect Intensity Level:");
        System.out.println("1. Light (reduce METs by 20%)");
        System.out.println("2. Moderate (no change)");
        System.out.println("3. Vigorous (increase METs by 20%)");
        System.out.print("Enter your choice (1-3): ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return 0.8; // Reduce METs by 20%
            case 2:
                return 1.0; // Reduce METs by 20%    
            case 3:
                return 1.2; // Increase METs by 20%
        }
                return choice;
    }

    // Getter methods
    public String getExerciseType() {
        return exerciseType;
    }

    public double getDuration() {
        return duration;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    // Method to log the workout details
    public void logWorkout() {
        System.out.printf("\nWorkout logged: %s for %.2f mins. Calories burned: %.2f\n", exerciseType, duration, caloriesBurned);
    }

    // Overriding `toString` to represent Workout object details
    @Override
    public String toString() {
        return "Workout{" +
                "exerciseType='" + exerciseType + '\'' +
                ", duration=" + duration +
                ", caloriesBurned=" + caloriesBurned +
                ", weight=" + weight +
                '}';
    }
}
