import java.io.*;
/**
 * n = 1? 1                                     // arr[1][0]=0 arr[1][1]=1
 * n = 2? 10                                    // arr[2][0]=1 arr[2][1]=0
 * n = 3? 100, 101                              // arr[3][0]=1 arr[3][1]=1
 * n = 4? 1000, 1010, 1001                      // arr[4][0]=2 arr[4][1]=1
 * n = 5? 10000, 10100, 10101, 10010, 10001     // arr[5][0]=3 arr[5][1]=2
 *
 *                                                 arr[i][0] = arr[i-1][0]+arr[i-1][1]
 *                                                 arr[i][1] = arr[i-1][0]
 * */
public class Main {

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        // arr[i][j] : j로 끝나는 i자리 이친수의 개수
        long[][] arr = new long[93][2];  // 1~90까지, 끝자리 수는 0 또는 1
        arr[1][0] = 0;
        arr[1][1] = 1;

        for (int i = 2; i <= n ; i++) {
            arr[i][0] = arr[i-1][0]+arr[i-1][1];
            arr[i][1] = arr[i-1][0];
        }

        bw.write(arr[n][0]+arr[n][1]+"");
        bw.flush();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
