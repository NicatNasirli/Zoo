package test.animals.concrates;

import test.animals.abstracts.BigCat;

public class Tiger extends BigCat {
    private static final int lifeExpectancy = 24;


    public Tiger(int age, char gender, int health) {
        super(age, gender, health, lifeExpectancy);
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }
}
