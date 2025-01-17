package test.animals.abstracts;


import lombok.RequiredArgsConstructor;
import test.buildings.Enclosure;
import test.buildings.FoodStore;
import test.buildings.Zoo;
import test.utils.Food;
import test.zookeepers.Zookeeper;

@RequiredArgsConstructor
public abstract class BigCat extends Animal {
    private static final String[] eats = {"Steak", "Celery"};

    public BigCat(int id, int age, char gender, int health, int lifeExpectancy) {
        super(id, age, gender, eats, health, lifeExpectancy);
    }


    @Override
    public boolean aMonthPasses(FoodStore foodStore) {
        if (ifAlive()) {
            Zookeeper zookeeper = this.getZookeeper();
            Enclosure enclosure = this.getEnclosure();
            Food food = foodStore.getFoods().get("Celery").getFood();

            int waste = zookeeper.feedAnimal(foodStore, food, this);
            enclosure.setWaste(enclosure.getWaste() + waste);
            this.setMonth(this.getMonth() + 1);
            this.decreaseHealth(1);

            if (this.getMonth() == 12) {
                this.grow();
                this.setMonth(0);
            }
            return true;
        }
        return false;
    }
}
