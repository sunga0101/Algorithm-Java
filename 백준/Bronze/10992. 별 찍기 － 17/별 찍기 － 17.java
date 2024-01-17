

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N-1; i++) {
            // " "
            for (int k=0;k<N-(i+1);k++){
                bw.write(" ");
            }
            // *
            bw.write("*");
            // " "
            for (int k=0;k<2*i-1;k++){
                bw.write(" ");
            }
            if (i==0)bw.write("\n");
            else bw.write("*\n");
        }
        for (int i=0;i<2*N-1;i++){
            bw.write("*");
        }
        bw.flush();
        br.close();
    }
}
