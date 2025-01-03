package test.buildings;

import lombok.AllArgsConstructor;
import lombok.Data;
import test.animals.abstracts.Animal;

import java.util.HashMap;

@AllArgsConstructor
@Data
public class Enclosure {
    private int id;
    private int waste;
    private int size;
    private HashMap<Integer, Animal> animals;

    public Enclosure(int id, int waste, int size) {
        this.id = id;
        this.waste = waste;
        this.size = size;
        this.animals = new HashMap<>();
    }

    private boolean enclosureFull() {
        return animals.size() >= this.size;
    }

    public void putAnimal(Animal animal) {
        this.animals.put(animal.getId(), animal);
    }
}
