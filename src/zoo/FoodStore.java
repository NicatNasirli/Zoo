package zoo;

import java.util.Hashtable;

public class FoodStore {
    public static Hashtable<String,Integer> foods = new Hashtable<>();
    public static void addFood(String foodType, int quantity){
        if(foods.get(foodType) == null){
            foods.putIfAbsent(foodType,quantity);
        }else{
            int i = foods.get(foodType) + quantity;
            foods.replace(foodType,i);
        }
    }
    public static void takeFood(String foodType){
        int i = foods.get(foodType) - 1;
        foods.replace(foodType,i);
    }
}
