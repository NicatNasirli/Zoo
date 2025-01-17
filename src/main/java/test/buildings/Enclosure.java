package test.buildings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.animals.abstracts.Animal;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enclosure implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    private int id;
    private int waste;
    private HashMap<Integer, Animal> animals;

    public Enclosure(int id) {
        this.id = id;
        this.waste = 0;
        this.animals = new HashMap<>();
    }

    private boolean ifEnclosureFull() {
        return animals.size() >= 4;
    }

    public void addAnimal(Animal animal) {
        this.animals.put(animal.getId(), animal);
        animal.setEnclosure(this);
    }

    public void removeAnimal(Animal animal) {
        this.animals.remove(animal.getId());
        animal.setEnclosure(null);
    }

    public void addWaste(int waste) {
        this.waste += waste;
    }

    public void removeWaste(int waste) {
        this.waste -= waste;
        if (this.waste <= 0) {
            this.waste = 0;
        }
    }

    public int getSize() {
        return this.animals.size();
    }


    public boolean aMonthPasses() {
        return false;
    }

    public boolean ifAnimalIsAlive(Animal animal){
        int health = animal.getHealth();
        return health > 0;
    }

    @Override
    public String toString() {
        return "id: " + id +
               ", waste: " + waste +
               ", animal count: " + animals.size() +
               '\n';
    }
}

