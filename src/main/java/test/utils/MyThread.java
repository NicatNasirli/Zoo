package test.utils;

import lombok.Getter;
import test.buildings.Zoo;

@Getter
public class MyThread extends Thread{
    private volatile boolean running;
    private final Zoo zoo;

    public MyThread(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public void run() {
        running = true;
        while (running){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("A Month Passed");
            this.zoo.aMonthPasses();
        }
    }

    public void stopThread(){
        running = false;
    }
}
