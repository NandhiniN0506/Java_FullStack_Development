import java.util.*;

public class ShuffleArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("One", "Two", "Three", "Four"));
        Collections.shuffle(list);
        System.out.println("Shuffled List: " + list);
    }
}