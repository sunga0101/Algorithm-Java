
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long iNumA = Long.parseLong(s[0]);
        long iNumB = Long.parseLong(s[1]);
        long iNumC = Long.parseLong(s[2]);
        System.out.println(pow(iNumA,iNumB,iNumC));
    }

    public static long pow(long a, long b, long c){
        if (b == 1) return a % c;
        long val = pow(a, b/2, c);
        val = val * val % c;
        if (b % 2 == 0) {
            return val;
        }
        return val * a % c;

    }
}

