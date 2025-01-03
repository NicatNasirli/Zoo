package test;

import test.animals.abstracts.Animal;
import test.animals.concrates.Lion;

public class Main {
    public static void main(String[] args) {
        Animal lion = new Lion(1,'M',10);
        System.out.println(lion);
    }
}