

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i=0;i<n-2;i++){
            for (int j=i+1;j<n-1;j++){
                for (int k=j+1;k<n;k++){
                    int sum = arr[i]+arr[j]+arr[k];
                    if (sum>max && sum <= m)
                        max = sum;
                }
            }
        }

        bw.write(max+"");
        bw.flush();
        br.close();

    }
}