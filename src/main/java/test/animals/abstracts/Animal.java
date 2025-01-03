package test.animals.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Animal {
    private int age;
    private char gender;
    private String[] eats;
    private int health;
    private int lifeExpectancy;


    public boolean canEat(String food){
        for (String f: this.eats){
            if (f.equals(food)){
                return true;
            }
        }
        return false;
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
