public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Create a goal
        Goal weightLossGoal = new Goal("Weight Loss", 10);

        // Create a user
        User user = new User("John Doe", 25, 75, 1.75, weightLossGoal);

        // Log workouts
        Workout workout1 = new Workout("Running", 30);
        workout1.logWorkout();

        // Log diet
        String[] nutritionDetails = { "Protein: 10g", "Carbs: 20g" };
        Diet breakfast = new Diet("Breakfast", 300, nutritionDetails);
        breakfast.logMeal();

        // Progress tracking
        ProgressTracker tracker = new ProgressTracker();
        tracker.generateProgressReport();

        // Display BMI
        System.out.println("User BMI: " + user.calculateBMI());

    }
}