package test.zookeepers;

import lombok.Data;
import test.animals.abstracts.Animal;
import test.buildings.Enclosure;
import test.buildings.FoodStore;
import test.utils.CustomException;
import test.utils.Food;
import test.utils.FoodContainer;

import java.util.HashMap;
import java.util.Set;

@Data
public class Zookeeper {
    private int id;

    private HashMap<Integer, Animal> animals;

    public Zookeeper(int id) {
        this.id = id;
        this.animals = new HashMap<>();
    }

    public void stroke(Animal animal) {
        animal.setHealth(animal.getHealth() + 2);
        setMaxHealth(animal);
    }

    public void hug(Animal animal) {
        animal.setHealth(animal.getHealth() + 3);
        setMaxHealth(animal);
    }

    public boolean ifThereIsFood(FoodStore foodStore, Food food) {
        int size = foodStore.getFoods().get(food.getName()).getSize();
        return size > 0;
    }

    public int feedAnimal(FoodStore foodStore, Food food, Animal animal) {
        if (ifThereIsFood(foodStore, food)) {
            foodStore.removeFood(food, 1);
            animal.eat(food);
            return food.getWaste();
        } else throw new CustomException("No food found!");
    }

    public void addFoodToEachContainer(FoodStore foodStore) {
        HashMap<String, FoodContainer> foods = foodStore.getFoods();
        Set<String> keys = foods.keySet();
        for (String key : keys) {
            foods.get(key).setSize(foods.get(key).getSize() + 1);
        }
    }

    public void removeWasteFromEnclosure(Enclosure enclosure) {
        if (enclosure.getWaste() >= 1) {
            enclosure.setWaste(enclosure.getWaste() - 1);
        }
    }

    public void assignAnimal(Animal animal) {
        this.animals.put(animal.getId(), animal);
        animal.setZookeeper(this);
    }

    public void removeAnimal(Animal animal) {
        this.animals.remove(animal.getId());
        animal.setZookeeper(null);
    }


    public boolean aMonthPasses(FoodStore foodStore, Enclosure enclosure) {
        addFoodToEachContainer(foodStore);
        removeWasteFromEnclosure(enclosure);
        return true;
    }

    public void setMaxHealth(Animal animal){
        if (animal.getHealth() >= 10){
            animal.setHealth(10);
        }
    }
}
