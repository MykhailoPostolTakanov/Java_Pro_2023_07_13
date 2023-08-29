package generics;

import java.util.LinkedList;
import java.util.List;

public class Box<E extends Fruit> {
    private final LinkedList<E> list = new LinkedList<E>();

    public LinkedList getItems() {
        return new LinkedList(list);
    }

    public E add(E object) {
        list.add(object);
        return list.getLast();
    }

    public List<E> add(List<E> objects) {
        list.addAll(objects);
        return new LinkedList(list);
    }

    public float getWeight() {
        if (list.size() == 0)
            return 0;
        return list.getLast().getWeight() * list.size();
    }

    public boolean compare(Box box) {
        float result = 0;
        if (list.size() != 0)
            result = list.getLast().getWeight() * list.size();
        if (result == box.getWeight())
            return true;
        return false;
    }

    public void merge(Box<E> box) {
        list.addAll(box.getItems());
    }
}
