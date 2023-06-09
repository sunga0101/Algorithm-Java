
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[][] arrList = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            arrList[i][0] = x;
            arrList[i][1] = y;
        }

        Arrays.sort(arrList, (element1, element2) -> {
            if(element1[0] == element2[0]) {
                return element1[1] - element2[1];
            }
            else {
                return element1[0] - element2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            bw.write(arrList[i][0] + " " + arrList[i][1]+"\n");
        }

        bw.flush();
        br.close();
     }
}
