

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[1000001];
        arr[0] = arr[1] = 0;

        for (int i=2;i<=1000000;i++){
            if (i%6==0){ // 6로 나눠지면
                arr[i] = Math.min(arr[i-1],Math.min(arr[i/2],arr[i/3]))+1;
            }
            else if (i%2==0){ // 2로 나눠지면
                arr[i] = Math.min(arr[i-1],arr[i/2])+1;
            }
            else if (i%3==0){ // 3로 나눠지면
                arr[i] = Math.min(arr[i-1],arr[i/3])+1;
            }
            else { // 안나눠질때
                arr[i] = arr[i-1]+1;
            }
        }
        bw.write(arr[n]+"");
        bw.flush();
        br.close();
    }


}

