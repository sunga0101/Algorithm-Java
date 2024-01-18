

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
        int dp[] = new int[N+1];
        dp[1]=cost[1];

        for (int i=2;i<N+1;i++){ // 2~n
            dp[i] = cost[i];
            for (int j=1;j<i;j++){
                if (cost[i] > cost[j] && cost[i]+dp[j]>=dp[i])
                    dp[i] = dp[j]+cost[i];
            }
        }

        int max = -1;
        for (int i=1;i<=N;i++){
            if (dp[i] > max) max = dp[i];
        }
        bw.write(max+"");
        bw.flush();
        br.close();
    }
}
