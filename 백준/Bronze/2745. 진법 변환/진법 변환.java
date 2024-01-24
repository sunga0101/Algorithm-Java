

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        String str = s[0];
        int a = Integer.parseInt(s[1]);
        int sum = 0;
        int i = 0;

        while (str.length() > 0){
            if (str.charAt(str.length()-1) >= 'A' && str.charAt(str.length()-1)<='Z')
                sum += (str.charAt(str.length()-1)-55)*(Math.pow(a,i));
            else sum += (str.charAt(str.length()-1)-'0')*(Math.pow(a,i));
            str = str.substring(0,str.length()-1);
            i++;
        }


        bw.write(sum+"");
        bw.flush();
        br.close();

    }
}