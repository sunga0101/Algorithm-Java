import java.io.*;

public class Main {

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] square = new int[1002];
        square[1] = 1;
        square[2] = 3;
        for (int i = 3; i <= n; i++) { // square[n] = (square[n - 1] + 2 * square[n - 2])
            square[i] = (square[i - 1] + 2 * square[i - 2]) % 10007; // 1007로 나눈 나머지
        }
        bw.write(square[n]+"");
        bw.flush();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}