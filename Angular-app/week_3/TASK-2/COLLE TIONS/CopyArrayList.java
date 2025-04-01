import java.util.*;

public class CopyArrayList {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> list2 = new ArrayList<>(list1);
        System.out.println("Copied List: " + list2);
    }
}
