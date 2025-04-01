import java.io.*;

public class ReadFile {
    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
        System.out.println("File exists: " + fileName);
    }
    
    public static void main(String[] args) {
        try {
            readFile("nonexistent.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}