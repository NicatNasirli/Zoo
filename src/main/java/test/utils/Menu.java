package test.utils;

import lombok.Data;
import test.animals.abstracts.Animal;
import test.animals.concrates.Chimpanzee;
import test.animals.concrates.Gorilla;
import test.animals.concrates.Lion;
import test.animals.concrates.Tiger;
import test.buildings.Enclosure;
import test.buildings.Zoo;
import test.zookeepers.PhysioZookeeper;
import test.zookeepers.PlayZookeeper;
import test.zookeepers.Zookeeper;

import java.util.*;

@Data
public class Menu {

    private final Zoo zoo;
    private final Scanner scanner;

    public Menu(Zoo zoo) {
        this.zoo = zoo;
        this.scanner = new Scanner(System.in);
    }

    private void printMenu() {
        System.out.print("\n \n \n " +
                         "Select transaction by number: \n" +
                         " 1.Show Animals.\n" +
                         " 2.Show Enclosures.\n" +
                         " 3.Show Zookeepers.\n" +
                         " 4.Show Food store.\n" +
                         " 5.Add Animal.\n" +
                         " 6.Add Enclosure.\n" +
                         " 7.Add Zookeeper.\n" +
                         " 8.Feed Animal.\n" +
                         " 9.Add Food.\n" +
                         " 10.Remove Animal.\n" +
                         " 11.Remove Waste.\n" +
                         " 12.Remove Enclosure.\n" +
                         " 13.Remove Zookeeper.\n" +
                         " 14.Exit. " +
                         "\n");
    }


    public boolean menu() {
//        addFoods(this.zoo);
        while (true) {
            printMenu();
            int transaction = getIntegerInput("");
            switch (transaction) {
                case 1:
                    showAnimals();
                    break;

                case 2:
                    showEnclosures();
                    break;
                case 3:
                    showZookeepers();
                    break;
                case 4:
                    showFoodStore();
                    break;
                case 5:
                    addAnimal();
                    break;
                case 6:
                    addEnclosure();
                    break;
                case 7:
                    addZookeeper();
                    break;
                case 8:
                    feedAnimal();
                    break;
                case 9:
                    addFood();
                    break;
                case 10:
                    removeAnimal();
                    break;
                case 11:
                    removeWaste();
                    break;
                case 12:
                    removeEnclosure();
                    break;
                case 13:
                    removeZookeeper();
                    break;
                default:
                    return true;
            }
        }
    }


    private void showAnimals() {
        List<Animal> animalsList = getAnimals();
        animalsList.forEach(animal -> System.out.print(animal.toString()));
    }

    private int getIntegerInput(String inputMessage) {
        System.out.print('\n' + inputMessage);
        return this.scanner.nextInt();
    }

    private String getStringInput(String inputMessage) {
        System.out.print('\n' + inputMessage);
        return this.scanner.next();
    }

    private void showEnclosures() {
        Set<Integer> enclosureKeys = zoo.getEnclosures().keySet();
        for (int enclosureKey : enclosureKeys) {
            System.out.print(zoo.getEnclosures().get(enclosureKey).toString());
        }
    }

    private void showZookeepers() {
        Set<Integer> zookeepersKeys = zoo.getZookeepers().keySet();
        for (int zookeepersKey : zookeepersKeys) {
            System.out.print(zoo.getZookeepers().get(zookeepersKey).toString());
        }
    }

    private void showFoodStore() {
        HashMap<String, FoodContainer> foods = zoo.getFoodStore().getFoods();
        Set<String> foodKeys = foods.keySet();
        for (String foodKey : foodKeys) {
            System.out.print(foods.get(foodKey).toString());
        }
    }

    private void addAnimalRoot(Animal animal, Enclosure enclosure, Zookeeper zookeeper) {
        List<Animal> animals = getAnimals();
        if (!zoo.checkIfEnclosureExists(enclosure)) {
            throw new CustomException("Enclosure not found!");
        }
        if (!zoo.checkIfZookeeperExists(zookeeper)) {
            throw new CustomException("Zookeeper not found!");
        }
        for (Animal animal1 : animals) {
            if (animal1.getId() == animal.getId()) {
                throw new CustomException("Animal id already exists!");
            }
        }
        enclosure.addAnimal(animal);
        zookeeper.assignAnimal(animal);
    }

    private void addAnimal() {
        int enclosureId = getIntegerInput("Enter enclosure id: ");
        int zookeeperId = getIntegerInput("Enter zookeeper id: ");
        String animalType = getStringInput("Enter animal type: ");

        //animal info
        int animalId = getIntegerInput("Enter animal id: ");
        int animalAge = getIntegerInput("Enter animal age: ");
        String animalGender = getStringInput("Enter animal gender: ");
        int animalHealth = getIntegerInput("Enter animal health: ");


        Enclosure enclosure = zoo.getEnclosure(enclosureId);
        Zookeeper zookeeper = zoo.getZookeepers().get(zookeeperId);

        Animal animal = null;
        switch (animalType.toLowerCase()) {
            case "lion":
                animal = new Lion(animalId, animalAge, animalGender.toCharArray()[0], animalHealth);
                break;
            case "tiger":
                animal = new Tiger(animalId, animalAge, animalGender.toCharArray()[0], animalHealth);
                break;
            case "gorilla":
                animal = new Gorilla(animalId, animalAge, animalGender.toCharArray()[0], animalHealth);
                break;
            case "chimpanzee":
                animal = new Chimpanzee(animalId, animalAge, animalGender.toCharArray()[0], animalHealth);
                break;
            default:
                System.out.println("Unknown animal type!");
        }

        this.addAnimalRoot(animal, enclosure, zookeeper);
    }

