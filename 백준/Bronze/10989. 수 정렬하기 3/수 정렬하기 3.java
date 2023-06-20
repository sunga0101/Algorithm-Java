import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arrInt = new int[N];
        for (int i = 0; i < N; i++) {
            arrInt[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arrInt);

        for (int i = 0; i < N; i++) {
            bw.write(arrInt[i]+"\n");
        }
        bw.flush();
        br.close();
    }
}
