package test.animals.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import test.utils.Food;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public abstract class Animal {
    private int id;
    private int age;
    private char gender;
    private String[] eats;
    private int health;
    private int lifeExpectancy;



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

    public void grow(){
        this.setAge(this.getAge() + 1);
    }

    public boolean ifAlive(){
        return this.getAge() <= this.getLifeExpectancy();
    }


    public abstract boolean aMonthPasses(Food food);

    @Override
    public String toString() {
        return "{" +
                "\n id: " + id +
                "\n age: " + age +
                "\n gender: " + gender +
                "\n eats: " + Arrays.toString(eats) +
                "\n health: " + health +
                "\n life expectancy: " + lifeExpectancy +
                "}";
    }
}
