import java.util.Scanner;

public class GoalFactory {
    public static Goal createGoal(int goalType, double currentWeight) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter target weight (KG): ");
        double targetValue = scanner.nextDouble();

        switch (goalType) {
            case 1:
                return new WeightLossGoal(targetValue, currentWeight);
            case 2:
                return new MuscleGainGoal(targetValue, currentWeight);
            default:
                System.out.println("Invalid goal type. Please enter a valid goal type.");
                return null;
        }
    }
}
