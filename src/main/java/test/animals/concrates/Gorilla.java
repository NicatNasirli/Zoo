package test.animals.concrates;

import lombok.RequiredArgsConstructor;
import test.animals.abstracts.Ape;
import test.buildings.Enclosure;
import test.buildings.FoodStore;
import test.zookeepers.Zookeeper;


public class Gorilla extends Ape {
    private static final int lifeExpectancy = 32;


    private Zookeeper zookeeper;
    private Enclosure enclosure;
    private FoodStore foodStore;


    public Gorilla(int id, int age, char gender, int health) {
        super(id, age, gender, health, lifeExpectancy);
    }

    @Override
    public boolean aMonthPasses(FoodStore foodStore) {
        return super.aMonthPasses(foodStore);
    }
}
