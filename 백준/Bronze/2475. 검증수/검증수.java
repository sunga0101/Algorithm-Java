
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tmp, sum = 0;
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < 5; i++) {
            tmp = Integer.parseInt(s[i]);
            tmp *= tmp;
            sum += tmp;
        }
        bw.write(sum%10+"");
        bw.flush();
        br.close();
    }
}