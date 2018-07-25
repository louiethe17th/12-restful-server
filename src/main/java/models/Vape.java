package models;

public class Vape {
    private static int ID_COUNT = 2_1334;

    public int id;
    public String brand;
    public int wattage;
    public String model;

    public Vape(String brand, String model, int wattage) {

        this.id = ID_COUNT++;
        this.brand = brand;
        this.model = model;
        this.wattage = wattage;

    }

    public String toString(){
        return this.brand + ": " + this.model + " - " + this.wattage + "watt";
    }
}
