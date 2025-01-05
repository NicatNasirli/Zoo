package test.animals.concrates;

import test.animals.abstracts.BigCat;
import test.utils.Food;

public class Tiger extends BigCat {
    private static final int lifeExpectancy = 24;


    public Tiger(int id, int age, char gender, int health) {
        super(id, age, gender, health, lifeExpectancy);
    }

    @Override
    public boolean aMonthPasses(Food food) {
        return false;
    }
}
