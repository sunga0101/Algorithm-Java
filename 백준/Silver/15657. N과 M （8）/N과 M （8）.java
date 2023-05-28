
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
        n = Integer.parseInt(s[0]); // 4, n개의 수 중에
        m = Integer.parseInt(s[1]); // 2, m개를 골라라
        s = br.readLine().split(" "); // 9 8 7 1
        nArr = new int[n+1];
        for (int i = 0; i < n; i++) {
            nArr[i+1] = Integer.parseInt(s[i]);
        }
        Arrays.toString(nArr);
        Arrays.toString(nArr);

        Arrays.sort(nArr);
        func(1,0); // 맨처음 -> 0개니까
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

        for (int i =  index; i <= n; i++) { // nArr의 모든 요소를 arr에, index~n
                arr[k]=nArr[i]; // k번째 결정
                func(i,k+1);
        }
    }
}
