

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] colors = {"black", "brown", "red", "orange", "yellow","green","blue","violet","grey","white"};
        String[] s = new String[3];
        s[0]= br.readLine();
        s[1]= br.readLine();
        s[2]= br.readLine();

        int first = 0;
        int second = 0;
        int third = 0;

        for (int i=0;i<colors.length; i++){
            if (colors[i].equals(s[0])) first = i;
            if (colors[i].equals(s[1])) second = i;
            if (colors[i].equals(s[2])) third = i;
        }

        long res = 10*first + second;
        res *= (int)Math.pow(10,third);
        bw.write(res+"");
        bw.flush();
        br.close();

    }
}