import java.util.Comparator;

public class ContainerCountComparator implements Comparator<Container> {
    @Override
    public int compare(Container c1, Container c2) {
        return c1.getNumberOfBoxes() - c2.getNumberOfBoxes();
    }
}
