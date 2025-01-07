package test.animals.concrates;

import lombok.RequiredArgsConstructor;
import test.animals.abstracts.BigCat;
import test.buildings.Enclosure;
import test.buildings.FoodStore;
import test.zookeepers.Zookeeper;


public class Lion extends BigCat {
    private static final int lifeExpectancy = 24;

    private Zookeeper zookeeper;
    private Enclosure enclosure;
    private FoodStore foodStore;


    public Lion(int id, int age, char gender, int health) {
        super(id, age, gender, health, lifeExpectancy);
    }

    @Override
    public boolean aMonthPasses(Zookeeper zookeeper, Enclosure enclosure, FoodStore foodStore) {
        return super.aMonthPasses(zookeeper, enclosure, foodStore);
    }
}
