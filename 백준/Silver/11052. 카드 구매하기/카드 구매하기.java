

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        long[] dp= new long[N+1];
        long[] cost= new long[N+1];
        for (int i=1;i<=N;i++){
            cost[i] = Integer.parseInt(s[i-1]);
        }
        dp[1]=cost[1]; 

        for(int i=2;i<N+1;i++){
            dp[i]=cost[i];
            for (int j=1;j<i;j++){
                dp[i] = Math.max(dp[i-j]+cost[j],dp[i]);
            }
        }
        bw.write(dp[N]+"");
        bw.flush();
        br.close();
    }
}
