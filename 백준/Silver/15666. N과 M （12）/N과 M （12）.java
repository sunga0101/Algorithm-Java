
import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] arr = new int[10]; // 수열 담을 배열
    static int m;
    static int n;
    static int[] nArr; // n개의 입력받은 수열
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); //  n개의 수 중에
        m = Integer.parseInt(s[1]); //  m개를 골라라
        s = br.readLine().split(" ");
        nArr = new int[n+1];
        for (int i = 0; i < n; i++) {
            nArr[i+1] = Integer.parseInt(s[i]); // nArr[1]부터 수열
        }
        Arrays.sort(nArr); //사전순 정렬
        func(1,0);
        bw.flush();
        br.close();
    }

    public static void func(int index, int k) throws IOException { //nArr에서 m개
        // base condition
        if (k == m) { // m개가 되면 출력
            for (int i = 0; i < m; i++) {
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }
        int last = 0; // 가장 마지막 최근에 뽑은 수
        for (int i = index; i <= n; i++) { // nArr의 모든 요소를 arr에, index~n
            if (last != nArr[i]) { // 직전 저장한 수가 동일하면
                arr[k] = nArr[i]; // k번째 결정
                last = nArr[i];
                func(i, k + 1);
            }
        }
    }
}
