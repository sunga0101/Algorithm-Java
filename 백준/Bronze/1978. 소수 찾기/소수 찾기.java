

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        boolean[] check = new boolean[1001]; // 1~1000이하
        check[0] = check[1] = true;
        int cnt = 0;

        for (int i=2;i<=1000;i++){ // 1000이하의 소수체크
            if (!check[i]){
                for (int j=i+i;j<=1000;j+=i){
                    check[j] = true;
                }
            }
        }

        for (int i=0;i<T;i++){
            if (!check[Integer.parseInt(split[i])])
                cnt++;
        }

        bw.write(cnt+"");
        bw.flush();
        br.close();

    }
}
/*
4
1 3 5 7
*/