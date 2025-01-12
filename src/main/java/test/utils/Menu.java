package test.utils;

import lombok.AllArgsConstructor;
import test.animals.abstracts.Animal;
import test.animals.concrates.Chimpanzee;
import test.animals.concrates.Gorilla;
import test.animals.concrates.Lion;
import test.animals.concrates.Tiger;
import test.buildings.Enclosure;
import test.buildings.FoodStore;
import test.buildings.Zoo;
import test.zookeepers.PhysioZookeeper;
import test.zookeepers.PlayZookeeper;
import test.zookeepers.Zookeeper;

import java.util.*;

@AllArgsConstructor
public class Menu {

    private final Zoo zoo;

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
                         " 10.Remove Food.\n" +
                         " 11.Remove Animal.\n" +
                         " 12.Exit. " +
                         "\n");
    }


    public void menu() {
        Scanner input = new Scanner(System.in);
        boolean continueTransaction = true;
        while (continueTransaction) {
            printMenu();
            int transaction = input.nextInt();
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
                    addAnimal(input);
                    break;
                case 5:
                    showFoodStore();
                    break;
                case 6:
                    addEnclosure(input);
                    break;
                case 7:
                    addZookeeper(input);
                    break;
                case 8:
                    feedAnimal(input);
                    break;
                default:
                    continueTransaction = false;
            }
        }
    }

    private void showAnimals() {
        List<Animal> animalsList = getAnimals();
        animalsList.forEach(animal -> System.out.print(animal.toString()));
    }

    private void showEnclosures() {
        Set<Integer> enclosureKeys = this.zoo.getEnclosures().keySet();
        for (int enclosureKey : enclosureKeys) {
            System.out.print(this.zoo.getEnclosures().get(enclosureKey).toString());
        }
    }

    private void showZookeepers() {
        Set<Integer> zookeepersKeys = this.zoo.getZookeepers().keySet();
        for (int zookeepersKey : zookeepersKeys) {
            System.out.print(this.zoo.getZookeepers().get(zookeepersKey).toString());
        }
    }

    private void showFoodStore() {
        HashMap<String, FoodContainer> foods = this.zoo.getFoodStore().getFoods();
        Set<String> foodKeys = foods.keySet();
        for (String foodKey : foodKeys) {
            System.out.print(foods.get(foodKey).toString());
        }
    }

    private void addAnimalRoot(Animal animal, Enclosure enclosure, Zookeeper zookeeper) {
        List<Animal> animals = getAnimals();
        if (!this.zoo.checkIfEnclosureExists(enclosure)) {
            throw new CustomException("Enclosure not found!");
        }
        if (!this.zoo.checkIfZookeeperExists(zookeeper)) {
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

    private void addAnimal(Scanner scanner) {
        System.out.print("Enter enclosure id: ");
        int enclosureId = scanner.nextInt();
        System.out.print("\nEnter zookeeper id: ");
        int zookeeperId = scanner.nextInt();
        System.out.print("\nEnter animal type: ");
        String animalType = scanner.next();

        //animal info
        System.out.print("\nEnter animal id: ");
        int animalId = scanner.nextInt();
        System.out.print("\nEnter animal age: ");
        int animalAge = scanner.nextInt();
        System.out.print("\nEnter animal gender: ");
        String animalGender = scanner.next();
        System.out.print("\nEnter animal health: ");
        int animalHealth = scanner.nextInt();


        Enclosure enclosure = this.zoo.getEnclosure(enclosureId);
        Zookeeper zookeeper = this.zoo.getZookeepers().get(zookeeperId);

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
        HashMap<Integer, Enclosure> enclosures = this.zoo.getEnclosures();
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

    private void addEnclosure(Scanner scanner) {
        System.out.print("Enter enclosure id: ");
        int id = scanner.nextInt();
        if (this.zoo.checkIfEnclosureExists(id)) {
            throw new CustomException("Enclosure id already exists!");
        }
        this.zoo.addEnclosure(new Enclosure(id));
    }

    private void addZookeeper(Scanner scanner) {
        System.out.print("[play,physio]" +
                         "\nZookeeper type: ");
        String type = scanner.next();
        System.out.print("Enter zookeeper id: ");
        int id = scanner.nextInt();
        if (this.zoo.checkIfEnclosureExists(id)) {
            throw new CustomException("Enclosure id already exists!");
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
        this.zoo.addZookeeper(zookeeper);
    }

    private void feedAnimal(Scanner scanner) {
        List<Animal> animals = this.getAnimals();
        System.out.print("Enter animal id: ");
        int animalId = scanner.nextInt();
        Animal animal = null;
        for (Animal animall : animals) {
            if (animall.getId() == animalId) {
                animal = animall;
            }
        }
        if (animal.equals(null)) {
            throw new CustomException("Animal not found!");
        }
        System.out.print("Enter food name: ");
        String foodName = scanner.next();
        Food food = this.zoo.getFoodStore().getFoods().get(foodName).getFood();
        Zookeeper zookeeper = animal.getZookeeper();
        zookeeper.feedAnimal(this.zoo.getFoodStore(), food, animal);
    }
}
