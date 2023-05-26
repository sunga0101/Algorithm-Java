
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int primeCnt = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 2; j < arr[i]; j++) {
                if (arr[i] != 1 && arr[i] % j == 0)
                    break;
                else {
                    cnt++;
                }
            }
            if (cnt == arr[i] - 2) {
                primeCnt++;
            }
        }
        bw.write(primeCnt + "\n");
        bw.flush();
        br.close();
    }
}
