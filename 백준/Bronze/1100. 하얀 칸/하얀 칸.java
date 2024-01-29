

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[][] board = new int[8][8];
        boolean odd = false;
        int cnt=0;
        for (int i=0;i<8;i++){// 8행 반복
            String[] s = br.readLine().split("");
            for (int j=0;j<8;j+=2){
                if (!odd) {// 흰 칸이 짝수 0,2,4,6
                    if (s[j].equals("F")) cnt++;
                }
                else { // 흰 칸이 홀수 1,3,5,7
                    if (s[j+1].equals("F")) cnt++;
                }
            }
            odd = !odd;
        }


        bw.write(cnt+"");
        bw.flush();
        br.close();

    }
}