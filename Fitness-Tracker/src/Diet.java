    public class Diet{

        private String mealType;
        private Float calories;
        private String nutritionDetail;

        public void logMeal ( String mealype, float calories ){
            this.mealType = mealype;
            this.calories = calories;
          }
        
        public float calculateTotalCalories() {

            return calories;
        }


    }