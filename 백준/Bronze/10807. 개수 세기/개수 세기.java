import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;
        int num = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int target = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            if (Integer.parseInt(s[i])==target)
                count++;
        }
        bw.write(count+"");
        bw.flush();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}