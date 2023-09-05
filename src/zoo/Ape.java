package zoo;

public abstract class Ape extends Animal {

    public Ape(int age, char gender, String[] eats, int health, int lifeExpectancy,int grow) {
        super(age, gender, eats, health, lifeExpectancy,grow);
    }
    public Ape(){

    }
    @Override
    public boolean aMonthPasses() {
        return false;
    }
}
