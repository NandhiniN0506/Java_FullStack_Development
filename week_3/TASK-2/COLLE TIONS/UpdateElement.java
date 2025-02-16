public class UpdateElement {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("One", "Two", "Three"));
        list.set(1, "Updated");
        System.out.println("Updated List: " + list);
    }
}