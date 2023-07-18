import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Container implements Comparable<Container>, Iterable<Box> {

    private final List<Box> cargo;
    private final UUID id;

    public Container() {
        this.id = UUID.randomUUID();
        cargo = new ArrayList<>();
    }

    public void addCargo(Box box) {
        cargo.add(box);
    }

    public int getNumberOfBoxes() {
        return cargo.size();
    }

    public UUID getId() {
        return id;
    }

    public List<Box> getCargo() {
        return cargo;
    }

    public int getTotalWeight() {
        Double sum = 0.0;

        for (Box box : cargo) {
            sum += box.getGrossWeight();
        }

        return (int) Math.round(sum);
    }

    @Override
    public int compareTo(Container c) {
        return getTotalWeight() - c.getTotalWeight();
    }

    @Override
    public Iterator<Box> iterator() {
        return new BoxIterator(cargo);
    }
}
