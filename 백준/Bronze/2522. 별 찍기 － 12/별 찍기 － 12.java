

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            // " "
            for (int k=0;k<N-(i+1);k++){
                bw.write(" ");
            }
            // *
            for (int j=0;j<i+1;j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        for (int i = 0; i < N-1; i++) {
            // " "
            for (int k=0;k<i+1;k++){
                bw.write(" ");
            }
            // *
            for (int j=0;j<N-(i+1);j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
    }
}
