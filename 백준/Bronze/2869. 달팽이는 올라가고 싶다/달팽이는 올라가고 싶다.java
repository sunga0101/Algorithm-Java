

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int v = Integer.parseInt(s[2]);
        int days = 0;
        int dist = a-b; // 하루 이동량
        v = v-b; // 최소 도착 거리
        if (v%dist==0) days = v/dist;
        else days = v/dist+1;


        bw.write(days+"");
        bw.flush();
        br.close();

    }
}