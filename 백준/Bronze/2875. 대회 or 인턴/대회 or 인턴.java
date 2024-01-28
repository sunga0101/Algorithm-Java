

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int K = Integer.parseInt(s[2]);

        int team = Math.min(N/2,M); // 만들 수 있는 최대 팀의 수
        N = N-team*2; // 팀에 들어가지 않은 여자 수
        M = M-team; // 팀에 들어가지 않은 남자 수
        int extra = N+M-K; // 인턴 나가고 남은 수

        if (extra >= 0) bw.write(team+"");
        else {
            extra *= -1;
            int res = team - (int)Math.ceil((double)extra/3);
            if (res<0) res = 0;
            bw.write(res+"");
        }
        bw.flush();
        br.close();

    }
}