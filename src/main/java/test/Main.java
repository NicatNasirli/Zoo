package test;

import test.buildings.Zoo;
import test.utils.FileUtil;
import test.utils.Menu;
import test.utils.MyThread;

import java.io.File;
import java.io.IOException;

public class Main extends Thread {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Every ten seconds equal to one month.

        FileUtil fileUtil = new FileUtil();
        File file = fileUtil.createFile();
        Zoo zoo = fileUtil.readObjectFromFile(file);

        Menu menu = new Menu(zoo);
        MyThread myThread = new MyThread(zoo);

        myThread.start();
        boolean processEnded = menu.menu();


        if (processEnded){
            myThread.stopThread();
            fileUtil.writeObjectToFile(file,zoo);
            System.out.println("All changes saved!");
        }
    }


}