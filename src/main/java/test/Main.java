package test;

import test.utils.Menu;
import test.utils.MyThread;

import java.io.IOException;

public class Main extends Thread {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Menu menu = new Menu();
        MyThread myThread = new MyThread(menu.getZoo());
        myThread.start();

        menu.menu();
    }


}