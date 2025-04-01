import java.util.*;
import java.util.stream.*;

public class CountStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "avocado");
        long count = words.stream().filter(w -> w.startsWith("a")).count();
        System.out.println("Count of words starting with 'a': " + count);
    }
}
