package test.buildings;

import lombok.Getter;
import test.utils.Food;
import test.utils.FoodContainer;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;


@Getter
public class FoodStore implements Serializable {
    @Serial
    private static final long serialVersionUID = 5L;

    private HashMap<String, FoodContainer> foods;

    public FoodStore() {
        this.foods = new HashMap<>();
    }

    public void addNewFood(Food foodType) {
        FoodContainer foodContainer = new FoodContainer(0, foodType);
        this.foods.put(foodType.getName(), foodContainer);
    }

    public void removeExistedFood(Food foodType) {
        this.foods.remove(foodType.getName());
    }

    public void addFood(Food foodType, int quantity) {
        FoodContainer foodContainer = this.foods.get(foodType.getName());
        foodContainer.setSize(foodContainer.getSize() + quantity);
    }

    public void removeFood(Food foodType, int quantity) {
        FoodContainer foodContainer = this.foods.get(foodType.getName());
        foodContainer.setSize(foodContainer.getSize() - quantity);
        if (foodContainer.getSize() <= 0){
            foodContainer.setSize(0);
        }
    }

    private boolean checkIfFoodExistsRoot(Food food){
        Set<String> foodKeys = this.foods.keySet();
        for (String foodKey : foodKeys){
            if (this.foods.get(foodKey).getFood().getName().equals(food.getName())){
                return true;
            }
        }
        return false;
    }

    public boolean checkIfFoodExists(Food food){
        return this.checkIfFoodExistsRoot(food);
    }

    public boolean checkIfFoodExists(String foodName){
        return this.checkIfFoodExistsRoot(this.foods.get(foodName).getFood());
    }
}
