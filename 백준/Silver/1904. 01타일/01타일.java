

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[1] = 1;
        if (n>1) dp[2] = 2;
        if (n>2) dp[3] = 3;

        for (int i=4;i<=n;i++){
            dp[i] = dp[i-1]%15746+dp[i-2]%15746;
        }

        bw.write(dp[n]%15746+"");
        bw.flush();
        br.close();
    }

}
