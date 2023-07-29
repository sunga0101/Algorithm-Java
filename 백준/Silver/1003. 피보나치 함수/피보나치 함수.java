/*
0 1
-----
1 0		//결과
0 1
1 1
1 2
2 3
3 5
5 8
8 13
13 21
21 34
34 55
55 89
89 144
144 233
233 377
*
*/
import java.io.*;

public class Main {
    static int cnt0, cnt1;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            cnt0=0;
            cnt1=0;
            int target = Integer.parseInt(br.readLine());
            fibonacci(target);
            bw.write(cnt0+" "+cnt1+"\n");
        }
        bw.flush();
        br.close();
    }

    public static void fibonacci(int k){
        int first = 0; // 첫번째 자리
        int second = 1; // 두번째 자리
        int fiboSum = 0; // 결과값 (세번째 자리)

        if (k==0) {
            cnt0++;
            return;
        }
        else if (k==1) {
            cnt1++;
            return;
        }
        else {
            for (int i = 1; i < k; i++) {
                fiboSum = first+second;
                first = second;
                second = fiboSum;
            }
            cnt0 = first;
            cnt1 = second;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
