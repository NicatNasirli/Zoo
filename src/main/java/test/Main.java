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
        FoodStore foodStore = new FoodStore();
        Zookeeper zookeeper1 = new PhysioZookeeper(1,foodStore);
        Animal lion = new Lion(1,1,'M',10);
        Animal lion2 = new Lion(2,1,'M',10);
        Enclosure enclosure1 = new Enclosure(1);
        zoo.addEnclosure(enclosure1);
        zoo.getEnclosure(1).addAnimal(lion);
        zoo.getEnclosure(1).addAnimal(lion2);

        Food celery = new Food("Celery", 0,1);
        Food hay = new Food("Hay", 1,4);
        foodStore.addNewFood(celery);
        foodStore.addNewFood(hay);

        foodStore.addFood(celery,10);

        for (int i = 0;i < 12;i++){
            lion.aMonthPasses(zookeeper1,enclosure1,foodStore);
        }


    }

}