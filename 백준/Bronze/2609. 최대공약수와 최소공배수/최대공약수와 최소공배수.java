

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int max = Math.max(a,b); // 큰 수
        int min = Math.min(a,b); // 작은 수
        a = max;
        b = min;

        // 최대공약수 (유클리드 호제법)
        while(a%b!=0){
            int temp = a;
            a = b;
            b = temp%b;
        }
        bw.write(b+"\n");

        // 최소공배수
        int i=max;
        while(max%min !=0){
            max+=i;
        }
        bw.write(max+"");
        bw.flush();
        br.close();

    }
}