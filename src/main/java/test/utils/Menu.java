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

import java.io.File;
import java.io.IOException;
import java.util.*;

@Data
public class Menu {

    private final FileUtil fileUtil;
    private final File file;
    private Zoo zoo;

    public Menu() throws IOException, ClassNotFoundException {
        this.fileUtil = new FileUtil();
        this.file = fileUtil.getFile();
        this.zoo = fileUtil.readObjectFromFile(fileUtil.getFile());
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
                         " 11.Exit. " +
                         "\n");
    }


    public void menu() throws IOException, ClassNotFoundException {
//        addFoods(this.zoo);
        Scanner input = new Scanner(System.in);
        boolean continueTransaction = true;
        while (continueTransaction) {
            zoo = this.fileUtil.readObjectFromFile(file);
            printMenu();
            int transaction = input.nextInt();
            switch (transaction) {
                case 1:
                    showAnimals(zoo);
                    break;

                case 2:
                    showEnclosures(zoo);
                    break;
                case 3:
                    showZookeepers(zoo);
                    break;
                case 4:
                    showFoodStore(zoo);
                    break;
                case 5:
                    addAnimal(input, zoo);
                    break;
                case 6:
                    addEnclosure(input, zoo);
                    break;
                case 7:
                    addZookeeper(input, zoo);
                    break;
                case 8:
                    feedAnimal(input, zoo);
                    break;
                case 9:
                    addFood(input, zoo);
                    break;
                case 10:
                    removeAnimal(input, zoo);
                    break;
                default:
                    continueTransaction = false;
            }
            this.fileUtil.writeObjectToFile(file, this.zoo);
        }
    }

    private void showAnimals(Zoo zoo) {
        List<Animal> animalsList = getAnimals(zoo);
        animalsList.forEach(animal -> System.out.print(animal.toString()));
    }

    private void showEnclosures(Zoo zoo) {
        Set<Integer> enclosureKeys = zoo.getEnclosures().keySet();
        for (int enclosureKey : enclosureKeys) {
            System.out.print(zoo.getEnclosures().get(enclosureKey).toString());
        }
    }

    private void showZookeepers(Zoo zoo) {
        Set<Integer> zookeepersKeys = zoo.getZookeepers().keySet();
        for (int zookeepersKey : zookeepersKeys) {
            System.out.print(zoo.getZookeepers().get(zookeepersKey).toString());
        }
    }

    private void showFoodStore(Zoo zoo) {
        HashMap<String, FoodContainer> foods = zoo.getFoodStore().getFoods();
        Set<String> foodKeys = foods.keySet();
        for (String foodKey : foodKeys) {
            System.out.print(foods.get(foodKey).toString());
        }
    }

    private void addAnimalRoot(Animal animal, Enclosure enclosure, Zookeeper zookeeper, Zoo zoo) {
        List<Animal> animals = getAnimals(zoo);
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

    private void addAnimal(Scanner scanner, Zoo zoo) {
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

        this.addAnimalRoot(animal, enclosure, zookeeper, zoo);
    }

    private List<Animal> getAnimals(Zoo zoo) {
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

    private void addEnclosure(Scanner scanner, Zoo zoo) {
        System.out.print("Enter enclosure id: ");
        int id = scanner.nextInt();
        if (zoo.checkIfEnclosureExists(id)) {
            throw new CustomException("Enclosure id already exists!");
        }
        zoo.addEnclosure(new Enclosure(id));
    }

    private void addZookeeper(Scanner scanner, Zoo zoo) {
        System.out.print("[play,physio]" +
                         "\nZookeeper type: ");
        String type = scanner.next();
        System.out.print("Enter zookeeper id: ");
        int id = scanner.nextInt();
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

    private void feedAnimal(Scanner scanner, Zoo zoo) {
        List<Animal> animals = getAnimals(zoo);
        System.out.print("Enter animal id: ");
        int animalId = scanner.nextInt();
        Animal animal = null;
        for (Animal animall : animals) {
            if (animall.getId() == animalId) {
                animal = animall;
            }
        }
        if (animal.equals(null)) {
            System.out.println("Animal not found!");
        }
        System.out.print("Enter food name: ");
        String foodName = scanner.next();
        Food food = zoo.getFoodStore().getFoods().get(foodName).getFood();
        Zookeeper zookeeper = animal.getZookeeper();
        zookeeper.feedAnimal(zoo.getFoodStore(), food, animal);
    }

    private void addFood(Scanner scanner, Zoo zoo) {
        System.out.print("Enter food name: ");
        String foodName = scanner.next();
        if (!zoo.getFoodStore().checkIfFoodExists(foodName)) {
            throw new CustomException("Food does not exists!");
        }
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        Food food = zoo.getFoodStore().getFoods().get(foodName).getFood();
        zoo.getFoodStore().addFood(food, quantity);
    }

    private void removeAnimal(Scanner scanner, Zoo zoo) {
        System.out.print("Enter animal id: ");
        int animalId = scanner.nextInt();
        Animal animal = zoo.findAnimalById(animalId);
        if (animal == null) {
            throw new CustomException("Animal not found!");
        }
        Enclosure enclosure = animal.getEnclosure();
        enclosure.removeAnimal(animal);
    }

    private void addFoods(Zoo zoo) {
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
}
