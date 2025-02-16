public class InsertElement {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("One", "Two", "Three"));
        list.add(0, "Zero");
        System.out.println("Updated List: " + list);
    }
}