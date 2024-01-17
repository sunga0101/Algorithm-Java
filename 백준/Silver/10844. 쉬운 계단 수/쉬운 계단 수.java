

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()); // 자릿수
        long[][] dp = new long[N+1][10] ; // 1~N까지의 자릿수, 가능한 수:0~9

        for (int i=1;i<10;i++){
            // dp[1][i]는 숫자별로 각각 1개의 경우의 수만 존재
            dp[1][i] = 1;
        }

        for (int i=2; i<N+1;i++){
            for (int j=0;j<10;j++){
                if (j==0)
                    dp[i][j] = (dp[i-1][j+1])%1000000000;
                else if (j==9)
                    dp[i][j] = (dp[i-1][j-1])%1000000000;
                else
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000; // 기본 규칙
            }
        }

        // n자릿수의 계단수의 경우의 합
        long res = 0;
        for (int i=0; i<10; i++){
            res += dp[N][i];
        }

        bw.write(res%1000000000+"");
        bw.flush();
        br.close();
    }
}
