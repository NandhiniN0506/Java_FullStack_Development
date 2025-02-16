import java.util.*;

public class IterateLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C"));
        for (String item : list) {
            System.out.println(item);
        }
    }
}