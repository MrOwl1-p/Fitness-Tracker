import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        User[] users = {
                new User("Amirul", 22, 60.0, 160),
                new User("Sheikh", 22, 85.0, 180),
                new User("Nurzul", 22, 70.0, 155)
        };
        Scanner scanner = new Scanner(System.in);

        // Display users
        for (int i = 0; i < users.length; i++) {
            System.out.println((i + 1) + ": " + users[i]);
        }
        System.out.println('\n' + "Select a user:");

        int selectedUserIndex = scanner.nextInt() - 1;
        if (selectedUserIndex < 0 || selectedUserIndex >= users.length) {
            System.out.println("Invalid selection.");
            return;
        }

        // Selected user
        User user = users[selectedUserIndex];
        System.out.println("\nWelcome, " + user);

        // Create a new user
        // System.out.print("Enter your name: ");
        // String name = scanner.nextLine();

        // System.out.print("Enter your age: ");
        // int age = scanner.nextInt();

        // System.out.print("Enter your weight (kg): ");
        // double weight = scanner.nextDouble();

        // System.out.print("Enter your height (cm): ");
        // double height = scanner.nextDouble();
        // scanner.nextLine();

        // User user = new User(name, age, weight, height);

        // Set up users goals
        System.out.println("\nEnter goal type: 1: Weight Loss, 2: Muscle Gain");
        int goalType = scanner.nextInt();

        Goal goal = Goal.userGoal(goalType, user.calculateBMI());
        if (goal != null) {
            user.addGoal(goal);
        }

        // Track progress for each goal
        ProgressTracker tracker = new ProgressTracker();

        for (Goal xGoal : user.getGoal()) {
            do {
                // Display progress for the current goal
                tracker.updateProgress(xGoal);
                System.out.println("\nCurrent Goal Progress:");
                System.out.println(xGoal.toString());
                tracker.displayProgress();

                // Prompt for new weight to update the goal
                System.out.print("Enter new weight to update goal: ");
                double newWeight = scanner.nextDouble();
                user.updateGoal(newWeight);

                System.out.println("\nUpdated User: " + user);
            } while (!xGoal.checkGoalCompletion()); // Repeat until the goal is complete
        }

        // Tunjuk final progress
        System.out.println("\nCongratulations! All goals are completed.");
        for (Goal g : user.getGoal()) {
            tracker.updateProgress(g);
            tracker.displayProgress();
        }

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
