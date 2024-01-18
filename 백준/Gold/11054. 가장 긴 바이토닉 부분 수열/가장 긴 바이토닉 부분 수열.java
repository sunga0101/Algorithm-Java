

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N+1];
        String[] s = br.readLine().split(" ");
        for (int i=1;i<N+1;i++){
            cost[i] = Integer.parseInt(s[i-1]);
        }
        int[] dpInc= new int[N+1]; // 증가수열
        int[] dpDesc= new int[N+1]; // 감소수열
        dpInc[1] = 1;
        dpDesc[1] = 1;

        for(int i=2;i<N+1;i++){
            dpInc[i] = 1;
            for (int j=1;j<i;j++){
                // 증가수열
                if (cost[i]>cost[j] && dpInc[i]<=dpInc[j])
                    dpInc[i] = dpInc[j]+1;
            }
        }

        for(int i=N;i>0;i--){
            dpDesc[i] = 1;
            for (int j=N;j>i;j--){
                // 감소수열 (맨 뒤부터 증가수열과 동일)
                if (cost[i]>cost[j] && dpDesc[i]<=dpDesc[j])
                    dpDesc[i] = dpDesc[j]+1;
            }
        }

        int max = -1;
        for (int i=1;i<N+1;i++){
//            bw.write(dpInc[i]+" " +dpDesc[i]+"\n");
            if (max < dpInc[i]+dpDesc[i]) {
                max = dpInc[i]+dpDesc[i];
            }
        }


        bw.write(max-1+"");
        bw.flush();
        br.close();
    }
}
