

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[N + 1];

            dp[1]=1;
            if (N>=2) dp[2]=1;
            if (N>=3) dp[3]=1;
            if (N>=4) dp[4]=2;
            if (N>=5) dp[5]=2;
            if (N>=6) dp[6]=3;
            if (N>=7) dp[7]=4;
            if (N>=8) dp[8]=5;

            for (int j=9;j<=N;j++){
                dp[j] = dp[j-1]+dp[j-5];
            }
            bw.write(dp[N]+"\n");
        }
        bw.flush();
        br.close();
    }
}
