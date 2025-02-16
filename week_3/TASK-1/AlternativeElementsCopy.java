import java.util.Arrays;

public class AlternativeElementsCopy {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] result = new int[(arr.length + 1) / 2];
        
        for (int i = 0, j = 0; i < arr.length; i += 2, j++) {
            result[j] = arr[i];
        }
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Alternative Elements Copied: " + Arrays.toString(result));
    }
}