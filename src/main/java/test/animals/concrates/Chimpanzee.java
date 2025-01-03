package test.animals.concrates;

import test.animals.abstracts.Ape;

public class Chimpanzee extends Ape {
    private static final int lifeExpectancy = 24;

    public Chimpanzee(int id, int age, char gender, int health) {
        super(id, age, gender, health, lifeExpectancy);
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }
}
