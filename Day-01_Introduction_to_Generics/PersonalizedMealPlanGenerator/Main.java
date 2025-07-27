import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a meal plan: Vegetarian, Vegan, Keto, HighProtein");
        String choice = sc.nextLine().trim().toLowerCase();

        switch (choice) {
            case "vegetarian":
                Meal<VegetarianMeal> vegMeal = Meal.generateMealPlan(new VegetarianMeal());
                vegMeal.showMealPlan();
                break;
            case "vegan":
                Meal<VeganMeal> veganMeal = Meal.generateMealPlan(new VeganMeal());
                veganMeal.showMealPlan();
                break;
            case "keto":
                Meal<KetoMeal> ketoMeal = Meal.generateMealPlan(new KetoMeal());
                ketoMeal.showMealPlan();
                break;
            case "highprotein":
                Meal<HighProteinMeal> highProteinMeal = Meal.generateMealPlan(new HighProteinMeal());
                highProteinMeal.showMealPlan();
                break;
            default:
                System.out.println("Invalid meal plan selection.");
        }

        sc.close();
    }
}
