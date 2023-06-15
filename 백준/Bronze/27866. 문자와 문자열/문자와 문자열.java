
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split("");
        int idx = Integer.parseInt(br.readLine());
        bw.write(s[idx-1]+"\n");
        bw.flush();
        br.close();
    }
}
