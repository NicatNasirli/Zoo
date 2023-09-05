package zoo;
public class Menu {
    ZooUtil zooUtil = new ZooUtil();
    public void menu() {
        Thread time = new Thread(zooUtil);
        int count = 1;
        time.start();
        while (count != 0){
            int number = zooUtil.takeInput("Select number to play:" +
                    "\n1: add animal" +
                    "\n2: feed animal" +
                    "\n3: show animals" +
                    "\n4: remove animal" +
                    "\n5: number of animals" +
                    "\n6: print food store" +
                    "\n7: treat animal" +
                    "\n8: show status" +
                    "\n9: Exit" +
                    "\n");
            switch (number){
                case 1:
                    zooUtil.addAnimalByUser();
                    break;
                case 2:
                    ZooUtil.getFoodStore();
                    zooUtil.feedAnimal();
                    break;
                case 3:
                    zooUtil.showAllAnimals();
                    break;
                case 4:
                    Enclosure.removeAnimal();
                    break;
                case 5:
                    Enclosure.size();
                    break;
                case 6:
                    ZooUtil.getFoodStore();
                    break;
                case 7:
                    zooUtil.treatAnimal();
                    break;
                case 8:
                    zooUtil.showStatus();
                    break;
                default:
                    count = 0;
                    interrupt(time,false);
            }
        }
    }
    public  void interrupt(Thread thread,boolean b){
        ZooUtil.running = b;
    }
}
