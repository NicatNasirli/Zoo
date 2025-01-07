package test;

import test.animals.abstracts.Animal;
import test.animals.concrates.Lion;
import test.buildings.Enclosure;
import test.buildings.FoodStore;
import test.buildings.Zoo;
import test.utils.Food;
import test.zookeepers.PhysioZookeeper;
import test.zookeepers.Zookeeper;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        FoodStore foodStore = zoo.getFoodStore();
        Enclosure enclosure1 = new Enclosure(1);
        Zookeeper zookeeper1 = new PhysioZookeeper(1);
        Animal lion = new Lion(1,1,'M',10);
        zoo.addEnclosure(enclosure1);
        zoo.getEnclosure(1).addAnimal(lion);
        zoo.addZookeeper(zookeeper1);
        zookeeper1.assignAnimal(lion);
        zoo.addZookeeper(zookeeper1);

        Food celery = new Food("Celery", 0,1);
        Food hay = new Food("Hay", 1,4);
        foodStore.addNewFood(celery);
        foodStore.addNewFood(hay);

        foodStore.addFood(celery,10);

        for (int i = 0;i < 12;i++){
            zoo.aMonthPasses();
        }


    }

}