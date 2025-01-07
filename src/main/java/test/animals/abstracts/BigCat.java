package test.animals.abstracts;


import lombok.RequiredArgsConstructor;
import test.buildings.Enclosure;
import test.buildings.FoodStore;
import test.utils.Food;
import test.zookeepers.Zookeeper;

@RequiredArgsConstructor
public abstract class BigCat extends Animal {
    private static final String[] eats = {"Steak", "Celery"};

    public BigCat(int id, int age, char gender, int health, int lifeExpectancy) {
        super(id, age, gender, eats, health, lifeExpectancy);
    }


    @Override
    public boolean aMonthPasses(Zookeeper zookeeper, Enclosure enclosure, FoodStore foodStore) {
        if (ifAlive()) {
            Food food = foodStore.getFoods().get("Celery").getFood();
            zookeeper.feedAnimal(food);
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
