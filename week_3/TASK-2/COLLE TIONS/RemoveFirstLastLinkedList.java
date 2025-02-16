import java.util.*;

public class RemoveFirstLastLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C"));
        list.removeFirst();
        list.removeLast();
        System.out.println("Updated List: " + list);
    }
}