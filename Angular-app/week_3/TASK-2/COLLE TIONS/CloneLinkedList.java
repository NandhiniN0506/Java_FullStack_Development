import java.util.*;

public class CloneLinkedList {
    public static void main(String[] args) {
        LinkedList<String> originalList = new LinkedList<>(Arrays.asList("A", "B", "C"));
        LinkedList<String> clonedList = (LinkedList<String>) originalList.clone();
        System.out.println("Cloned List: " + clonedList);
    }
}