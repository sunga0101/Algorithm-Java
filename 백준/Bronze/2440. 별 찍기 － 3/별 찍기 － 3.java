

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            // 공백
            for (int j = 0; j < N-(i); j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
    }
}
