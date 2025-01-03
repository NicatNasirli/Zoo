package test.animals.abstracts;

public abstract class Ape extends Animal {
    private static final String[] eats = {"Fruit", "Ice-cream"};

    public Ape(int id,int age, char gender, int health, int lifeExpectancy) {
        super(id, age, gender, eats, health, lifeExpectancy);
    }
}
