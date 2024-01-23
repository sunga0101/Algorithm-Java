

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int max = Math.max(a,b); // 큰 수
            int min = Math.min(a,b); // 작은 수

            int temp=max;
            while(max%min!=0){
                max+=temp;
            }
            bw.write(max+"\n");
        }
        bw.flush();
        br.close();

    }
}