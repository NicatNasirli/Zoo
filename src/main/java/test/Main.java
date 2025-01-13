package test;

import test.buildings.Zoo;
import test.utils.FileUtil;
import test.utils.Food;
import test.utils.Menu;

import java.io.File;
import java.io.IOException;

public class Main extends Thread{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Zoo zoo = new Zoo();

        // default food types
        Food celery = new Food("Celery", 0,1);
        Food hay = new Food("Hay", 1,4);
        Food iceCream = new Food("Ice-Cream", 1,3);
        Food steak = new Food("Steak", 3,4);
        zoo.getFoodStore().addNewFood(celery);
        zoo.getFoodStore().addNewFood(hay);
        zoo.getFoodStore().addNewFood(iceCream);
        zoo.getFoodStore().addNewFood(steak);


        FileUtil fileUtil = new FileUtil();
        fileUtil.createFile();

        Menu menu = new Menu(zoo, fileUtil);
        menu.menu();

//        MyThread myThread = new MyThread(zoo);
//        myThread.start();
    }

}