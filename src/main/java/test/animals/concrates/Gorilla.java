package test.animals.concrates;

import test.animals.abstracts.Ape;

public class Gorilla extends Ape {
    private static final int lifeExpectancy = 32;

    public Gorilla(int age, char gender, int health) {
        super(age, gender, health, lifeExpectancy);
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }
}
