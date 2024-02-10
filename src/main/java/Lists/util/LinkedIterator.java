package Lists.util;

import Lists.GBLinkedList;

import java.util.Iterator;

public class LinkedIterator<T> implements Iterator<T> {

    private GBLinkedList.Node<T> nextNode;
    private int nextIndex;
    private  GBLinkedList<T> list;

    public LinkedIterator(GBLinkedList<T> list) {
        this.list = list;
        nextNode = list.getFirst();
        nextIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return nextIndex < list.getSize();
    }

    @Override
    public T next() {
        GBLinkedList.Node<T> currentNode = nextNode;
        nextNode = nextNode.getNext();
        nextIndex++;
        return currentNode.getValue();
    }
}
