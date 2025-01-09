public class DietTrackerUser extends User {
    private String dietPlan;

    public DietTrackerUser(String name, int age, double weight, double height, String dietPlan) {
        super(name, age, weight, height);
        this.dietPlan = dietPlan;
    }

    public String getDietPlan() {
        return dietPlan;
    }

    public void setDietPlan(String dietPlan) {
        this.dietPlan = dietPlan;
    }

    @Override
    public String toString() {
        return super.toString() + ", DietPlan='" + dietPlan + "'";
    }
}
