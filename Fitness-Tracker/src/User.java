import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String name;
    private int age;
    private double weight;
    private double height;
    private ArrayList<Goal> goal;

    public User(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.goal = new ArrayList<>();

    }

    public ArrayList<Goal> getGoal() {
        return this.goal;
    }

    public void setGoal(ArrayList<Goal> goal) {
        this.goal = goal;
    }

    public void addGoal(Goal goal) {
        this.goal.add(goal);
    }

    public double calculateBMI() {
        return weight / (height * height);
    }

    public void updateGoal(double newWeight) {
        this.weight = newWeight;
        if (!goal.isEmpty()) {
            goal.get(0).setCurrentValue(newWeight); // update goal lama ke goal baru
        }
    }

    public String getName() {
        return name;
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

    public void displayGoals() {
        for (Goal goal : goal) {
            System.out.println(goal);
        }
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

        User user = new User(name, age, weight, height); // create user
        // scanner.close();
        return user;
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", Weight: " + weight + "kg, Height: " + height + "cm)";
    }

}