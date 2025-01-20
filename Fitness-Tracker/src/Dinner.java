public class Dinner extends Diet {
    public Dinner(double calories) {
        super("Dinner", calories);
    }

    @Override
    public double calculateAdjustedCalories() {
        return getCalories() * 1.2;
    }

    @Override
    public void logDetails() {
        System.out.println("Dinner logged with " + getCalories() + " calories.");
    }
}