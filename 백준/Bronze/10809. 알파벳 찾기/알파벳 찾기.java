

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] arr = new int[26];
        Arrays.fill(arr,-1);
        String s = br.readLine();

        for (int i=0;i<s.length();i++){
            int idx = s.charAt(i)-'a';
            if (arr[idx] == -1) arr[idx] = i;

        }

        for (int i :arr) bw.write(i+" ");
        bw.flush();
        br.close();

    }
}
