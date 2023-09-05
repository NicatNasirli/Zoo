package zoo;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Objects;

public class Tiger extends BigCat {
    public Tiger(int age, char gender, String[] eats, int health, int lifeExpectancy,int grow) {
        super(age, gender, eats, health, lifeExpectancy,grow);
    }

    public Tiger() {
    }
    public static String[] eats = {"steak", "celery"};
    public static int lifeExpectancy = 24;

    public static boolean canEat(String s) {
        for (String eat : eats) {
            if (Objects.equals(eat, s)) {
                return true;
            }
        }
        return false;
    }
    public static Animal getAnimal(String key) {
        return Enclosure.tigers.get(key);
    }


    public static void eat(String foodType, String animalName, Hashtable<String, Animal> animals) {
        if (getAnimal(animalName).getHealth() <= 10) {
            if (canEat(foodType)) {
                Zookeeper.carryFood(foodType);
                Enclosure.addWaste(animals, foodType);
                Enclosure.healthIncrease(animalName, animals, foodType);
            } else {
                System.out.println("Invalid food type.");
            }
        }else getAnimal(animalName).setHealth(10);
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public char getGender() {
        return super.getGender();
    }

    @Override
    public int getLifeExpectancy(Animal animal) {
        return super.getLifeExpectancy(animal);
    }

    public static void treat(String animalName) {
        Zookeeper.stroke();
        getAnimal(animalName).setHealth(getAnimal(animalName).getHealth() + 3);
    }
    public void eatItself(String animalName) {
        Zookeeper.carryFood("celery");
        Enclosure.addWaste(Enclosure.tigers, "celery");
        Enclosure.healthIncrease(animalName, Enclosure.tigers, "celery");
    }
    @Override
    public boolean aMonthPasses() {
        Iterator<String> iterator =  Enclosure.tigers.keySet().iterator();
        if (!Enclosure.tigers.isEmpty()) {
            while(iterator.hasNext()){
                String key = iterator.next();
                eatItself(key);
                if (getAnimal(key).getGrow() % 12 == 0) {
                    getAnimal(key).age = getAnimal(key).age + 1;
                }
                getAnimal(key).setGrow(getAnimal(key).getGrow() + 1);
                if(getAnimal(key).getHealth() >= 10){
                    getAnimal(key).setHealth(10);
                }
                int newHealth = getAnimal(key).getHealth() - 2;
                getAnimal(key).setHealth(newHealth);
                if (getAnimal(key).getHealth() <= 0 || getAnimal(key).getGrow() == getLifeExpectancy(getAnimal(key))) {
                    iterator.remove();
                    System.out.println("\n" + key + " died!");
                }
            }
            return true;
        }
        return false;
    }
}
