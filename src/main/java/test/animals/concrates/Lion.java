package test.animals.concrates;

import lombok.RequiredArgsConstructor;
import test.animals.abstracts.BigCat;
import test.buildings.Enclosure;
import test.utils.Food;
import test.zookeepers.Zookeeper;

@RequiredArgsConstructor
public class Lion extends BigCat {
    private static final int lifeExpectancy = 24;

    private Zookeeper zookeeper;
    private Enclosure enclosure;

    public Lion(int id, int age, char gender, int health) {
        super(id, age, gender, health, lifeExpectancy);
    }

    @Override
    public boolean aMonthPasses(Food food) {
        if (ifAlive()){
            this.zookeeper.feedAnimal(food);
            this.enclosure.setWaste(this.enclosure.getWaste() + eat(food));
            grow();
            return true;
        }
        return false;
    }
}
