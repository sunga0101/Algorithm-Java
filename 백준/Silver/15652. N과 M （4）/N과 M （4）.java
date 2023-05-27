
import java.io.*;

public class Main {
    static boolean[] isused = new boolean[10]; // 특정 수가 쓰였는지 체크
    static int[] arr = new int[10]; // 수열 담을 배열
    static int m;
    static int n;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); // 1부터 n까지의 수
        m = Integer.parseInt(s[1]); // m개의 수
        func(1, 0); // 맨처음 -> 0개니까
        bw.flush();
        br.close();
    }

    public static void func(int index, int k) throws IOException {
        // base condition
        if (k == m) { // m개가 되면 출력
            for (int i = 0; i < m; i++) {
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i =  index; i <= n; i++) { // 조건 : index ~ n까지 수 중에서 수열
                arr[k]=i; // k번째 결정
                func(i, k+1);
        }
    }
}
