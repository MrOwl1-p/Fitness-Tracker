import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // Array of predefined users (Example of Array)
        User[] users = {
                new User("Amirul", 22, 60.0, 170),
                new User("Sheikh", 22, 95.0, 180),
                new User("Nurzul", 22, 70.0, 165),
                new User("Imran", 22, 80.0, 185),
                new User("Amin", 22, 55.0, 175)
        };
        Scanner scanner = new Scanner(System.in);

        // Display available users
        System.out.println("Select User Profile:");
        for (int i = 0; i < users.length; i++) {
            System.out.println((i + 1) + ": " + users[i]);
        }
        System.out.print("Enter your choice (1-" + users.length + "): ");
        int selectedUser = scanner.nextInt() - 1;

        if (selectedUser < 0 || selectedUser >= users.length) {
            System.out.println("Invalid selection.");
            scanner.close();
            return;
        }

        // Selected user
        User user = users[selectedUser];
        System.out.println("\nWelcome, " + user.getName());

        // Set up user's goals
        System.out.println("\nEnter goal type: 1: Weight Loss, 2: Muscle Gain");
        int goalType = scanner.nextInt();

        Goal goal = Goal.userGoal(goalType, user.calculateBMI());
        if (goal == null) {
            System.out.println("Invalid goal type.");
            scanner.close();
            return;
        }
        user.addGoal(goal);

        // Display Goal Type and Target initially
        System.out.println("\nCurrent Goal:");
        System.out.println("Goal Type: " + goal.getGoalTypeName());
        System.out.println("Target: " + goal.getTargetValue());

        do {
            // Prompt for updated current value
            System.out.print("\nEnter updated current weight: ");
            double newCurrent = scanner.nextDouble();
            goal.setCurrentValue(newCurrent);

            // Update progress and display updated details
            ProgressTracker tracker = new ProgressTracker();
            tracker.updateProgress(goal);

            System.out.println("\nUpdated Goal Details:");
            System.out.println("Current: " + goal.getCurrentValue());
            System.out.println("Progress: " + tracker.getDietProgress() + "%");
            System.out.println("Status: " + tracker.getGoalStatus());

        } while (!goal.checkGoalCompletion());

        System.out.println("Congratulations! You have completed your goal.");
        scanner.close();

                        //test
    System.out.println("\nLog your diet:");
    scanner.nextLine(); 
    System.out.print("Enter meal type (Breakfast, Lunch, Dinner): ");
    String mealType = scanner.nextLine();
                       
    System.out.print("Enter calories: ");
    double calories = scanner.nextDouble();
    scanner.nextLine(); 
                       
    System.out.print("Enter nutrition details (comma-separated): ");
    String[] nutritionDetails = scanner.nextLine().split(",");
                       
    Diet diet = new Diet(mealType, calories, nutritionDetails);
    diet.logMeal();
                       
    System.out.println("\nMeal Details:");
    System.out.println("Meal Type: " + diet.getMealType());
    System.out.println("Calories: " + diet.getCalories());
    System.out.println("Nutrition Details: " + String.join(", ", diet.getNutritionDetails()));
                       
    System.out.println("\nTotal Calories (adjusted for meal type): " + diet.calculateTotalCalories());
    }
}
