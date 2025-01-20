import java.util.Scanner;

public class GoalFactory implements Factory<Goal> {

    private int goalType;
    private double currentWeight;

        // // Default constructor
        // public GoalFactory() {
        //     this.goalType = 1; // Default to Weight Loss
        //     this.currentWeight = 70.0; // Default weight
        // }


    public GoalFactory(int goalType, double currentWeight) {
        this.goalType = goalType;
        this.currentWeight = currentWeight;
    }

      // Override the create method from the Factory interface
    @Override
    public Goal create(String type, double targetValue, double currentValue, double specificValue) {
        if (type.equalsIgnoreCase("WeightLoss")) {
            return new WeightLossGoal(targetValue, currentValue);
        } else if (type.equalsIgnoreCase("MuscleGain")) {
            return new MuscleGainGoal(targetValue, specificValue);
        } else {
            System.out.println("Invalid type.");
            return null;
        }
    }

   // Separate static createGoal method
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