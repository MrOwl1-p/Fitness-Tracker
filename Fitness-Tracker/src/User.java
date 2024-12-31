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

}
