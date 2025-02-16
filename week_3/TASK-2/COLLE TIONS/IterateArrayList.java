public class IterateArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        for (String item : list) {
            System.out.println(item);
        }
    }
}
