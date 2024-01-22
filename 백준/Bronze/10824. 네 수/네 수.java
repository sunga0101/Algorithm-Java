

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        String fir = s[0]+s[1];
        String sec = s[2]+s[3];
        long sum = Long.parseLong(fir)+Long.parseLong(sec);
        bw.write(sum+"");
        bw.flush();
        br.close();

    }
}
