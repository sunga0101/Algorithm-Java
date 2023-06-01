
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        BigInteger a = new BigInteger(s[0]);
        BigInteger b = new BigInteger(s[1]);
        bw.write(a.divide(b)+"\n");
        bw.write(a.mod(b)+"\n");
        bw.flush();
        br.close();
    }
}