import java.util.*;
import java.util.stream.*;

public class SortStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "cherry", "date");
        List<String> ascending = words.stream().sorted().collect(Collectors.toList());
        List<String> descending = words.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Ascending: " + ascending);
        System.out.println("Descending: " + descending);
    }
}