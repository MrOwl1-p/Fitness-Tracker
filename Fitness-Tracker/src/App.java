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

        int userChoice = scanner.nextInt() - 1;
        if (userChoice < 0 || userChoice >= users.length) {
            System.out.println("Invalid selection.");
            scanner.close();
            return;
        }

        // Selected user
        User user = users[userChoice];
        System.out.println("\nWelcome, " + user);

        // Set up user's goals
        System.out.println("\nEnter goal type: 1: Weight Loss, 2: Muscle Gain");
        int goalType = scanner.nextInt();

        Goal goal = Goal.userGoal(goalType, user.calculateBMI());
        if (goal != null) {
            user.addGoal(goal);
        }

        // Display only Goal Type and Target initially
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

        } while (goal.checkGoalCompletion() == false);

        System.out.println("Congratulations! You have completed your goal.");

        scanner.close();
    }
}
