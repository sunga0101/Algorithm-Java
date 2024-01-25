

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] split = br.readLine().split(" ");
        int min = Integer.parseInt(split[0]);
        int max = Integer.parseInt(split[1]);
        boolean[] isPrime = new boolean[1000001];
        isPrime[0]=isPrime[1]=true;

        for (int i=2;i<=max;i++){
            if (!isPrime[i]){
                for (int j=i+i;j<=max;j+=i){
                    isPrime[j] = true;
                }
            }
        }

        for (int i=min; i<=max;i++){
            if (!isPrime[i])
                bw.write(i+"\n");
        }
        bw.write("");
        bw.flush();
        br.close();

    }
}