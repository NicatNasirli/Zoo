package test.animals.abstracts;

import lombok.RequiredArgsConstructor;
import test.buildings.Enclosure;
import test.buildings.FoodStore;
import test.utils.Food;
import test.zookeepers.Zookeeper;

@RequiredArgsConstructor
public abstract class Ape extends Animal {
    private static final String[] eats = {"Fruit", "Ice-cream"};

    public Ape(int id, int age, char gender, int health, int lifeExpectancy) {
        super(id, age, gender, eats, health, lifeExpectancy);
    }

    @Override
    public boolean aMonthPasses(Zookeeper zookeeper, Enclosure enclosure, FoodStore foodStore) {
        if (ifAlive()) {
            Food food = foodStore.getFoods().get("Ice-cream").getFood();
            zookeeper.feedAnimal(foodStore,food);
            enclosure.setWaste(enclosure.getWaste() + eat(food));
            this.setMonth(this.getMonth() + 1);
            if (this.getMonth() == 12){
                this.grow();
                this.setMonth(0);
            }
            return true;

        }
        return false;
    }
}
