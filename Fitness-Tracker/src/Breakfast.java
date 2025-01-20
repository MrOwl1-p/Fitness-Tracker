public class Breakfast extends Diet {
    public Breakfast(double calories) {
        super("Breakfast", calories);
    }

    @Override
    public double calculateAdjustedCalories() {
        return getCalories() * 1.2;
    }

    @Override
    public void logDetails() {
        System.out.println("Breakfast logged with " + getCalories() + " calories.");
    }
}