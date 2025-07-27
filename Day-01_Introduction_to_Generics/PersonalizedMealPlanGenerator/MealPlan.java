public interface MealPlan {
    String getMealDescription();
}

class VegetarianMeal implements MealPlan {
    public String getMealDescription() {
        return "Vegetarian Meal: Includes vegetables, grains, legumes, and dairy.";
    }
}

class VeganMeal implements MealPlan {
    public String getMealDescription() {
        return "Vegan Meal: Includes only plant-based items. No dairy or animal products.";
    }
}

class KetoMeal implements MealPlan {
    public String getMealDescription() {
        return "Keto Meal: High fat, low carb. Includes meat, cheese, and vegetables.";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealDescription() {
        return "High-Protein Meal: Focused on meat, eggs, legumes, and dairy for muscle building.";
    }
}
