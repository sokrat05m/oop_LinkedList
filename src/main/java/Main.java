import Lists.GBLinkedList;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        GBLinkedList<Integer> linkedList = new GBLinkedList<>();
        linkedList.addFirst(5);
        linkedList.addFirst(10);
        linkedList.addFirst(20);
        //linkedList.remove(1);
        for (Integer i : linkedList){
            System.out.println(i);
        }
    }
}
