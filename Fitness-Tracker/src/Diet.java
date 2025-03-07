
import java.util.Scanner;

public abstract class Diet implements Loggable{
    private String mealType;
    private double calories;

    public Diet(String mealType, double calories) {
        this.mealType = mealType;
        this.calories = calories;
    }

    public String getMealType() {
        return this.mealType;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    // Abstract method for calorie adjustment logic
    public abstract double calculateAdjustedCalories();

    @Override
    public void logDetails() {
        System.out.println("Meal: " + mealType + ", Calories: " + calories);

    // public void setMealType(String mealType) {

    //     // aku tak tau tapi aku guna try tu untuk tutup scanner 
    //     try (Scanner scanner = new Scanner(System.in)) { 
    //     String[] allowedMealTypes = {"Breakfast", "Lunch", "Dinner"}; //aaray untuk mealtype 

    //     boolean validInput = false;
    //     do {
    //         System.out.print("Enter meal type (Breakfast, Lunch, Dinner): ");
    //         String input = scanner.nextLine();
                                                                              
    //         for (String allowedType : allowedMealTypes) {   //for loop ni untuk pastikan user pilih antara 3 tu je mealtype 
    //             if (input.equalsIgnoreCase(allowedType)) {
    //                 this.mealType = input;
    //                 validInput = true;
    //                 break;
    //             }
    //         }

    //         if (!validInput) {
    //             System.out.println("Invalid meal type. Please enter a valid option.");
    //         }

    //     } while (!validInput);

    //     System.out.print("Enter calories for " + mealType + ": ");
    //     this.calories = scanner.nextDouble(); 
    // }
    // }

    // public double getCalories() {
    //     return this.calories;
    // }

    // public void setCalories(double calories) {
    //     this.calories = calories;
    // }

    // // public String[] getNutritionDetails() {
    // //     return this.nutritionDetails;
    // // }

    // // public void setNutritionDetails(String[] nutritionDetails) {
    // //     this.nutritionDetails = nutritionDetails;
    // // }

    // public double calculateTotalCalories() {
    //     //pengiraan kalori 
    //     // switch (mealType.toLowerCase()) { 
    //     //     case "breakfast":
    //     //         return calories * 1.2; 
    //     //     case "lunch":
    //     //         return calories * 1.0; 
    //     //     case "dinner":
    //     //         return calories * 0.8; 
    //     //     default:
    //     //         return calories; 
    //     // }

    //     return calories; 
    // }


    // public void logMeal() {
    //     System.out.println("Meal logged: " + mealType + " with " + calories + " calories.");
    }
}
