import java.util.Arrays;

public class MultiThreadedSorting {
    public static void main(String[] args) {
        int[] arr = {5, 8, 3, 1, 9, 7, 2};
        Arrays.parallelSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}