    private List<Animal> getAnimals() {
        List<Animal> animalsList = new ArrayList<>();
        HashMap<Integer, Enclosure> enclosures = zoo.getEnclosures();
        Set<Integer> enclosureKeys = enclosures.keySet();
        for (int enclosureKey : enclosureKeys) {
            Enclosure enclosure = enclosures.get(enclosureKey);
            HashMap<Integer, Animal> animals = enclosure.getAnimals();
            Set<Integer> animalKeys = animals.keySet();
            for (int animalKey : animalKeys) {
                Animal animal = animals.get(animalKey);
                animalsList.add(animal);
            }
        }
        return animalsList;
    }

    private void addEnclosure() {
        int id = getIntegerInput("Enter enclosure id: ");
        if (zoo.checkIfEnclosureExists(id)) {
            throw new CustomException("Enclosure id already exists!");
        }
        zoo.addEnclosure(new Enclosure(id));
    }

    private void addZookeeper() {
        String type = getStringInput("[play,physio]" +
                                     "\nZookeeper type: ");
        int id = getIntegerInput("Enter zookeeper id: ");
        if (zoo.checkIfZookeeperExists(id)) {
            throw new CustomException("Zookeeper id already exists!");
        }
        Zookeeper zookeeper = null;
        switch (type.toLowerCase()) {
            case "play":
                zookeeper = new PlayZookeeper(id);
                break;
            case "physio":
                zookeeper = new PhysioZookeeper(id);
                break;
            default:
                System.out.println("Incorrect zookeeper type");
        }
        zoo.addZookeeper(zookeeper);
    }

    private void feedAnimal() {
        List<Animal> animals = getAnimals();
        int animalId = getIntegerInput("Enter animal id: ");
        Animal animal = null;
        for (Animal animall : animals) {
            if (animall.getId() == animalId) {
                animal = animall;
            }
        }
        if (animal.equals(null)) {
            System.out.println("Animal not found!");
        }
        String foodName = getStringInput("Enter food name: ");
        Food food = zoo.getFoodStore().getFoods().get(foodName).getFood();
        Zookeeper zookeeper = animal.getZookeeper();
        zookeeper.feedAnimal(zoo.getFoodStore(), food, animal);
    }

    private void addFood() {
        String foodName = getStringInput("Enter food name: ");
        if (!zoo.getFoodStore().checkIfFoodExists(foodName)) {
            throw new CustomException("Food does not exists!");
        }
        int quantity = getIntegerInput("Enter quantity: ");

        Food food = zoo.getFoodStore().getFoods().get(foodName).getFood();
        zoo.getFoodStore().addFood(food, quantity);

        System.out.println("Added" + quantity + foodName + " to the food store!");
    }

    private void removeAnimal() {
        int animalId = getIntegerInput("Enter animal id: ");
        Animal animal = zoo.findAnimalById(animalId);
        if (animal == null) {
            throw new CustomException("Animal not found!");
        }
        zoo.removeAnimal(animal);
        System.out.println("Animal with id " + animal.getId() + " removed!");

    }

    private void addFoods() {
        // default food types
        Food celery = new Food("Celery", 0, 1);
        Food hay = new Food("Hay", 1, 4);
        Food iceCream = new Food("Ice-Cream", 1, 3);
        Food steak = new Food("Steak", 3, 4);
        zoo.getFoodStore().addNewFood(celery);
        zoo.getFoodStore().addNewFood(hay);
        zoo.getFoodStore().addNewFood(iceCream);
        zoo.getFoodStore().addNewFood(steak);

    }

    //removes 5 wastes
    private void removeWaste() {
        int enclosureId = getIntegerInput("Enter enclosure id: ");
        Enclosure enclosure = zoo.getEnclosures().get(enclosureId);
        enclosure.removeWaste(5);
        System.out.println("Removed 5 wastes");
    }

    private void removeEnclosure(){
        int enclosureId = getIntegerInput("Enter enclosure id: ");
        zoo.removeEnclosure(zoo.getEnclosure(enclosureId));
        System.out.println("Removed enclosure with the id " + enclosureId);
    }

    private void removeZookeeper(){
        int zookeeperId = getIntegerInput("Enter zookeeper id: ");
        zoo.removeZookeeper(zoo.getZookeepers().get(zookeeperId));
        System.out.println("Removed zookeeper with the id " + zookeeperId);
    }
}
