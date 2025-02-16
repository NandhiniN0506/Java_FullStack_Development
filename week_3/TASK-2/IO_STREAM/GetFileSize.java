import java.io.*;
public class GetFileSize {
    public static void main(String[] args) {
        File file = new File("test.txt");
        System.out.println("Size in Bytes: " + file.length());
        System.out.println("Size in KB: " + file.length() / 1024.0);
        System.out.println("Size in MB: " + file.length() / (1024.0 * 1024));
    }
}