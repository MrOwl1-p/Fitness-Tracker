import java.util.Scanner;

// `Workout` extends `PhysicalActivity`, demonstrating inheritance
//workout extends physical xtvt
public class Workout extends PhysicalActivity implements Trackable {
    private double caloriesBurned;
    private double weight;

    // Constructor
    public Workout(String exerciseType, double duration, double weight) {
        super(exerciseType, duration); // Call parent class constructor
        this.weight = weight;
        this.caloriesBurned = calculateCaloriesBurned(); // Calculate calories burned immediately
    }

    // Overriding abstract method to calculate calories burned
    @Override
    public double calculateCaloriesBurned() {
        double mets = getMETs(getExerciseType()); // Retrieve METs from exercise type
        double intensityModifier = promptIntensity(); // Get user-selected intensity

        // Calories burned calculation
        return (mets *intensityModifier *3.5 *this.weight) / 200 *getDuration();
    }

    // Helper method to get METs (Metabolic Equivalent of Task) for various exercises
    private double getMETs(String exerciseType) {
        switch (exerciseType.toLowerCase()) {
            case "Jogging":
                return 8.0;
            case "Cycling":
                return 5.0;
            case "Gym workout":
                return 7.0;
            case "Walking":
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
                return 1.0; // No change
            case 3:
                return 1.2; // Increase METs by 20%
            default:
                System.out.println("Invalid choice, defaulting to Moderate.");
                return 1.0;
        }
    }

    // Overriding the logActivity method to provide specific details
    @Override
    public void logActivity() {
        super.logActivity(); // Call the parent method (optional)
        System.out.printf("Calories burned: %.2f\n", caloriesBurned);
    }
  // Implementing the `trackProgress` method from `Trackable`
    @Override
    public void trackProgress() {
        System.out.println("Tracking workout progress...");
        System.out.printf("Exercise Type: %s\n", getExerciseType());
        System.out.printf("Duration: %.2f minutes\n", getDuration());
        System.out.printf("Calories Burned: %.2f\n", getCaloriesBurned());
    }

    // Getter for calories burned
    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "exerciseType='" + getExerciseType() + '\'' +
                ", duration=" + getDuration() +
                ", caloriesBurned=" + caloriesBurned +
                ", weight=" + weight +
                '}';
    }
}
