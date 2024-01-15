

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] sp = br.readLine().split(" ");
        int[] numArr = new int[sp.length];
        for (int i=0;i<N;i++){
            numArr[i] = Integer.parseInt(sp[i]);
        }
        Arrays.sort(numArr);

        bw.write(numArr[0]+" "+numArr[N-1]+"\n");
        bw.flush();
        br.close();
    }
}
