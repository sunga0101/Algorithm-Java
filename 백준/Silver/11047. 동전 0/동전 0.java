

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
       
        String[] s = br.readLine().split(" ");
        int res = 0;
        int n = Integer.parseInt(s[0]); // n가지 동전
        int k = Integer.parseInt(s[1]); // 만들어야 할 금액
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        for (int i=n-1;i>=0;i--){
            if (k>=arr[i]){
                res+=k/arr[i];
                k %= arr[i];
            }
        }


        bw.write(res+"");
        bw.flush();
        br.close();
    }

}
