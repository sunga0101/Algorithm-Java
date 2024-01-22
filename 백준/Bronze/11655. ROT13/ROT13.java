

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        for (int i=0;i<s.length();i++){
            if ((s.charAt(i)>='a'&& s.charAt(i)<='z')||(s.charAt(i)>='A'&& s.charAt(i)<='Z')){
                char ch = s.charAt(i);
                if ((ch >='n' && ch<='z')||(ch >='N' && ch<='Z'))
                    bw.write(ch-13);
                else bw.write(ch+13);
            }
            else bw.write(s.charAt(i));
        }
        bw.flush();
        br.close();

    }
}
