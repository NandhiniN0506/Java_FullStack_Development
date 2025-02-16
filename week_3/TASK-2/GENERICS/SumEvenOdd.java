import java.util.List;

public class SumEvenOdd {
    public static <T extends Number> void sumEvenOdd(List<T> numbers) {
        int evenSum = 0, oddSum = 0;
        for (T num : numbers) {
            if (num.intValue() % 2 == 0) evenSum += num.intValue();
            else oddSum += num.intValue();
        }
        System.out.println("Even Sum: " + evenSum + ", Odd Sum: " + oddSum);
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        sumEvenOdd(nums);
    }
}
