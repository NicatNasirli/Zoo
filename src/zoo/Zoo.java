package zoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Zoo {
    static Zookeeper zookeeper = new Zookeeper();
    public static List<Animal> classes =
            new ArrayList<>(Arrays.asList(new Lion(), new Gorilla(), new Tiger(), new Chimpanzee()));
    public static Hashtable<String, Integer> foodBase = new Hashtable<>();
    public static List<Hashtable<String, Animal>> enclosures =
            new ArrayList<>(Arrays.asList(Enclosure.gorillas, Enclosure.lions, Enclosure.tigers, Enclosure.chimpanzees));

    public static void takeFood(String foodType) {
        int i = foodBase.get(foodType) - 1;
        foodBase.replace(foodType, i);
    }

    public static void addFoodToBase() {
        foodBase.put("hay", 10);
        foodBase.put("steak", 10);
        foodBase.put("fruit", 10);
        foodBase.put("celery", 10);
        foodBase.put("fish", 10);
        foodBase.put("ice-cream", 10);
    }

    public static void aMonthPasses() {
        zookeeper.aMonthPasses();
        for (Animal clas : classes) {
            clas.aMonthPasses();
        }
    }
}
