import java.io.*;
public class CheckFileOrDirectoryExists {
    public static void main(String[] args) {
        File file = new File("test.txt");
        System.out.println("Exists: " + file.exists());
    }
}