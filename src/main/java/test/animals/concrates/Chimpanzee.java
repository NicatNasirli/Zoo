package test.animals.concrates;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import test.animals.abstracts.Ape;

public class Chimpanzee extends Ape {
    private static final int lifeExpectancy = 24;

    public Chimpanzee(int age, char gender, int health) {
        super(age, gender, health, lifeExpectancy);
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }
}
