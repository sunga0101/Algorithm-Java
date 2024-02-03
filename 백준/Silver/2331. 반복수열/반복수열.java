

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedList<Integer> list;
    static int answer;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]); // D[1] 값
        int p = Integer.parseInt(s[1]);
        list = new LinkedList<>();
        list.add(a);
        func(a,p);
        bw.write(answer+"");
        bw.flush();
        br.close();
    }

    public static void func(int a, int p) throws IOException {
        int res = 0;
        String num = String.valueOf(a);
        for (int i=0;i<num.length();i++){
            res += Math.pow(num.charAt(i)-'0',p);
        }

        if (list.contains(res)) {
            answer = list.indexOf(res);
        }
        else {
            list.add(res);
            func(res,p);
        }
    }
}