
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            String[] s = br.readLine().split(" ");
            int num = Integer.parseInt(s[0]);
            long sum =0;
            for (int j=1;j<num;j++){
                for (int k=j+1;k<=num;k++) {
                    int max = Math.max(Integer.parseInt(s[j]),Integer.parseInt(s[k]));
                    int min = Math.min(Integer.parseInt(s[j]),Integer.parseInt(s[k]));
                    sum += getGCD(max,min);
                }
            }
            bw.write(sum+"\n");
        }
        bw.flush();
        br.close();

    }

    public static int getGCD(int max, int min){
        while(min != 0){
            int temp = max;
            max = min;
            min = temp%min;
        }
        return max;
    }
}