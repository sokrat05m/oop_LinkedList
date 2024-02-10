package Lists;

import org.w3c.dom.Node;

public interface GBList<T> {
        void addLast(T elem);
        void addFirst(T elem);
        void remove(int index);
        T get (int index);
        int size();

}
