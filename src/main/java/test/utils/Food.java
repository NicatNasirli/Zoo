package test.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Food {
    private String name;
    private int health;
    private int waste;
}
