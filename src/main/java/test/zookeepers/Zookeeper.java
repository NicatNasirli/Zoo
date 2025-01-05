package test.zookeepers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import test.buildings.FoodStore;
import test.utils.Food;

@Data
@AllArgsConstructor
public class Zookeeper {
    private int id;

    private FoodStore foodStore;


    public Zookeeper(int id) {
        this.id = id;
    }

    public void stroke() {

    }

    public void hug() {

    }

    public void feedAnimal(Food food) {
        this.foodStore.removeFood(food, 1);
    }

    public boolean aMonthPasses() {
        return false;
    }
}
