package test.utils;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class FoodContainer {
    private int size;
    private Food food;

    @Override
    public String toString() {
        return "name: " + food.getName() +
               ", waste: " + food.getWaste() +
               ", health: " + food.getHealth() +
               ", quantity: " + size;
    }
}
