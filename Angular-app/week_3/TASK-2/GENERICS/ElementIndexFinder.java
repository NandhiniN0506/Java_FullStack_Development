import java.util.List;

public class ElementIndexFinder {
    public static <T> int findElementIndex(List<T> list, T target) {
        return list.indexOf(target);
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry");
        System.out.println("Index of 'banana': " + findElementIndex(words, "banana"));
    }
}