package test.animals.abstracts;


public abstract class BigCat extends Animal {
    private static final String[] eats = {"Steak","Celery"};

    public BigCat(int id, int age, char gender, int health, int lifeExpectancy) {
        super(id, age, gender, eats, health, lifeExpectancy);
    }
}
