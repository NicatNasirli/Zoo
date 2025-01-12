package test.utils;

import lombok.AllArgsConstructor;
import test.animals.abstracts.Animal;
import test.buildings.Enclosure;
import test.buildings.Zoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class Menu {

    private final Zoo zoo;

    public void printMenu() {
        System.out.print("""
                Select transaction by number: \

                 1.Show Animals.\

                 2.Show Enclosures.\

                 3.Show Zookeepers.\

                 4.Add Animal.\

                 5.Add Enclosure.\

                 6.Add Zookeeper.\

                 7.Feed Animal.\

                 8.Add Food.\

                 9.Remove Food.\

                 10.Remove Animal.\

                 11.Exit.\
                """);
    }

    public List<Animal> showAnimals() {
        System.out.print("\n ");
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
        animalsList.forEach(Animal::toString);
        return animalsList;
    }
}
