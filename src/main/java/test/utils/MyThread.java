package test.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import test.buildings.Zoo;

@Getter
@AllArgsConstructor
public class MyThread extends Thread{
    private final Zoo zoo;


    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("a month passed");
            this.zoo.aMonthPasses();
        }
    }
}
