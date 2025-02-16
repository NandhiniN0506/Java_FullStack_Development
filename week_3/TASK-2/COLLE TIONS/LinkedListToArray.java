import java.util.*;

public class LinkedListToArray {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C"));
        String[] array = list.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(array));
    }
}