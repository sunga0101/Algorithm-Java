

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            // 공백
            for (int k=0;k<N-(i+1);k++){
                bw.write(" ");
            }
            for (int j = 1; j < 2*(i+1); j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
    }
}
