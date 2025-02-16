import java.io.*;
public class FilterFilesByExtension {
    public static void main(String[] args) {
        File dir = new File("./");
        FilenameFilter filter = (f, name) -> name.endsWith(".txt");
        String[] files = dir.list(filter);
        for (String file : files) {
            System.out.println(file);
        }
    }
}