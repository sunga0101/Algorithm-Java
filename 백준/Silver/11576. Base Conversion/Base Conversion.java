

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int from = Integer.parseInt(s[0]);
        int to = Integer.parseInt(s[1]);
        int T = Integer.parseInt(br.readLine());
        int sum10 = 0;

        s = br.readLine().split(" ");
        for (int i=0;i<T;i++){
            sum10+= Math.pow(from,i)*Integer.parseInt(s[T-i-1]);
        }
        String res = Integer.toString(sum10,to);
        for (int i=0;i<res.length();i++){
            if (res.charAt(i) >= 'a' && (res.charAt(i))<= 'z')
                bw.write((res.charAt(i)-87)+" ");
            else bw.write((res.charAt(i))+" ");
        }
        bw.flush();
        br.close();

    }
}