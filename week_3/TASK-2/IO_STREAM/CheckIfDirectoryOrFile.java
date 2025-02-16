import java.io.*;
public class CheckIfDirectoryOrFile {
    public static void main(String[] args) {
        File file = new File("test.txt");
        if (file.isDirectory()) {
            System.out.println("It is a directory");
        } else if (file.isFile()) {
            System.out.println("It is a file");
        }
    }
}