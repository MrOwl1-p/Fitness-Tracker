
import java.util.Scanner;

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
       String[] allowedMealTypes = {"Breakfast", "Lunch", "Dinner"};
       for (String allowedType : allowedMealTypes) {
           if (mealType.equalsIgnoreCase(allowedType)) {
               this.mealType = mealType;
               return; // Exit the method once a valid type is set
           }
       }
       throw new IllegalArgumentException("Invalid meal type. Please use Breakfast, Lunch, or Dinner.");
    
    }

    public double getCalories() {
        return this.calories;
    }

    public void setCalories(double calories) {
        if (calories <= 0) {
            throw new IllegalArgumentException("Calories must be a positive number.");
        }
        this.calories = calories;
    }

    public String[] getNutritionDetails() {
        return this.nutritionDetails;
    }

    public void setNutritionDetails(String[] nutritionDetails) {
        this.nutritionDetails = nutritionDetails;
    }

    public double calculateTotalCalories() {
        //pengiraan kalori 
        switch (mealType.toLowerCase()) { 
            case "breakfast":
                return calories * 1.2; 
            case "lunch":
                return calories * 1.0; 
            case "dinner":
                return calories * 0.8; 
            default:
                return calories; 
        }
    }

    public void logMeal() {
        System.out.println("Meal logged: " + mealType + " with " + calories + " calories.");
        if (nutritionDetails != null) {
            System.out.println("Nutrition Details:");
            for (String detail : nutritionDetails) {
                System.out.println(" - " + detail);
            }
        }
    }

    public static Diet createDietFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter meal type (Breakfast, Lunch, Dinner): ");
        String mealType = scanner.nextLine();

        System.out.print("Enter calories for " + mealType + ": ");
        double calories = scanner.nextDouble();

        scanner.nextLine(); // Consume newline
        System.out.print("Enter nutrition details (comma-separated): ");
        String[] nutritionDetails = scanner.nextLine().split(",");
        scanner.close();
        return new Diet(mealType, calories, nutritionDetails);
    }
}
