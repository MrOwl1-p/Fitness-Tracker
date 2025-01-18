import java.util.Scanner;

public class Workout {
    private String exerciseType;
    private double duration;
    private double caloriesBurned;
    private double getWeight;

    public Workout(String exerciseType, double duration) {
        this.exerciseType = exerciseType;
        this.duration = duration;
          calculateCaloriesBurned();
    }


    public void logWorkout() {
        System.out.println("Workout logged: " + exerciseType + " for " + duration + " mins.");
    }

    public String getExerciseType() {
        return this.exerciseType;
    }

    public void setExerciseType(String exerciseType) {

        try (Scanner scanner = new Scanner(System.in)) {
        String[] allowedExercises = {"Jogging", "Gym_Workout", "Cycling"};
        System.out.println("Select Exercise Type:");
        for (int i = 0; i < allowedExercises.length; i++) {
            System.out.println((i + 1) + ". " + allowedExercises[i]);
        }
        System.out.print("Enter your choice (1-" + allowedExercises.length + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice >= 1 && choice <= allowedExercises.length) {
            this.exerciseType = allowedExercises[choice - 1]; 
        } else {
            System.out.println("Invalid choice. Defaulting to Jogging.");
            this.exerciseType = allowedExercises[0]; 
        }
    }
    }//test

    public double getDuration() {
        return this.duration;
    }

    public void setDuration(double duration) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter duration of workout in minutes: ");
            this.duration = scanner.nextDouble();
        }
    }

    public double getCaloriesBurned() {
        return this.caloriesBurned;
    }

    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    private void calculateCaloriesBurned() {
        double mets = getMETs(exerciseType); // ni promp

        
        double intensityModifier = promptIntensity();

        // Calculation untuk calories
        this.caloriesBurned = (mets * intensityModifier * 3.5 * getWeight()) / 200 * duration;
            }
        
            private double getMETs(String exerciseType) {
        switch (exerciseType.toLowerCase()) {
            case "jogging":
                return 8; 
            case "walking":
                return 3.5; 
            case "cycling":
                return 5; 
            case "gym workout":
                return 7; 
            default:
                return 5; 
        }
    }

    private double promptIntensity() {
        try (Scanner scanner = new Scanner(System.in)){
        System.out.println("Select Intensity Level (optional):");
        System.out.println("1. Light (reduce METs by 20%)");
        System.out.println("2. Moderate (no change)");
        System.out.println("3. Vigorous (increase METs by 20%)");
        System.out.print("Enter your choice (1-3, or press Enter to skip): ");

        String choice = scanner.nextLine();
        if (choice.isEmpty()) {
            return 1; // ni defaukt
        
        }

        int choiceInt = Integer.parseInt(choice);
        if (choiceInt == 1) {
            return 0.8; 
        } else if (choiceInt == 3) {
            return 1.2; 
        } else {
            return 1; 
        }
        
    }
    }

}
