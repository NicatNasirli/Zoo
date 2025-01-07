package test.animals.concrates;

import lombok.RequiredArgsConstructor;
import test.animals.abstracts.Ape;
import test.buildings.Enclosure;
import test.buildings.FoodStore;
import test.zookeepers.Zookeeper;


public class Chimpanzee extends Ape {
    private static final int lifeExpectancy = 24;

    private Enclosure enclosure;
    private FoodStore foodStore;


    public Chimpanzee(int id, int age, char gender, int health) {
        super(id, age, gender, health, lifeExpectancy);
    }

    @Override
    public boolean aMonthPasses(Zookeeper zookeeper, Enclosure enclosure, FoodStore foodStore) {
        return super.aMonthPasses(zookeeper, enclosure, foodStore);
    }
}
