package test.buildings;

import lombok.Getter;
import test.animals.abstracts.Animal;
import test.zookeepers.Zookeeper;

import java.util.HashMap;
import java.util.Set;

@Getter
public class Zoo {
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

    public void addZookeeper(Zookeeper zookeeper){
        this.zookeepers.put(zookeeper.getId(),zookeeper);
    }

    public void removeZookeeper(Zookeeper zookeeper){
        this.zookeepers.remove(zookeeper.getId());
    }

    public void assignZookeeper(Zookeeper zookeeper, Animal animal){

    }

    public Zookeeper getAnimalZookeeper(Animal animal){
        Set<Integer> zookeeperKeys = this.zookeepers.keySet();

        for (int zookeeperKey : zookeeperKeys){
            HashMap<Integer, Animal> animals = this.zookeepers.get(zookeeperKey).getAnimals();
            Set<Integer> animalKeys = animals.keySet();
            for (int animalKey : animalKeys){
                Animal foundAnimal = animals.get(animalKey);
                if (foundAnimal.equals(animal)){
                    return this.zookeepers.get(zookeeperKey);
                }
            }
        }
        return null;
    }

    public boolean aMonthPasses() {
        Set<Integer> enclosureKeys = this.enclosures.keySet();

        for (int enclosureKey : enclosureKeys) {
            Enclosure enclosure = this.enclosures.get(enclosureKey);
            enclosure.aMonthPasses();
            Set<Integer> animalKeys = enclosure.getAnimals().keySet();
            for (int animalKey : animalKeys) {
                Animal animal = enclosure.getAnimals().get(animalKey);
                Zookeeper zookeeper = getAnimalZookeeper(animal);
                animal.aMonthPasses(zookeeper, enclosure,this.foodStore);
            }
        }
        return true;
    }
}
