import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Buat a new user
        User user = User.createUserFromInput();

        // Track Progress
        ProgressTracker tracker = new ProgressTracker();
        tracker.updateProgress(user.getGoal());
        tracker.displayProgress();

        // display goal
        System.out.println('\n' + "User details: " + user.getName() + ", " +
                user.getAge() + " years old." + " Weight: "
                + user.getWeight() + " kg, Height: " + user.getHeight() + " cm.");

        System.out.println("User's goal: " + user.getGoal() + '\n');

        // Update Goal
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to update your goal? (yes/no)");
        String userResponse = scanner.nextLine();

        if (userResponse == ("yes")) {
            System.out.print("Enter new goal type: ");
            int newGoalType = scanner.nextInt();

            Goal newGoal = Goal.userGoal(newGoalType, user.getGoal().getCurrentValue());
            if (newGoal != null) {
                user.updateGoal(newGoal);
                System.out.println("Updated goal: " + user.getGoal());
                tracker.updateProgress(user.getGoal());
                tracker.displayProgress();
            }
        }

        scanner.close();

    }
}