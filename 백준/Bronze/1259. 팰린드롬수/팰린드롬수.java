

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int input;
        String res;
        while ((input = Integer.parseInt(br.readLine())) != 0){
            res = "yes";
            String[] str = Integer.toString(input).split("");
            int len = str.length;
            for (int i=0;i<len/2;i++){
                if (str[i].equals(str[len-1-i])){
                    res = "yes";
                }
                else {
                    res = "no";
                    break;
                }
            }
            bw.write(res+"\n");
        }
        bw.flush();
        br.close();
    }
}