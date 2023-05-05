
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alphabet = new int[26];
        char ascii;

        String word = sc.next();

        for (int i = 0; i < word.length(); i++) {
            ascii = word.charAt(i);
            alphabet[ascii-'a'] += 1;
        }
        
        Arrays.stream(alphabet).forEach(n -> System.out.print(n + " "));
    }
}