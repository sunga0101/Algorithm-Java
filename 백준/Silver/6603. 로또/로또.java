
import java.io.*;
import java.util.Arrays;

public class Main {
    
    // 런타임 에러 :: 수의 범위 1~49 -> isused, arr 범위 50이상
    static boolean[] isused = new boolean[55]; // 특정 수가 쓰였는지 체크
    static int[] arr = new int[55]; // 수열 담을 배열
    static int m = 6; // 로또 6개 선택
    static int n;
    static int[] nArr; // n개의 입력받은 수열
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;
        do {
            s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            nArr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                nArr[i] = Integer.parseInt(s[i]); // nArr[1]부터 수열
            }
            Arrays.sort(nArr); //사전순 정렬
            func(1, 0);
            bw.write("\n");
        } while (!s[0].equals("0"));

        bw.flush();
        br.close();
    }

    public static void func(int index, int k) throws IOException { //nArr에서 6개
        // base condition
        if (k == m) { // m개가 되면
            for (int i = 0; i < m; i++) { // m개 출력  (6개 출력)
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = index; i <= n; i++) { // nArr의 모든 요소를 arr에, index~n
            if (!isused[i]) {
                arr[k] = nArr[i]; // k번째 결정
                isused[i] = true;
                func(i, k + 1);
                isused[i] = false;
            }
        }
    }
}