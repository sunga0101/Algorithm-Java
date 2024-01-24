

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String num2 = br.readLine();
        // 2진수 -> 10진수
        BigInteger num10 = new BigInteger(num2,2);
        // 10진수 -> 8진수
        String num8 = num10.toString(8);


        bw.write(num8+"");
        bw.flush();
        br.close();

    }
}