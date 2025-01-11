package test.zookeepers;

import test.animals.abstracts.Animal;

public class PlayZookeeper extends Zookeeper {


    public PlayZookeeper(int id) {
        super(id);
    }

    public void watchAFilm(Animal animal) {
        animal.setHealth(animal.getHealth() + 2);
        setMaxHealth(animal);
    }

    public void playChase(Animal animal) {
        animal.setHealth(animal.getHealth() + 4);
        setMaxHealth(animal);
    }

    public void painting(Animal animal) {
        animal.setHealth(animal.getHealth() + 4);
        setMaxHealth(animal);
    }
}
