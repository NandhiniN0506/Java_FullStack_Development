import java.util.*;

public class AppendLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("Before Append: " + list);
        list.addLast("D");
        System.out.println("After Append: " + list);
    }
}