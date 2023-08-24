package generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Box {
    private final LinkedList list = new LinkedList();
    private static final float APPLE = 1.0F;
    private static final float ORANGE = 1.5F;

    public LinkedList getList() {
        return new LinkedList(list);
    }

    public <E extends Fruit> E add(E object) {
        if (list.size() == 0) {
            list.add(object);
            return (E) list.getLast();
        }
        if (!object.getClass().equals(list.getLast().getClass()))
            throw new DifferentClassException("You can added only one type of fruit in one box!!!");
        list.add(object);
        return (E) list.getLast();
    }

    public <E extends Fruit> List<E> add(List<E> objects) {
        if (objects.size() == 0)
            return new LinkedList<>();
        Class<?> aClass = objects.get(0).getClass();
        for (Object object : objects)
            if (!aClass.equals(object.getClass()))
                throw new DifferentClassException("In list for additing different fruits!!!");
        if (list.size() == 0) {
            list.addAll(objects);
            return new LinkedList(list);
        }
        for (Object object : list)
            if (!aClass.equals(object.getClass()))
                throw new DifferentClassException("You can added only one type of fruit in one box!!!");
        list.addAll(objects);
        return new LinkedList(list);
    }

    public float getWeight() {
        Class<?> aClass = list.getLast().getClass();
        if (aClass.equals(Apple.class)) {
            return APPLE * list.size();
        } else if (aClass.equals(Orange.class)) {
            return ORANGE * list.size();
        }
        return 0;
    }

    public boolean compare(Box box) {
        float result = 0;
        Class<?> aClass = list.getLast().getClass();
        if (aClass.equals(Apple.class)) {
            result = APPLE * list.size();
        } else if (aClass.equals(Orange.class)) {
            result = ORANGE * list.size();
        }
        if (result == box.getWeight())
            return true;
        return false;
    }

    public void merge(Box box) {
        Class<?> aClass = list.getLast().getClass();
        for (Object object : box.getList())
            if (!aClass.equals(object.getClass()))
                throw new DifferentClassException("Boxes has different Fruits!!!");
        list.addAll(box.getList());
    }
}
