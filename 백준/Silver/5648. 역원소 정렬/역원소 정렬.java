import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static void solve() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(sc.next());
        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(sc.next());
            long res = 0;
            // reverse
            while (num > 0) {
                res = (10 * res) + num % 10;
                num /= 10;
            }
            numbers[i] = res;
        }
        Arrays.sort(numbers);
        for (long element : numbers) bw.write(element+"\n");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
