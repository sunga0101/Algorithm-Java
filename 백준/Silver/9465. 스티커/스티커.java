

import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            long[][] dp = new long[2][N+1];
            int[][] cost = new int[2][N+1];
            String[] s = br.readLine().split(" ");
            for(int j=1;j<=N;j++){
                cost[0][j]=Integer.parseInt(s[j-1]);
            }
            s = br.readLine().split(" ");
            for(int j=1;j<=N;j++){
                cost[1][j]=Integer.parseInt(s[j-1]);
            }
            // 초기값
            dp[0][1] = cost[0][1];
            dp[1][1] = cost[1][1];

            for (int k=2;k<N+1;k++){ // 자동으로 [][2]의 값들도 본인 자신의 값으로 채워짐
                dp[0][k] = Math.max(dp[1][k-2],dp[1][k-1])+cost[0][k];
                dp[1][k] = Math.max(dp[0][k-2],dp[0][k-1])+cost[1][k];
            }
            bw.write(Math.max(dp[0][N],dp[1][N])+"\n");

        }
//        bw.write(dp[N]+"");
        bw.flush();
        br.close();
    }
}
