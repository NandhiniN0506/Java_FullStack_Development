public class RemoveElement {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        list.remove(2);
        System.out.println("Updated List: " + list);
    }
}