package test.zookeepers;

import lombok.Data;
import test.buildings.Enclosure;
import test.buildings.FoodStore;
import test.utils.Food;
import test.utils.FoodContainer;

import java.util.HashMap;
import java.util.Set;

@Data
public class Zookeeper {
    private int id;

    private final FoodStore foodStore;
    private final Enclosure enclosure;

    public Zookeeper(int id, FoodStore foodStore, Enclosure enclosure) {
        this.id = id;
        this.foodStore = foodStore;
        this.enclosure = enclosure;
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

    public void addFoodToEachContainer(){
        HashMap<String,FoodContainer> foods = this.foodStore.getFoods();
        Set<String> keys = foods.keySet();
        for (String key : keys){
            foods.get(key).setSize(foods.get(key).getSize() + 1);
        }
    }

    public void removeWasteFromEnclosure(){
        if (this.enclosure.getWaste() >= 1){
            this.enclosure.setWaste(this.enclosure.getWaste() - 1);
        }
    }

    public boolean aMonthPasses() {
        addFoodToEachContainer();
        removeWasteFromEnclosure();
        return true;
    }
}
