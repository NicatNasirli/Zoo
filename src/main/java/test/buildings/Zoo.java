package test.buildings;

import lombok.Getter;
import test.animals.abstracts.Animal;
import test.zookeepers.Zookeeper;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

@Getter
public class Zoo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final HashMap<Integer, Enclosure> enclosures;
    private final HashMap<Integer, Zookeeper> zookeepers;
    private final FoodStore foodStore;


    public Zoo() {
        this.enclosures = new HashMap<>();
        this.zookeepers = new HashMap<>();
        this.foodStore = new FoodStore();
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

    public void addZookeeper(Zookeeper zookeeper) {
        this.zookeepers.put(zookeeper.getId(), zookeeper);
    }

    public void removeZookeeper(Zookeeper zookeeper) {
        this.zookeepers.remove(zookeeper.getId());
    }

    public Animal findAnimalById(int id){
        Set<Integer> enclosureKeys = this.enclosures.keySet();

        for (int enclosureKey : enclosureKeys) {
            HashMap<Integer, Animal> animals = this.enclosures.get(enclosureKey).getAnimals();
            Set<Integer> animalKeys = animals.keySet();
            for (int animalKey : animalKeys) {
                Animal foundAnimal = animals.get(animalKey);
                if (foundAnimal.getId() == id){
                    return foundAnimal;
                }
            }
        }
        return null;
    }


    public Zookeeper getAnimalZookeeper(Animal animal) {
        Set<Integer> zookeeperKeys = this.zookeepers.keySet();

        for (int zookeeperKey : zookeeperKeys) {
            HashMap<Integer, Animal> animals = this.zookeepers.get(zookeeperKey).getAnimals();
            Set<Integer> animalKeys = animals.keySet();
            for (int animalKey : animalKeys) {
                Animal foundAnimal = animals.get(animalKey);
                if (foundAnimal.equals(animal)) {
                    return this.zookeepers.get(zookeeperKey);
                }
            }
        }
        return null;
    }

    private boolean checkIfEnclosureExistsRoot(Enclosure enclosure) {
        Set<Integer> enclosureKeys = this.enclosures.keySet();

        for (int enclosureKey : enclosureKeys) {
            Enclosure returnedEnclosure = this.enclosures.get(enclosureKey);
            if (returnedEnclosure.equals(enclosure)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfEnclosureExists(Enclosure enclosure) {
        return checkIfEnclosureExistsRoot(enclosure);
    }

    public boolean checkIfEnclosureExists(int id) {
        return checkIfEnclosureExistsRoot(this.enclosures.get(id));
    }

    private boolean checkIfZookeeperExistsRoot(Zookeeper zookeeper) {
        Set<Integer> zookeeperKeys = this.zookeepers.keySet();

        for (int zookeeperKey : zookeeperKeys) {
            Zookeeper returnedZookeeper = this.zookeepers.get(zookeeperKey);
            if (returnedZookeeper.equals(zookeeper)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfZookeeperExists(Zookeeper zookeeper) {
        return checkIfZookeeperExistsRoot(zookeeper);
    }

    public boolean checkIfZookeeperExists(int id) {
        return checkIfZookeeperExistsRoot(this.zookeepers.get(id));
    }


    public boolean aMonthPasses() {
        Set<Integer> enclosureKeys = this.enclosures.keySet();

        for (int enclosureKey : enclosureKeys) {
            Enclosure enclosure = this.enclosures.get(enclosureKey);
            Set<Integer> animalKeys = enclosure.getAnimals().keySet();
            for (int animalKey : animalKeys) {
                Animal animal = enclosure.getAnimals().get(animalKey);
                animal.getZookeeper().aMonthPasses(foodStore, enclosure);
                animal.aMonthPasses(this.foodStore);
            }
        }
        return true;
    }
}
