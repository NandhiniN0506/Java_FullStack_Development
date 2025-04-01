import java.util.Arrays;

public class ArrayCopyRangeExample {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        int[] copiedRange = Arrays.copyOfRange(arr, 2, 5);

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Copied Range (Index 2 to 4): " + Arrays.toString(copiedRange));
    }
}
