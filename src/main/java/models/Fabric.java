package models;

public class Fabric {
    private static int REF_ID = 1000;

    public int id;
    public String category;  //knit, woven
    public String base;      //polyester, cotton, poly-lycra, cotton-lycra
    public String bestStore; //SoSewEnglish, Knitorious, SlyFoxFabrics
    public String name;      //liverpool, scuba-crepe, dr-who, star-wars
    public Boolean isCustom;

    public Fabric (String category, String base, String bestStore, String name, Boolean isCustom) {
        this.id = REF_ID++;
        this.category = category;
        this.base = base;
        this.bestStore = bestStore;
        this.name = name;
        this.isCustom = isCustom;
    }

    public String toString() {
        return name + " is a " + category + " with a base of " + base + " and is widely available at " + bestStore
            + "\n Custom: " + isCustom;
    }

}