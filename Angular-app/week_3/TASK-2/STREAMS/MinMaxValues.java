import java.util.*;
import java.util.stream.*;

public class MinMaxValues {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 5, 40, 30);
        int max = numbers.stream().max(Integer::compare).orElseThrow();
        int min = numbers.stream().min(Integer::compare).orElseThrow();
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}