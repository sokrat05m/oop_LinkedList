package Lists;

import Lists.util.LinkedIterator;

import java.util.Iterator;

public class GBLinkedList<T> implements GBList<T>, Iterable<T>{
    private int size = 0;
    private Node<T> last;

    private Node<T> first;

    public Node<T> getLast() {
        return last;
    }


    public Node<T> getFirst() {
        return first;
    }

    public int getSize() {
        return size;
    }

    public GBLinkedList() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void addLast(T elem) {
        Node<T> newNode = new Node<>(last, elem, null);
        if (last != null)
            last.next = newNode;
        last = newNode;
        if (first == null)
            first = newNode;
        size++;
    }

    @Override
    public void addFirst(T elem) {
        Node<T> newNode = new Node<>(null, elem, first);
        if (first != null)
            first.prev = newNode;
        first = newNode;
        if (last == null)
            last = newNode;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            Node<T> nodeToRemove;
            if (index < size / 2) {
                Node<T> x = first;
                for (int i = 0; i < index; i++) {
                    x = x.next;
                }
                nodeToRemove = x;
            } else {
                Node<T> x = last;
                for (int i = size - 1; i > index; i--) {
                    x = x.prev;
                }
                nodeToRemove = x;
            }

            Node<T> next = nodeToRemove.next;
            Node<T> prev = nodeToRemove.prev;

            if (prev == null) {
                first = next;
            } else {
                prev.next = next;
            }

            if (next == null) {
                last = prev;
            } else {
                next.prev = prev;
            }
            size--;
        }
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            if (index < size / 2) {
                Node<T> x = first;
                for (int i = 0; i < index; i++) {
                    x = x.next;
                }
                return x.value;
            } else {
                Node<T> x = last;
                for (int i = size - 1; i > index; i--) {
                    x = x.prev;
                }
                return x.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++){
            sb.append(get(i)).append(", ");
        }
        if (sb.length() == 1)
            return "[]";
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator(this);
    }

    public static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(Node<T> prev, T value, Node<T> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return  value.toString();
        }
    }
}
