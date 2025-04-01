package Task;
import java.util.*;

public class Anagram {
    public static String anagramindex(String s, String p) {
        List<Integer> total = new ArrayList<>(); // Use dynamic list instead of fixed-size array
        int slen = s.length();
        int plen = p.length();
        if (slen > plen) return total.toString();
        
        int[] sfreq = new int[26];
        int[] pfreq = new int[26];
        
        for (int i = 0;i < slen;i++) {
        	sfreq[s.charAt(i)-'a']++;
        	pfreq[s.charAt(i)-'a']++;
        }
        if (Arrays.equals(sfreq, pfreq)) total.add(0);
        
        for (int i = slen;i < plen;i++) {
        	pfreq[p.charAt(i)-'a']++;
        	pfreq[p.charAt(i-slen)-'a']--;
        	
        	if (Arrays.equals(sfreq, pfreq)) total.add(i-slen + 1);
        }
        return total.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        // Get user input for the anagram string
        System.out.println("Enter the Anagram String: ");
        String S = s.nextLine();
        
        // Get user input for the main string where we find anagrams
        System.out.println("Enter the String to return index of Anagram: ");
        String P = s.nextLine();
        
        // Call the function and print the resulting indices
        System.out.println(anagramindex(S, P));

        s.close(); // Close the scanner to prevent memory leaks
    }
}
