public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Buat a new user
        User user = User.createUserFromInput();

        // // Log workouts
        // Workout workout1 = new Workout("Running", 30);
        // workout1.logWorkout();

        // // Log diet
        // String[] nutritionDetails = { "Protein: 10g", "Carbs: 20g" };
        // Diet breakfast = new Diet("Breakfast", 300, nutritionDetails);
        // breakfast.logMeal();

        // // Progress tracking
        // ProgressTracker tracker = new ProgressTracker();
        // tracker.generateProgressReport();

        // // Display BMI
        // System.out.println("User BMI: " + user.calculateBMI());

        System.out.println("User details: " + user.getName() + ", " + user.getAge() + " years old." + " Weight: "
                + user.getWeight() + " kg, Height: " + user.getHeight() + " cm.");
                
        System.out.println("User's goal: " + user.getGoal());
    }
}