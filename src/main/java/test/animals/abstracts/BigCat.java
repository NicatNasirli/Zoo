package test.animals.abstracts;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BigCat extends Animal {
    private static final String[] eats = {"Steak","Celery"};

    public BigCat(int age, char gender, int health, int lifeExpectancy) {
        super(age, gender, eats, health, lifeExpectancy);
    }
}