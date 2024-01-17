
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] arr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new long[1000001];
        arr[0] = arr[1] = 0;

        for (int i=2;i<=n;i++) {

            // 6으로 나눌 경우
            if (i%6==0){
                arr[i] = Math.min(arr[i-1],(Math.min(arr[i/2],arr[i/3])))+1;
            }
            // 3으로 나눌 경우
            else if (i%3==0){
                arr[i] = Math.min(arr[i-1],arr[i/3])+1;
            }
            // 2으로 나눌 경우
            else if (i%2==0){
                arr[i] = Math.min(arr[i-1],arr[i/2])+1;
            }
            // -1할 경우
            else {
                arr[i] = arr[i-1] + 1;
            }
        }
        bw.write(arr[n]+"");
        bw.flush();
        br.close();
    }
}
