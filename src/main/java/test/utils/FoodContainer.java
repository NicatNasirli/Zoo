package test.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
@AllArgsConstructor
public class FoodContainer implements Serializable {
    @Serial
    private static final long serialVersionUID = 6L;

    private int size;
    private Food food;

    @Override
    public String toString() {
        return "name: " + food.getName() +
               ", waste: " + food.getWaste() +
               ", health: " + food.getHealth() +
               ", quantity: " + size +
               '\n';
    }
}
