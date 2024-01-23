

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        long a = Long.parseLong(s[0]);
        long b = Long.parseLong(s[1]);
        long max = Math.max(a,b);
        long min = Math.min(a,b);

        while(min !=0){
            long temp = max;
            max = min;
            min = temp%min;
        }

        for (int i=0;i<max;i++){
            bw.write("1");
        }
        bw.flush();
        br.close();

    }
}