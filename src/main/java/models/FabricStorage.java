package models;

import java.util.HashMap;
import java.util.Map;

public class FabricStorage {
    public static Map<Integer, Fabric> fabrics;

    static  {
        fabrics = new HashMap<>();
        Fabric doctorWho = new Fabric("knit fabric", "cotton-lycra", "Knitorious Fabric", "Doctor Who", true);
        Fabric lilly = new Fabric("knit fabric", "French Terry", "SoSewEnglish Fabrics", "Charcoal Blush Lilly", false);
        Fabric deadpool = new Fabric("woven fabric", "PUL (polyurethane laminate)", "MadHouse Custom Fabrics", "Deadpool Argyle", true);

        fabrics.put(doctorWho.id, doctorWho);
        fabrics.put(lilly.id, lilly);
        fabrics.put(deadpool.id, deadpool);
    }
}