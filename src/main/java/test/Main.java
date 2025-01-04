package test;

import test.animals.abstracts.Animal;
import test.animals.concrates.Lion;
import test.buildings.Enclosure;

public class Main {
    public static void main(String[] args) {
        Animal lion = new Lion(1,1,'M',10);
        Animal lion2 = new Lion(2,1,'M',10);
        Animal lion3 = new Lion(3,1,'M',10);
        Animal lion4 = new Lion(4,1,'M',10);
        Enclosure enclosure = new Enclosure(1,0);
        System.out.println(enclosure.getAnimals());
    }
}