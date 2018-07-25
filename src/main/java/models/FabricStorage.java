package models;

import java.util.HashMap;
import java.util.Map;

public class FabricStorage {
    public static Map<Integer, Fabric> fabric;

    static  {
        fabric = new HashMap<>();
        Fabric doctorWho = new Fabric("knit", "cotton-lycra", "Knitorious Fabric", "Doctor Who", true);
        Fabric lilly = new Fabric("knit", "French Terry", "SoSewEnglish Fabrics", "Charcoal Blush Lilly", false);
        Fabric deadpool = new Fabric("woven", "PUL", "MadHouse Custom Fabrics", "Deadpool Argyle", true);

        fabric.put(doctorWho.id, doctorWho);
        fabric.put(lilly.id, lilly);
        fabric.put(deadpool.id, deadpool);
    }
}