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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.zoo.aMonthPasses();
        }
    }
}
