import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // Array of predefined users (Example of Array)
        User[] users = {
                new User("Amirul", 22, 60.0, 170),
                new User("Sheikh", 22, 95.0, 180),
                new User("Nurzul", 22, 70.0, 165),
                new User("Imran", 22, 80.0, 185),
                new User("Amin", 22, 550.0, 175)
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
            return;
        }

        // Selected user
        User user = users[selectedUser];
        System.out.println("\nWelcome, " + user.getName());

        // Create a workout for the selected user
        System.out.print("\nEnter workout duration in minutes: ");
        double duration = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("\nSelect Exercise Type:");
        System.out.println("1. Jogging\n2. Gym Workout\n3. Cycling\n4. Walking");
        System.out.print("Enter your choice (1-4): ");
        int exerciseChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] exerciseTypes = {"Jogging", "Gym Workout", "Cycling", "Walking"};
        if (exerciseChoice < 1 || exerciseChoice > exerciseTypes.length) {
            System.out.println("Invalid choice. Defaulting to Jogging.");
            exerciseChoice = 1; // Default to Jogging
        }
        String exerciseType = exerciseTypes[exerciseChoice - 1];

        // Create a Workout object
        Workout workout = new Workout(exerciseType, duration, user.getWeight());
        workout.logWorkout(); // Log the workout details

        scanner.close();
    }
}
