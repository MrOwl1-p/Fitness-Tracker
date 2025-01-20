import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // New Frame
        // Login frame = new Login();
        // // Set JFrame properties
        // frame.setVisible(true);
        // frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        System.out.println("Welcome to Fitness Tracker!");
        System.out.println("Choose a user profile to get started.");

        // Array of predefined users (Example of Array)
        User[] users = {
                new User("Amirul", 22, 60.0, 170),
                new User("Sheikh", 22, 95.0, 180),
                new User("Nurzul", 22, 70.0, 165),
                new User("Imran", 22, 80.0, 185),
                new User("Amin", 22, 50.0, 175)
        };

        // // Launch Login Frame with user array
        // java.awt.EventQueue.invokeLater(() -> {
        // new Login(users).setVisible(true); // Pass the `users` array here
        // });

        Scanner scanner = new Scanner(System.in);

        // Display available users
        System.out.println("Select User Profile:");
        for (int i = 0; i < users.length; i++) {
            System.out.println((i + 1) + ": " + users[i]);
        }
        System.out.print('\n' + "Enter your choice (1-" + users.length + "): " + '\n');
        int selectedUser = scanner.nextInt() - 1;

        if (selectedUser < 0 || selectedUser >= users.length) {
            System.out.println("Invalid selection.");
            scanner.close();
            return;
        }

        // Selected user
        User user = users[selectedUser];
        System.out.println("\nWelcome, " + user.getName() + " Weight: " + user.getWeight());

        // Set up user's goals
        System.out.println("\nEnter Goal Type: 1) Weight Loss 2) Muscle Gain");
        int goalType = scanner.nextInt();

        System.out.println("Your Goal Type: " + goalType);

        Goal goal = GoalFactory.createGoal(goalType, user.calculateBMI());
        if (goal == null) {
            System.out.println("Invalid Goal Type.");
            scanner.close();
            return;
        }
        user.addGoal(goal);

        // Display Goal Type and Target initially
        System.out.println("\n==Current Goal==");
        System.out.println("Goal Type: " + goal.getGoalTypeName());
        System.out.println("Target(KG): " + goal.getTargetValue());

        do {
            // Prompt for updated current value
            System.out.print("\nEnter updated weight (KG): ");
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

        System.out.println("Congratulations! You have completed your goal." + '\n');

        System.out.println("\nSelect Exercise Type:");
        System.out.println("1. Jogging\n2. Gym Workout\n3. Cycling\n4. Walking");
        System.out.print("Enter your choice (1-4): ");
        int exerciseChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create a workout for the selected user
        System.out.print("\nEnter workout duration (minutes): ");
        double duration = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        String[] exerciseTypes = { "Jogging", "Gym Workout", "Cycling", "Walking" };
        if (exerciseChoice < 1 || exerciseChoice > exerciseTypes.length) {
            System.out.println("Invalid choice. Defaulting to Jogging.");
            exerciseChoice = 1; // Default to Jogging
        }
        String exerciseType = exerciseTypes[exerciseChoice - 1];

        // Create a Workout object
        Workout workout = new Workout(exerciseType, duration, user.getWeight());
        workout.logActivity(); // Log the workout details

        // test
        System.out.println("\nLog your diet:");
        System.out.print("Enter meal type (Breakfast, Lunch, Dinner): ");
        String mealType = scanner.nextLine();

        System.out.print("Enter calories: ");
        double calories = scanner.nextDouble();
        scanner.nextLine();

        Diet diet = new Diet(mealType, calories);
        diet.logMeal();

        System.out.println("\nMeal Details:");
        System.out.println("Meal Type: " + diet.getMealType());
        System.out.println("Calories: " + diet.getCalories());

        System.out.println("\nTotal Calories (adjusted for meal type): " + diet.calculateTotalCalories());

    }
}