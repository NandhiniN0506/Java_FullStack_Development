import java.util.*;
import java.util.stream.*;

public class ConvertCase {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "java");
        List<String> upperCaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Uppercase: " + upperCaseWords);
    }
}