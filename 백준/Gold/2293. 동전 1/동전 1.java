

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        int[] dp = new int[k+1];
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=arr[i];j<=k;j++){
                dp[j]+=dp[j-arr[i]];
            }
        }
        bw.write(dp[k]+"");
        bw.flush();
        br.close();
    }

}
