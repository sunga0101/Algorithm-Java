

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n;

        // 소수 찾는 배열 전처리
        boolean[] isPrime = new boolean[1000001];
        isPrime[0]=isPrime[1]=isPrime[2]=true;

        for (int i=3;i<=1000000;i++){
            if (!isPrime[i]){
                for (int j=i+i;j<=1000000;j+=i){
                    isPrime[j]=true;
                }
            }
        }

        while ((n = Integer.parseInt(br.readLine())) != 0){
            for (int i=3;i<=n;i+=2){
                if (!isPrime[i]){ // i는 소수
                    if (!isPrime[n-i]) {// n-i도 소수
                        bw.write(n+" = "+i+" + "+(n-i)+"\n");
                        break;
                    }
                    else continue;
                }
            }
        }
        bw.flush();
        br.close();

    }
}