

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] R = new int[n+1];
        int[] G = new int[n+1];
        int[] B = new int[n+1];
        int[][] dp = new int[n+1][3]; // i번째 집까지 칠하는 최소 비용



        for (int i=1;i<=n;i++){
            String[] s = br.readLine().split(" ");
            int r=Integer.parseInt(s[0]);
            int g=Integer.parseInt(s[1]);
            int b=Integer.parseInt(s[2]);

            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+r;
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+g;
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0])+b;
        }

        bw.write(Math.min(dp[n][0],Math.min(dp[n][1],dp[n][2]))+"");
        bw.flush();
        br.close();
    }


}

