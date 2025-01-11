package test.zookeepers;

import test.animals.abstracts.Animal;
import test.buildings.Enclosure;
import test.buildings.FoodStore;

public class PhysioZookeeper extends Zookeeper{

    public PhysioZookeeper(int id) {
        super(id);
    }

    public void neckMassage(Animal animal){
        animal.setHealth(animal.getHealth() + 4);
        setMaxHealth(animal);
    }

    public void bath(Animal animal){
        animal.setHealth(animal.getHealth() + 5);
        setMaxHealth(animal);
    }
}
