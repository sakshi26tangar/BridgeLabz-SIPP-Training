public class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void showMealPlan() {
        System.out.println("Your selected meal plan:");
        System.out.println(mealPlan.getMealDescription());
    }

    public static <T extends MealPlan> Meal<T> generateMealPlan(T plan) {
        return new Meal<>(plan);
    }
}
