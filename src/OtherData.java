public class OtherData {
    private final String name;
    private final String characteristics;
    private final String unit;
    private final String cost;
    private final String number;

    public OtherData(String name, String characteristics, String unit, String cost,
                     String number) {
        this.name = name;
        this.characteristics = characteristics;
        this.unit = unit;
        this.cost = cost;
        this.number = number;
    }

    public String toString() {
        return name + " " + characteristics + " " + unit + " " + cost + " " + number;
    }
}
