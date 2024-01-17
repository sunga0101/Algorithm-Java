
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()); // 자릿수
        long[][] dp = new long[N+2][10] ; // 1~N까지의 자릿수, 가능한 수:0~9

        for (int i=0;i<10;i++){
            // dp[1][i]는 숫자별로 각각 1개의 경우의 수만 존재
            dp[1][i] = 1;
        }
        for (int i=1;i<=N+1;i++){
            dp[i][0] = 1;
        }
        for (int i=2;i<N+1;i++){
            for (int j=1;j<=9;j++) {
                dp[i][j] = (dp[i][j-1]+dp[i-1][j])%10007;
            }
        }

        long res = 0;
        for (int i=0;i<=9;i++){
            res+= dp[N][i];
        }


        bw.write(res%10007+"");
        bw.flush();
        br.close();
    }
}
