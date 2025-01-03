package test.animals.abstracts;

public abstract class Ape extends Animal {
    private static final String[] eats = {"Fruit", "Ice-cream"};

    public Ape(int age, char gender, int health, int lifeExpectancy) {
        super(age, gender, eats, health, lifeExpectancy);
    }
}
