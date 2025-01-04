package test.buildings;

import java.util.HashMap;

public class Zoo {
    private HashMap<Integer, Enclosure> enclosures;


    public Zoo() {
        this.enclosures = new HashMap<>();
    }

    public void addEnclosure(Enclosure enclosure){
        this.enclosures.put(enclosure.getId(),enclosure);
    }

    public void removeEnclosure(Enclosure enclosure){
        this.enclosures.remove(enclosure.getId());
    }

    public Enclosure getEnclosure(int id){
        return this.enclosures.get(id);
    }
}
