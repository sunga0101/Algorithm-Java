

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 계단 수
        int[] arr = new int[n+1];
        for (int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] w = new int[n+1];
        w[0]=0;
        w[1]=arr[1];
        if (n>=2) w[2] = w[1]+arr[2];
        if (n>=3) w[3] = arr[3]+Math.max(arr[1],arr[2]);

        for (int i=4;i<=n;i++){
            w[i] = arr[i]+Math.max(w[i-2],w[i-3]+arr[i-1]);
        }

        bw.write(w[n]+"");
        bw.flush();
        br.close();
    }


}

