package test.buildings;

import test.animals.abstracts.Animal;
import test.zookeepers.Zookeeper;

import java.util.HashMap;
import java.util.Set;

public class Zoo {
    private HashMap<Integer, Enclosure> enclosures;
    private HashMap<Integer, Zookeeper> zookeepers;


    public Zoo() {
        this.enclosures = new HashMap<>();
    }

    public void addEnclosure(Enclosure enclosure) {
        this.enclosures.put(enclosure.getId(), enclosure);
    }

    public void removeEnclosure(Enclosure enclosure) {
        this.enclosures.remove(enclosure.getId());
    }

    public Enclosure getEnclosure(int id) {
        return this.enclosures.get(id);
    }

    public boolean aMonthPasses(Zookeeper Zookeeper,FoodStore FoodStore) {
        Set<Integer> enclosureKeys = this.enclosures.keySet();

        for (int enclosureKey : enclosureKeys) {
            Enclosure enclosure = this.enclosures.get(enclosureKey);
            enclosure.aMonthPasses();
            Set<Integer> animalKeys = enclosure.getAnimals().keySet();
            for (int animalKey : animalKeys) {
                Animal animal = enclosure.getAnimals().get(animalKey);
                animal.aMonthPasses(Zookeeper, enclosure, FoodStore);
            }
        }
        return true;
    }
}
