/*
* 퀸 비교할 것
* 1. 한 행에 한 개
* 2. 한 열에 한 개
* 3. 한 대각선에 한 개
*   - 1. / 대각선 한 개
*   - 2. \ 대각선 한 개
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] res = new int[1]; // 결과값
    static boolean[] isused1 = new boolean[32];
    static boolean[] isused2 = new boolean[32];
    static boolean[] isused3 = new boolean[32];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queen(0);
        System.out.println(res[0]);
    }

    public static void queen(int n) {
        if (n == N) {
            res[0]++;
            return;
        }

        for (int i = 0; i < N; i++) { // 각 좌표에 대해서 (n,i)에 퀸을 놓으려면
            if (isused1[i] || isused2[n + i] || isused3[n - i + N - 1])
                continue;
            isused1[i] = true; // 각 열에 퀸 하나 isused[y]
            isused2[n + i] = true; // 좌하단-우상단 대각선 isused[x+y]
            isused3[n - i + N - 1] = true; // 좌상단-우하단 대각선 isused[y-x+n-1]
            queen(n + 1);
            isused1[i] = false;
            isused2[n + i] = false;
            isused3[n - i + N - 1] = false;
        }
    }
}