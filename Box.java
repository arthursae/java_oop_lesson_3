import java.util.UUID;

public class Box implements Comparable<Box> {

    private Double grossWeight;
    private final UUID uuid;

    public Box(Double grossWeight) {
        this.uuid = UUID.randomUUID();
        this.grossWeight = grossWeight;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    @Override
    public String toString() {
        int weight = (int) Math.round(grossWeight);
        return "Box " +
                "UUID: " + getUUID() + "\t" +
                "Gross Weight: " + weight;
    }

    @Override
    public int compareTo(Box box) {
        return (int) (getGrossWeight() - box.getGrossWeight());
    }
}
