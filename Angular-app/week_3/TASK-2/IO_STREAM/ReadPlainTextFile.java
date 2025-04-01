import java.io.*;
public class ReadPlainTextFile {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        FileReader fr = new FileReader(file);
        char[] data = new char[(int) file.length()];
        fr.read(data);
        fr.close();
        System.out.println("File content: " + new String(data));
    }
}