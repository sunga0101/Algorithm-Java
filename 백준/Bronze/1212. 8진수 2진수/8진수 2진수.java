

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String num8 = br.readLine();
        // 8진수 -> 10진수
        BigInteger num10 = new BigInteger(num8,8);
        // 10진수 -> 2진수
        String num2 = num10.toString(2);


        bw.write(num2+"");
        bw.flush();
        br.close();

    }
}