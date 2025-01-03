package test.animals.concrates;

import lombok.RequiredArgsConstructor;
import test.animals.abstracts.BigCat;

@RequiredArgsConstructor
public class Lion extends BigCat {
    private static final int lifeExpectancy = 24;

    public Lion(int age, char gender, int health) {
        super(age, gender, health, lifeExpectancy);
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }
}
