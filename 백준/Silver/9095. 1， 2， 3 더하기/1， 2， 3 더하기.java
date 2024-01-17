

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine()); // 테스트케이스
        for (int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
            int[] f = new int[n+1];

            f[1]=1;
            if (n>2)
                f[3]=4; // 순서 카운트
            if (n>1)
                f[2]=2;
            for(int i=4;i<n+1;i++){
                f[i] = f[i-1]+f[i-2]+f[i-3];
            }
            bw.write(f[n]+"\n");
        }

        bw.flush();
        br.close();
    }
}
