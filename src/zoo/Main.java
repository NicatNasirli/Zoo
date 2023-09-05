package zoo;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Menu menu = new Menu();
        Zoo.addFoodToBase();
        Enclosure.addAnimal(Enclosure.lions,"lion1",new Lion(2,'F',Lion.eats,10,Lion.lifeExpectancy,0));
        Enclosure.addAnimal(Enclosure.lions,"lion2",new Lion(3,'M',Lion.eats,10,Lion.lifeExpectancy,0));
        Enclosure.addAnimal(Enclosure.lions,"lion3",new Lion(4,'F',Lion.eats,10,Lion.lifeExpectancy,0));
        Enclosure.addAnimal(Enclosure.lions,"lion4",new Lion(5,'M',Lion.eats,11,Lion.lifeExpectancy,0));
        Enclosure.addAnimal(Enclosure.gorillas,"gorilla1",new Lion(2,'F',Gorilla.eats,10,Gorilla.lifeExpectancy,0));
        Enclosure.addAnimal(Enclosure.gorillas,"gorilla2",new Gorilla(3,'M',Gorilla.eats,10,Gorilla.lifeExpectancy,0));
        FoodStore.addFood("hay",4);
        FoodStore.addFood("steak",5);
        FoodStore.addFood("fruit",6);
        FoodStore.addFood("celery",3);
        FoodStore.addFood("fish",2);
        FoodStore.addFood("ice-cream",7);
        menu.menu();
        System.out.println("Exited successfully");

    }
}
