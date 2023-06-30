package leetcode;

import java.util.LinkedList;

public class MyCircularQueue {
    private LinkedList<Integer> linkedList;
    private int count;

    public MyCircularQueue(int k) {
        linkedList = new LinkedList<>();
        count = k;
    }

    public boolean enQueue(int value) {
        return !isFull() && linkedList.add(value);
    }

    public boolean deQueue() {
        if (linkedList.isEmpty()) return false;
        else {
            linkedList.remove(0);
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return linkedList.getFirst();
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return linkedList.getLast();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public boolean isFull() {
        return linkedList.size() == count;
    }
}
