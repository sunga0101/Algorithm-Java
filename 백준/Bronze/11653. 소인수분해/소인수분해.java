

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int cr = 2;
        if (num == 1) bw.write("");
        else {
            while(num>1){
                if (num%cr !=0) {// 나눠지지 않는다면
                    cr++;
                }
                else {
                    bw.write(cr+"\n");
                    num /= cr;
                }
            }
            bw.write("");
        }
        bw.flush();
        br.close();

    }
}