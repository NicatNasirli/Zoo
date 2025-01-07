package test.buildings;

import lombok.Getter;
import test.utils.Food;
import test.utils.FoodContainer;

import java.util.HashMap;


@Getter
public class FoodStore {
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
}
