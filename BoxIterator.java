import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BoxIterator implements Iterator<Box> {

    private final List<Box> cargo;
    private int index;

    public BoxIterator(List<Box> cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean hasNext() {
        return index < cargo.size();
    }

    @Override
    public Box next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cargo.get(index++);
    }
}
