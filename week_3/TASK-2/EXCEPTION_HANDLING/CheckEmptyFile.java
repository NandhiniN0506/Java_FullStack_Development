import java.io.*;

public class CheckEmptyFile {
    public static void checkFileEmpty(String fileName) throws Exception {
        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {
            throw new Exception("File is empty or does not exist: " + fileName);
        }
        System.out.println("File is not empty: " + fileName);
    }
    
    public static void main(String[] args) {
        try {
            checkFileEmpty("empty.txt");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}