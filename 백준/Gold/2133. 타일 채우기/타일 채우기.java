

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        if (N%2==1) { // 홀수
            bw.write("0");
        }

        else {
            dp[0] = 1;
            dp[2] = 3;
            for (int i=4;i<=N;i+=2) {// 짝수
                dp[i] = dp[i-2]*dp[2];
                for (int j=i-4;j>=0;j-=2){
                    dp[i] += dp[j]*2; // F[N] = ( F[N - 2] * F[2] ) + ( F[N - 4] * 2 ) + ( F[N - 6] * 2) + ( F[N - 8] * 2 ) + ... + ( F[0] * 2 )
                }
            }
            bw.write((dp[N]) + "");
        }

        bw.flush();
        br.close();

    }
}
