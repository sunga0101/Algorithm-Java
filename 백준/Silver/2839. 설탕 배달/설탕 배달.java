
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N == 4) { // 특수 경우
            System.out.println(-1);
            System.exit(0);
        }
        
        int val, extra;
        val = N / 5;
        extra = N % 5;

        if (extra == 0) cnt = N / 5;
        else if (extra == 1) {
            cnt = val - 1 + 2;
        } else if (extra == 3) {
            cnt = val + 1;
        } else if (extra == 4) {
            cnt = val - 1 + 3;
        } else {// 5의 최대 개수로는 안되는경우
            while (N > 0) {
                N -= 3;
                cnt++;
                if (N % 5 == 0) {
                    cnt += (N / 5);
                    System.out.println(cnt);
                    System.exit(0);
                }
            }
            cnt = -1;
        }
        System.out.println(cnt);
    }
}