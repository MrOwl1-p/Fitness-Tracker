import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a DietTrackerUser
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your weight (kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height (m): ");
        double height = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter your diet plan: ");
        String dietPlan = scanner.nextLine();

        DietTrackerUser user = new DietTrackerUser(name, age, weight, height, dietPlan);

        // Display user info
        System.out.println("\nWelcome, " + user);
        System.out.println("Your current diet plan is: " + user.getDietPlan());

        // Set up goals
        System.out.println("\nEnter goal type: 1: Weight Loss, 2: Muscle Gain");
        int goalType = scanner.nextInt();

        Goal goal = Goal.userGoal(goalType, user.calculateBMI());
        if (goal != null) {
            user.addGoal(goal);
        }

        // Track progress for each goal
        ProgressTracker tracker = new ProgressTracker();

        for (Goal xGoal : user.getGoal()) { // Iterate through goals
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

        // Display final progress
        System.out.println("\nCongratulations! All goals are completed.");
        for (Goal g : user.getGoal()) {
            tracker.updateProgress(g);
            tracker.displayProgress();
        }

        scanner.close();
    }
}
