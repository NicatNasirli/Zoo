package test.zookeepers;

import lombok.Data;
import test.buildings.FoodStore;
import test.utils.Food;

@Data
public class Zookeeper {
    private int id;

    private final FoodStore foodStore;

    public Zookeeper(int id, FoodStore foodStore) {
        this.id = id;
        this.foodStore = foodStore;
    }

    public void stroke() {

    }

    public void hug() {

    }

    public boolean ifThereIsFood(Food food) {
        int size = this.foodStore.getFoods().get(food.getName()).getSize();
        return size > 0;
    }

    public void feedAnimal(Food food) {
        if (ifThereIsFood(food)) {
            this.foodStore.removeFood(food, 1);
        } else System.out.println("No foods found");
    }

    public boolean aMonthPasses() {
        return false;
    }
}
