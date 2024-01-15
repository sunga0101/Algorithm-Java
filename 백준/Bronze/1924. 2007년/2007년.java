

import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] s = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] month = {0,31,28,31,30,31,30,31,31,30,31,30};
        String[] sp = br.readLine().split(" ");
        int mon = Integer.parseInt(sp[0]);
        int day = Integer.parseInt(sp[1]);

        int sumDays = -1;
        sumDays += day;
        for (int i=0; i<mon;i++){
            sumDays += month[i];
        }

        bw.write(s[sumDays % 7]+"\n");
        bw.flush();
        br.close();
    }
}
