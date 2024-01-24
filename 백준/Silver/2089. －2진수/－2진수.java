

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int num10 = Integer.parseInt(br.readLine());
        if (num10 == 0) bw.write(0+"");
        else {
            String extra = "";
            while (num10 != 0) {
                extra = Math.abs(num10 % -2) + extra;
                num10 = (int) (Math.ceil((double) num10 / -2));
            }
        bw.write(extra+"");
        }
        bw.flush();
        br.close();

    }
}