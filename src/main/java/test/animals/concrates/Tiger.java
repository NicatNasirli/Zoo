package test.animals.concrates;

import lombok.RequiredArgsConstructor;
import test.animals.abstracts.BigCat;
import test.buildings.Enclosure;
import test.buildings.FoodStore;
import test.zookeepers.Zookeeper;

public class Tiger extends BigCat {
    private static final int lifeExpectancy = 24;

    private Zookeeper zookeeper;
    private Enclosure enclosure;
    private FoodStore foodStore;

    public Tiger(int id, int age, char gender, int health) {
        super(id, age, gender, health, lifeExpectancy);
    }

    @Override
    public boolean aMonthPasses(FoodStore foodStore) {
        return super.aMonthPasses(foodStore);
    }
}
