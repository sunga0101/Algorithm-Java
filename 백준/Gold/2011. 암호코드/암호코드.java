

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int[] dp = new int[s.length() + 1];

        // 입력 암호가 0으로 시작하면 가능한 알파벳이 없음
        if (s.charAt(0) == '0') {
            bw.write("0");
            bw.flush();
            br.close();
            return;
        } else {
            // 정상 입력의 경우
            dp[0] = 1; // 로직을 위해 추가
            dp[1] = 1; // 0이 아닌 1-9의 경우니까
            for (int i = 2; i <= s.length(); i++) {
                char ch = s.charAt(i - 1); // 현재 비교하는 문자
                char prev = s.charAt(i - 2); // 현재 문자의 앞 문자
                if (ch == '0') {
                    if (prev == '1' || prev == '2') {
                        dp[i] = dp[i - 2] % 1000000;
                    } else break; // 1이나 2가 아닌 수 뒤에 오는 0의 경우-> 0, 50 등 암호가 불가능
                } else { // 1~9의 경우
                    if (prev == '0') {
                        dp[i] = dp[i - 1] % 1000000; // i가 한자리인 경우만 가능하므로 i-1의 경우와 같다
                    } else {
                        int cr = (prev - '0') * 10 + (ch - '0');
                        if (cr >= 1 && cr <= 26) dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000;
                        else dp[i] = dp[i - 1] % 1000000;
                    }

                }

            }
            bw.write((dp[s.length()] % 1000000) + "");
            bw.flush();
            br.close();
        }
    }
}
