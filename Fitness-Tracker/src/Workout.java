import java.util.Scanner;

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

        try (Scanner scanner = new Scanner(System.in)) {
        String[] allowedExercises = {"Jogging", "Walking", "Cycling"};
        System.out.println("Select Exercise Type:");
        for (int i = 0; i < allowedExercises.length; i++) {
            System.out.println((i + 1) + ". " + allowedExercises[i]);
        }
        System.out.print("Enter your choice (1-" + allowedExercises.length + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice >= 1 && choice <= allowedExercises.length) {
            this.exerciseType = allowedExercises[choice - 1]; 
        } else {
            System.out.println("Invalid choice. Defaulting to Jogging.");
            this.exerciseType = allowedExercises[0]; 
        }
    }
    }

    public double getDuration() {

        try (Scanner scanner = new Scanner(System.in)){
        System.out.print("Enter duration of workout in minutes: ");
        return scanner.nextDouble();
        }
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
