public class Diet {
    private String mealType;
    private double calories;
    private String[] nutritionDetails;

    public Diet(String mealType, double calories, String[] nutritionDetails) {
        this.mealType = mealType;
        this.calories = calories;
        this.nutritionDetails = nutritionDetails;
    }

    public String getMealType() {
        return this.mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public double getCalories() {
        return this.calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public String[] getNutritionDetails() {
        return this.nutritionDetails;
    }

    public void setNutritionDetails(String[] nutritionDetails) {
        this.nutritionDetails = nutritionDetails;
    }

    public double calculateTotalCalories() {
        return calories;
    }

    public void logMeal() {
        System.out.println("Meal logged: " + mealType + " with " + calories + " calories.");
    }
}
