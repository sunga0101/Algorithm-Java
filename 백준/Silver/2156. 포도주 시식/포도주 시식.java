

import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N+1];
        for (int i=1;i<N+1;i++){
            cost[i] = Integer.parseInt(br.readLine());
        }

        long[] dp = new long[N+1];
        dp[1] = cost[1];
        if (N>1) dp[2] = cost[1]+cost[2];
        if (N>2) dp[3] = Math.max(dp[2],Math.max(cost[1]+cost[3],cost[2]+cost[3]));

        for (int i=4;i<=N;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+cost[i]); // OOX or OXO
            dp[i] = Math.max(dp[i], dp[i-3]+cost[i]+cost[i-1]); // XOO
        }

        bw.write(dp[N]+"");
        bw.flush();
        br.close();
    }
}
