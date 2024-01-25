

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i=1;i<=N;i++) // N!
        {
            if (i%5==0){ // 5의 배수면?
                cnt++; // 5로 나누고 +1
                int cr = i/5;
                while(cr%5 ==0){
                    cnt++;
                    cr /=5;
                }
            }
        }
        bw.write(cnt+"\n");
        bw.flush();
        br.close();

    }
}