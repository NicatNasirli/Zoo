package zoo;

import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

public class ZooUtil implements Runnable {
    public static Boolean running = true;

    public static void enclosures() {
        System.out.println("Select enclosure" +
                "\nLions" +
                "\nTigers" +
                "\nChimpanzees" +
                "\nGorillas");
    }

    public int takeInput(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(s);
        int number = scanner.nextInt();
        return number;
    }

    public char takeInput2(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(s);
        char c = scanner.next().charAt(0);
        return c;
    }

    public void addAnimalByUser() {
        Scanner scanner = new Scanner(System.in);
        enclosures();
        String enclosureName = scanner.nextLine();
        System.out.print("Animal name:");
        String animalName = scanner.nextLine();
        int age = takeInput("Enter age:");
        char gender = takeInput2("Enter gender:");
        int health = takeInput("Enter health:");
        switch (enclosureName.toLowerCase()) {
            case "lions" ->
                    Enclosure.addAnimal(Enclosure.lions, animalName, new Lion(age, gender, Lion.eats, health, Lion.lifeExpectancy, 0));
            case "tigers" ->
                    Enclosure.addAnimal(Enclosure.tigers, animalName, new Tiger(age, gender, Tiger.eats, health, Tiger.lifeExpectancy, 0));
            case "chimpanzees" ->
                    Enclosure.addAnimal(Enclosure.chimpanzees, animalName, new Chimpanzee(age, gender, Chimpanzee.eats, health, Chimpanzee.lifeExpectancy, 0));
            case "gorillas" ->
                    Enclosure.addAnimal(Enclosure.gorillas, animalName, new Gorilla(age, gender, Gorilla.eats, health, Gorilla.lifeExpectancy, 0));
            default -> System.out.println("Wrong enclosure name!");
        }
    }

    public void showAllAnimals() {
        Zoo.enclosures.forEach(stringAnimalHashtable -> System.out.println(stringAnimalHashtable.keySet()));

    }

    public void feedAnimal() {
        Scanner scanner = new Scanner(System.in);
        enclosures();
        String enclosureName = scanner.nextLine();
        System.out.print("Animal name:");
        String animalName = scanner.nextLine();
        System.out.print("Food type:");
        String foodName = scanner.nextLine();
        switch (enclosureName.toLowerCase()) {
            case "lions" -> Lion.eat(foodName, animalName, Enclosure.lions);
            case "tigers" -> Tiger.eat(foodName, animalName, Enclosure.tigers);
            case "chimpanzees" -> Chimpanzee.eat(foodName, animalName, Enclosure.chimpanzees);
            case "gorillas" -> Gorilla.eat(foodName, animalName, Enclosure.gorillas);
            default -> System.out.println("Wrong enclosure name!");
        }
    }

    public static void getFoodStore() {
        FoodStore.foods.forEach((s, integer) -> System.out.println(s + " = " + integer));
    }


    public void treatAnimal() {
        Scanner scanner = new Scanner(System.in);
        enclosures();
        String enclosureName = scanner.nextLine();
        System.out.print("Animal name:");
        String animalName = scanner.nextLine();
        String info = "Animal treated!";
        switch (enclosureName.toLowerCase()) {
            case "lions" -> {
                Lion.treat(animalName);
                System.out.println(info);
            }

            case "tigers" -> {
                Tiger.treat(animalName);
                System.out.println(info);
            }
            case "chimpanzees" -> {
                Chimpanzee.treat(animalName);
                System.out.println(info);
            }
            case "gorillas" -> {
                Gorilla.treat(animalName);
                System.out.println(info);
            }
            default -> System.out.println("Wrong enclosure name!");
        }
    }

    public void showStatus() {
        Zoo.enclosures.forEach(stringAnimalHashtable -> System.out.println(stringAnimalHashtable.toString()));
    }

    @Override
    public void run() {
        int count = 0;
        while (running) {
            try {
                Zoo.aMonthPasses();
                Thread.sleep(10000);
                if (count == 2) {
                    breed();
                    count = 0;
                }
                count++;
            } catch (InterruptedException ignored) {
            }
        }
    }
    public static void breed() {
        Random random = new Random();
        int ifBirth = random.nextInt(0, 2);
        int gender = random.nextInt(1, 3);
        int lMale = 0;
        int lFemale = 0;
        int tMale = 0;
        int tFemale = 0;
        int gMale = 0;
        int gFemale = 0;
        int cMale = 0;
        int cFemale = 0;
        for (Hashtable<String, Animal> animals : Zoo.enclosures) {
            for (String key : animals.keySet()) {
                if (!animals.isEmpty()) {
                    if (animals.get(key).getGender() == 'F' || animals.get(key).getGender() == 'f') {
                        if (animals.equals(Enclosure.lions)) {
                            lFemale++;
                        } else if (animals.equals(Enclosure.tigers)) {
                            tFemale++;
                        } else if (animals.equals(Enclosure.gorillas)) {
                            gFemale++;
                        } else if (animals.equals(Enclosure.chimpanzees)) {
                            cFemale++;
                        }
                    } else if (animals.get(key).gender == 'M' || animals.get(key).gender == 'm') {
                        if (animals.equals(Enclosure.lions)) {
                            lMale++;
                        } else if (animals.equals(Enclosure.tigers)) {
                            tMale++;
                        } else if (animals.equals(Enclosure.gorillas)) {
                            gMale++;
                        } else if (animals.equals(Enclosure.chimpanzees)) {
                            cMale++;
                        }
                    }
                } else break;
            }
            if (animals.equals(Enclosure.lions) && (lMale >= 1 && lFemale >= 1)) {
                ifBirth(ifBirth, random, animals, "Lion", new Lion(0, (gender == 1) ? 'M' : 'F', Lion.eats, 10, Lion.lifeExpectancy, 0));
            } else if (animals.equals(Enclosure.tigers) && (tMale >= 1 && tFemale >= 1)) {
                ifBirth(ifBirth, random, animals, "Tiger", new Tiger(0, (gender == 1) ? 'M' : 'F', Tiger.eats, 10, Tiger.lifeExpectancy, 0));
            } else if (animals.equals(Enclosure.gorillas) && (gMale >= 1 && gFemale >= 1)) {
                ifBirth(ifBirth, random, animals, "Gorilla", new Gorilla(0, (gender == 1) ? 'M' : 'F', Gorilla.eats, 10, Gorilla.lifeExpectancy, 0));
            } else if (animals.equals(Enclosure.chimpanzees) && (cMale >= 1 && cFemale >= 1)) {
                ifBirth(ifBirth, random, animals, "Chimpanzee", new Chimpanzee(0, (gender == 1) ? 'M' : 'F', Chimpanzee.eats, 10, Chimpanzee.lifeExpectancy, 0));
            }
        }
    }

    public static void ifBirth(int ifBirth, Random random, Hashtable<String, Animal> animals, String name, Animal animal) {
        if (ifBirth == 1) {
            int randomKey = random.nextInt(1, 10);
            while (animals.containsKey(name + randomKey)) {
                randomKey++;
                animals.putIfAbsent(name + randomKey, animal);
                System.out.println("\nNew " + name +" has born!");
            }
            if (!animals.containsKey(name + randomKey)) {
                animals.put(name + randomKey, animal);
                System.out.println("\nNew " + name +" has born!");
            }
        }
    }
}
