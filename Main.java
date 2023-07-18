//        Создать класс Контейнер - Container.
//        В контейнере могут быть ящики (класс Box).
//
//        У каждого ящика есть вес.
//        У каждого контейнера есть метод "получить вес" - это сумма всех весов ящиков, которые находятся в контейнере.
//
//        Класс Контейнер должен быть Comparable. Сравнивать он должен по весам контейнера (чем меньше вес, тем меньше контейнер).
//        Класс ContainerCountComparator - Comparator, который сравнивает контейнеры по количеству ящиков (чем меньше ящиков, тем меньше контейнер).
//        Класс контейнер должен быть Iterable - итерирование должно происходить по ящикам внутри контейнера.
//
//        Container c = new Container(...);
//        // ...
//        for (Box box: c) {
//        box - это контейнер
//        }

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Double minWeight = 0.1;
        Double maxWeight = 100.1;
        int numberOfContainers = 2;
        List<Container> containers = new ArrayList<>();

        for (int i = 0; i < numberOfContainers; i++) {
            containers.add(new Container());
        }

        for (int i = 0; i < new Random().nextInt(1, 10); i++) {
            containers.get(0).addCargo(new Box((new Random().nextDouble() * (maxWeight - minWeight) + minWeight)));
        }

        for (int i = 0; i < new Random().nextInt(1, 10); i++) {
            containers.get(1).addCargo(new Box((new Random().nextDouble() * (maxWeight - minWeight) + minWeight)));
        }

        var cargo1 = containers.get(0).getCargo();
        var cargo2 = containers.get(1).getCargo();

        Collections.sort(cargo1);
        Collections.sort(cargo2);

        ContainerCountComparator containersComparator = new ContainerCountComparator();
        var containersDiff = containersComparator.compare(containers.get(0), containers.get(1));

        if (containersDiff > 0) {
            System.err.println("Container #1 has more boxes: +" + containersDiff);
        } else if (containersDiff < 0) {
            System.err.println("Container #1 has less boxes: " + containersDiff);
        } else {
            System.err.println("Both containers have the same number of boxes");
        }


        int diff = containers.get(0).compareTo(containers.get(1));
        if (diff > 0) {
            System.err.println("Container #1 heavier: +" + diff);
        } else if (diff < 0) {
            System.err.println("Container #1 lighter: " + diff);
        } else {
            System.err.println("Both containers have equal weights");
        }

        System.out.printf("%n");
        System.out.println("Total weight for container #1 = " + containers.get(0).getTotalWeight());
        System.out.println("Container #1 contains = " + containers.get(0).getNumberOfBoxes() + " boxes");

        for (Box box : containers.get(0)) {
            System.out.printf("Box UUID: %s\t Gross Weight: %s%n", box.getUUID(), Math.round(box.getGrossWeight()));
        }
        System.out.printf("%n");
        System.out.println("Total weight for container #2  = " + containers.get(1).getTotalWeight());
        System.out.println("Container #2 contains = " + containers.get(1).getNumberOfBoxes() + " boxes");

        for (Box box : containers.get(1)) {
            System.out.printf("Box UUID: %s\t Gross Weight: %s%n", box.getUUID(), Math.round(box.getGrossWeight()));
        }
    }
}
