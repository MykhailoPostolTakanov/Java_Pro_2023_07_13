package generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Box<E extends Fruit> {
    private final LinkedList<E> list = new LinkedList();

    public LinkedList getItems() {
        return new LinkedList(list);
    }

    public E add(E object) {
        list.add(object);
        return list.getLast();
    }

    public List<E> add(List<E> objects) {
        if (objects.size() == 0)
            return new LinkedList<>();
        list.addAll(objects);
        return new LinkedList(list);
    }

    public float getWeight() {
        return list.getLast().getWeight() * list.size();
    }

    public boolean compare(Box box) {
        float result = list.getLast().getWeight() * list.size();
        if (result == box.getWeight())
            return true;
        return false;
    }

    public void merge(Box<E> box) {
        list.addAll(box.getItems());
    }
}
