package threadsadvanced;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeList<T> {
    private final List<T> list = new LinkedList<T>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void add(T value) {
        Lock writeLock = lock.writeLock();
        writeLock.lock();

        try {
            list.add(value);
        } finally {
            writeLock.unlock();
        }
    }

    public T remove(int index) {
        Lock writeLock = lock.writeLock();
        writeLock.lock();

        try {
            return list.remove(index);
        } finally {
            writeLock.unlock();
        }
    }

    public T get(int index) {
        Lock readLock = lock.readLock();
        readLock.lock();

        try {
            return list.get(index);
        } finally {
            readLock.unlock();
        }
    }
}
