package test.utils;

import lombok.AllArgsConstructor;
import test.animals.abstracts.Animal;
import test.animals.concrates.Chimpanzee;
import test.animals.concrates.Gorilla;
import test.animals.concrates.Lion;
import test.animals.concrates.Tiger;
import test.buildings.Enclosure;
import test.buildings.Zoo;
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
                         " 4.Add Animal.\n" +
                         " 5.Add Enclosure.\n" +
                         " 6.Add Zookeeper.\n" +
                         " 7.Feed Animal.\n" +
                         " 8.Add Food.\n" +
                         " 9.Remove Food.\n" +
                         " 10.Remove Animal.\n" +
                         " 11.Exit. " +
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
                default:
                    continueTransaction = false;
            }
        }
    }

    private void showAnimals() {
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

    private void addAnimalRoot(Animal animal, Enclosure enclosure, Zookeeper zookeeper) {
        if (!this.zoo.checkIfEnclosureExists(enclosure)) {
            throw new CustomException("Enclosure not found!");
        }
        if (!this.zoo.checkIfZookeeperExists(zookeeper)) {
            throw new CustomException("Zookeeper not found!");
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

        this.addAnimalRoot(animal,enclosure,zookeeper);
    }
}
