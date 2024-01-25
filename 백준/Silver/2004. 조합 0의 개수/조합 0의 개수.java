

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        long n = Long.parseLong(s[0]);
        long m = Long.parseLong(s[1]);

        long cnt5 = count5(n)-count5(m)-count5(n-m);
        long cnt2 = count2(n)-count2(m)-count2(n-m);

        bw.write(Math.min(cnt5,cnt2) + "\n");
        bw.flush();
        br.close();

    }

    public static long count5(long num) {
        long temp = 0;
        if (num < 5) return 0;
        for (long i=5;i<=num;i*=5){
            temp += num/i;
        }
        return temp;
    }
    public static long count2(long num) {
        long temp = 0;
        if (num < 2) return 0;
        for (long i=2;i<=num;i*=2){
            temp += num/i;
        }
        return temp;
    }
}