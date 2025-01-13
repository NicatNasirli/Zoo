package test.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@Data
public class Food implements Serializable {
    @Serial
    private static final long serialVersionUID = 7L;

    private String name;
    private int health;
    private int waste;
}
