import java.util.Arrays;

public class EqualsVsDeepEquals {
    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {1, 2, 3};
        
        System.out.println("Using equals(): " + Arrays.equals(arr1, arr2)); // true
        System.out.println("Using deepEquals(): " + Arrays.deepEquals(arr1, arr2)); // true

        Object[] objArr1 = {arr1};
        Object[] objArr2 = {arr2};
        System.out.println("Using equals() on Object array: " + Arrays.equals(objArr1, objArr2)); // false
        System.out.println("Using deepEquals() on Object array: " + Arrays.deepEquals(objArr1, objArr2)); // true
    }
}