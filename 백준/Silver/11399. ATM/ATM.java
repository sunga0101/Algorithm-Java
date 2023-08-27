import java.io.*;
import java.util.Arrays;

public class Main {
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // n명
        int[] times = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(s[i]);
        }
        
        // 긴 소요시간이 앞에 있을수록 전체 대기시간 길어짐
        Arrays.sort(times); // 최소시간이 제일 앞으로 가도록

        int delayTime = 0; // 다음 사람이 지금까지 기다린 시간
        int addTime = 0; // 앞 사람들의 통화시간
        for (int i = 0; i < n; i++) {
            addTime += times[i];
            delayTime += addTime;
        }

        bw.write(delayTime+"");
        bw.flush();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}

