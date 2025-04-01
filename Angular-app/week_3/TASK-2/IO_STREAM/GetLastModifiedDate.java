import java.io.*;
import java.util.*;
public class GetLastModifiedDate {
    public static void main(String[] args) {
        File file = new File("test.txt");
        System.out.println("Last Modified: " + new Date(file.lastModified()));
    }
}