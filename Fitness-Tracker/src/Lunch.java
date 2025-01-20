public class Lunch extends Diet {
    public Lunch (double calories) {
        super("Lunch", calories);
    }

    @Override
    public double calculateAdjustedCalories() {
        return getCalories() * 1.2;
    }

    @Override
    public void logDetails() {
        System.out.println("Lunch logged with " +  getCalories() + " calories.");
    }
}