
import java.util.Scanner;

public class User {
    private String name;
    private int age;
    private double weight;
    private double height;
    private Goal goal;

    public User(String name, int age, double weight, double height, Goal goal) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.goal = goal;
    }

    public double calculateBMI() {
        return weight / (height * height);
    }

    public void updateGoal(Goal goal) {
        this.goal = goal;
    }

    public String getName() {
        return name;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public static User createUserFromInput() { // enter user details
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter weight (kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height (cm): ");
        double height = scanner.nextDouble();

        System.out.print("Goal type: " + '\n' + "" + // enter goal type
                "1: Weight Loss, 2: Muscle Gain" + '\n' +
                "Enter goal type: ");
        int goalType = scanner.nextInt();
        Goal goal = Goal.userGoal(goalType, weight);

        User user = new User(name, age, weight, height, goal); // create user
        // scanner.close();
        return user;
    }

}