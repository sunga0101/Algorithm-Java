

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] dp= new long[N+1];
        dp[1]=1; // 1이 되는 방법 : 한가지 (1의 제곱)

        for(int i=2;i<N+1;i++){
            dp[i]=i;
            for (int j=1;j*j<=i;j++){
                if (j*j==i) dp[i] = 1;
                else dp[i] = Math.min(dp[i-j*j]+1,dp[i]); // f(N-1의제곱)+1 or f(N-2의제곱)+1 or f(N-3의제곱)+1...
            }
        }
        bw.write(dp[N]+"");
        bw.flush();
        br.close();
    }
}
