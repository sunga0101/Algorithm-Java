

import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        dp[1]=1;
        if (N>1) dp[2]=1;

        for(int i=3;i<N+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }


        bw.write(dp[N]+"");
        bw.flush();
        br.close();
    }
}
