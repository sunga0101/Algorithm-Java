

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] val = new int[n+1][n+1]; // 각 숫자 값
        int[][] dp = new int[n+1][n+1];
        for (int i=n;i>0;i--){
            String[] s = br.readLine().split(" ");
            for (int j=0;j<s.length;j++){
                val[i][j+1]=Integer.parseInt(s[j]);
            }
        }
        
        for (int i=1;i<=n;i++){ // 1층 넣어주기
            dp[1][i] = val[1][i];
        }
        for (int i=2;i<=n;i++){ // 층수 1~5
            for (int j=1;j<=n-i+1;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j+1])+val[i][j];
            }

        }
        bw.write(dp[n][1]+"");
        bw.flush();
        br.close();
    }


}

