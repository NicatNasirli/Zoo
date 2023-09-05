package zoo;

import java.util.*;

public class Enclosure {
    public static Hashtable<String,Animal> lions = new Hashtable<>();
    public static Hashtable<String,Animal> gorillas = new Hashtable<>();
    public static Hashtable<String,Animal> chimpanzees = new Hashtable<>();
    public static Hashtable<String,Animal> tigers = new Hashtable<>();
    public static Hashtable<Hashtable<String,Animal>, Integer> wastes = new Hashtable<>();

    public static void addAnimal(Hashtable<String,Animal> animals,String key, Animal animal) {
        animals.put(key,animal);
    }

    public static void removeAnimal() {
        Scanner scanner = new Scanner(System.in);
        ZooUtil.enclosures();
        String enclosureName = scanner.nextLine();
        System.out.print("Animal name:");
        String animalName = scanner.nextLine();
        String info = "Animal do not found!";

        switch (enclosureName.toLowerCase()) {
            case "lions":
                if(Objects.nonNull(lions.get(animalName))){
                    lions.remove(animalName);
                }else System.out.println(info);
            break;
            case "tigers" :
                if(Objects.nonNull(tigers.get(animalName))){
                    tigers.remove(animalName);
                }else System.out.println(info);
                break;
            case "chimpanzees":
                if(Objects.nonNull(chimpanzees.get(animalName))){
                    chimpanzees.remove(animalName);
                }else System.out.println(info);
                break;
            case "gorillas":
                if(Objects.nonNull(gorillas.get(animalName))){
                    gorillas.remove(animalName);
                }else System.out.println(info);
                break;
            default : System.out.println("Wrong enclosure name !");
        }
    }

    public static int getWasteSize(Hashtable<String,Animal> animals) {
        int waste = 0;
        if (wastes.get(animals) != null) {
            waste = wastes.get(animals);
        }
        return waste;
    }

    public static void removeWaste(Hashtable<String,Animal> animals, int size) {
        if(wastes.get(animals) == null){
            wastes.replace(animals,0);
        }else {
            int newWaste = wastes.get(animals) - size;
            wastes.replace(animals, newWaste);
        }
    }

    public static void healthIncrease(String animalName,Hashtable<String,Animal> animals, String foodType) {
        if (foodType.equalsIgnoreCase("Hay")) {
            animals.get(animalName).setHealth(animals.get(animalName).getHealth() + 1);
        } else if (foodType.equalsIgnoreCase("steak")) {
            animals.get(animalName).setHealth(animals.get(animalName).getHealth()+ 3);
        } else if (foodType.equalsIgnoreCase("fruit")) {
            animals.get(animalName).setHealth(animals.get(animalName).getHealth() + 2);
        } else if (foodType.equalsIgnoreCase("celery")) {
            animals.get(animalName).setHealth(animals.get(animalName).getHealth() + 0);
        } else if (foodType.equalsIgnoreCase("fish")) {
            animals.get(animalName).setHealth(animals.get(animalName).getHealth() + 3);
        } else if (foodType.equalsIgnoreCase("ice-cream")) {
            animals.get(animalName).setHealth(animals.get(animalName).getHealth() + 1);
        } else {
            System.out.println("There is no this type of food.");
        }
    }

    public static void addWaste(Hashtable<String,Animal> animals, String foodType) {
        int waste = 0;
        if (foodType.equalsIgnoreCase("Hay")) {
            waste = 4;
        } else if (foodType.equalsIgnoreCase("steak")) {
            waste = 4;
        } else if (foodType.equalsIgnoreCase("fruit")) {
            waste = 3;
        } else if (foodType.equalsIgnoreCase("celery")) {
            waste = 1;
        } else if (foodType.equalsIgnoreCase("fish")) {
            waste = 2;
        } else if (foodType.equalsIgnoreCase("ice-cream")) {
            waste = 3;
        } else {
            System.out.println("There is no this type of food.");
        }
        if (wastes.get(animals) == null) {
            wastes.put(animals, waste);
        } else {
            if (waste != 0) {
                wastes.replace(animals, getWasteSize(animals) + waste);
            }
        }
    }

    public static void size() {
        int size = 0;
        for (Hashtable<String, Animal> animals : Zoo.enclosures) {
            size += animals.size();
        }
        System.out.println(size);
    }
}
