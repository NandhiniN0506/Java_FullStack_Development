import java.util.*;

public class InsertLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C"));
        list.add(1, "X");
        System.out.println("Updated List: " + list);
    }
}
