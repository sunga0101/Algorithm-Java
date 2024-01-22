

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int n = s.length();

        String[] sArr = new String[n];
        for (int i=0;i<n;i++){
            sArr[i] = s.substring(i,n);
        }

        Arrays.sort(sArr);
        for (int i=0;i<n;i++){
            bw.write(sArr[i]+"\n");
        }
        bw.flush();
        br.close();

    }
}
