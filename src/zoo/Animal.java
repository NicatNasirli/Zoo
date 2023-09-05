package zoo;

import java.util.Arrays;

public abstract class Animal {
    public int grow;
    public int age;
    public char gender;
    public String[] eats;
    public int health;
    public int lifeExpectancy;

    public Animal() {
    }
    public Animal(int age, char gender, String[] eats, int health, int lifeExpectancy,int grow) {
        this.age = age;
        this.gender = gender;
        this.eats = eats;
        this.health = health;
        this.lifeExpectancy = lifeExpectancy;
        this.grow = grow;
    }

    public int getGrow() {
        return grow;
    }

    public void setGrow(int grow) {
        this.grow = grow;
    }

    public int getAge() {
       return age;
    }
    public char getGender() {
        return gender;
    }
    public int getHealth(){
        return health;
    }
    public int getLifeExpectancy(Animal animal) {
        return animal.lifeExpectancy ;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public abstract boolean aMonthPasses();

    @Override
    public String toString() {
        return "{"  + age +
                "," + gender +
                "," + Arrays.toString(eats) +
                "," + health +
                "," + lifeExpectancy +
                '}';
    }
}
