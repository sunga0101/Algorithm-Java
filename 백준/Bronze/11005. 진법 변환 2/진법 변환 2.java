

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int num = Integer.parseInt(s[0]);
        int div = Integer.parseInt(s[1]);
        int extra = 0;
        String extraStr = "";

        while(num>0){
            extra = num % div;
            if (extra > 9){
                char c = (char)(extra+55);
                extraStr = String.valueOf(c) + extraStr;
            }
            else extraStr = String.valueOf(extra) + extraStr;
            num = num / div;
        }

        bw.write(extraStr+"");
        bw.flush();
        br.close();

    }
}