package zoo;

public class Zookeeper {

    public void aMonthPasses() {
        for(String foodName : Zoo.foodBase.keySet()){
            if(Zoo.foodBase.get(foodName) >= 0){
                Zoo.takeFood(foodName);
                FoodStore.addFood(foodName, 1);
            }
        }if(!Enclosure.gorillas.isEmpty() || Enclosure.getWasteSize(Enclosure.gorillas) > 0){
            Enclosure.removeWaste(Enclosure.gorillas,1);
        }if(!Enclosure.lions.isEmpty() || Enclosure.getWasteSize(Enclosure.lions) > 0){
            Enclosure.removeWaste(Enclosure.lions,1);
        }if(!Enclosure.chimpanzees.isEmpty() || Enclosure.getWasteSize(Enclosure.chimpanzees) > 0){
            Enclosure.removeWaste(Enclosure.chimpanzees,1);
        }if(!Enclosure.tigers.isEmpty()|| Enclosure.getWasteSize(Enclosure.tigers) > 0){
            Enclosure.removeWaste(Enclosure.tigers,1);
        }
    }
    public static void stroke() {

    }

    public static void hug() {

    }

    public static void carryFood(String foodType) {
        FoodStore.takeFood(foodType);
    }
}

