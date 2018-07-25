package models;

import java.util.*;

public class VapesStorage {

    public static Map<Integer, Vape> vapes;
    static {
        vapes = new HashMap<>();
        Vape mag = new Vape("Smok", "Mag", 225);
        Vape speeder = new Vape("Revo", "Speeder", 200);

        vapes.put(mag.id, mag);
        vapes.put(speeder.id, speeder);
    }
}
