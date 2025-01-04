package test.utils;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class FoodContainer {
    private int size;
    private Food food;
}
