

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int totalPrice = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i=0;i<n;i++){
            String[] s = br.readLine().split(" ");
            sum+= Integer.parseInt(s[0])*Integer.parseInt(s[1]);
        }

        if (sum == totalPrice) bw.write("Yes");
        else bw.write("No");

        bw.flush();
        br.close();
    }

}
