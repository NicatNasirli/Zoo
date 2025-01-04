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
    }

    public void removeAnimal(Animal animal) {
        this.animals.remove(animal.getId());
    }

    public void addWaste(int waste) {
        this.waste += waste;
    }

    public void removeWaste(int waste) {
        this.waste -= waste;
        if (this.waste <= 0){
            this.waste = 0;
        }
    }

    public int getSize(){
        return this.animals.size();
    }

    public boolean aMonthPasses(){
        return false;
    }

}

