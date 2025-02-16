import java.util.*;

public class CompareLinkedLists {
    public static void main(String[] args) {
        LinkedList<String> list1 = new LinkedList<>(Arrays.asList("A", "B", "C"));
        LinkedList<String> list2 = new LinkedList<>(Arrays.asList("A", "B", "C"));
        System.out.println("Lists are equal: " + list1.equals(list2));
    }
}