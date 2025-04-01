public class HelloJavaThread extends Thread {
    public void run() {
        System.out.println("Hello, Java!");
    }
    
    public static void main(String[] args) {
        HelloJavaThread thread = new HelloJavaThread();
        thread.start();
    }
}