package test.animals.abstracts;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import test.buildings.Enclosure;
import test.buildings.FoodStore;
import test.utils.Food;
import test.zookeepers.Zookeeper;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

@RequiredArgsConstructor
@Data
public abstract class Animal implements Serializable {
    @Serial
    private static final long serialVersionUID = 3L;

    private int month;

    private int id;
    private int age;
    private char gender;
    private String[] eats;
    private int health;
    private int lifeExpectancy;


    private Zookeeper zookeeper;
    private Enclosure enclosure;



    public Animal(int id, int age, char gender, String[] eats, int health, int lifeExpectancy) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.eats = eats;
        this.health = health;
        this.lifeExpectancy = lifeExpectancy;
        this.month = 0;
    }

    public boolean canEat(Food foodType) {
        for (String food : this.eats) {
            if (food.equals(foodType.getName())) {
                return true;
            }
        }
        return false;
    }

    public int eat(Food food){
        if (canEat(food)){
            this.setHealth(this.getHealth() + food.getHealth());
            return food.getWaste();
        }
        return 0;
    }

    public void decreaseHealth(int health){
        this.setHealth(this.getHealth() - health);
        if (this.getHealth() <= 0){
            this.setHealth(0);
        }
    }

    public void grow(){
        this.setAge(this.getAge() + 1);
    }

    public boolean ifAlive(){
        return this.getAge() <= this.getLifeExpectancy();
    }


    public abstract boolean aMonthPasses(FoodStore foodStore);

    @Override
    public String toString() {
        return "\n id: " + id +
                ", age: " + age +
                ", gender: " + gender +
                ", eats: " + Arrays.toString(eats) +
                ", health: " + health +
                ", life expectancy: " + lifeExpectancy;
    }
}
