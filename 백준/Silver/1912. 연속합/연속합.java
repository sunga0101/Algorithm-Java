

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N+1];
        String[] s = br.readLine().split(" ");
        for (int i=1;i<N+1;i++){
            cost[i] = Integer.parseInt(s[i-1]);
        }
        int[] dp= new int[N+1];
        dp[1]=cost[1];

        for(int i=2;i<N+1;i++){
            dp[i] = Math.max(dp[i-1]+cost[i], cost[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            if (max < dp[i]) max = dp[i];
        }
        bw.write(max+"");
        bw.flush();
        br.close();
    }
}
