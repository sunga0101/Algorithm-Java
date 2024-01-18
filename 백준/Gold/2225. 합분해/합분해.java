

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[][] dp = new int[N+1][K+1];

        for (int i=1;i<=N;i++){
            dp[i][1] = 1;
        }
        for (int i=1;i<=K;i++){
            dp[1][i] = i;
        }


        for (int i=2;i<=N;i++){
            for (int j=2;j<=K;j++) {
                dp[i][j] = (dp[i][j-1] % 1000000000)+(dp[i-1][j]% 1000000000);
            }
        }

        bw.write((dp[N][K]% 1000000000)+"");
        bw.flush();
        br.close();
    }
}
