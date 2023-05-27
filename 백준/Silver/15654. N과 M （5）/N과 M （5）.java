
import java.io.*;
import java.util.Arrays;

public class Main {
    static boolean[] isused = new boolean[10]; // 특정 수가 쓰였는지 체크
    static int[] arr = new int[10]; // 수열 담을 배열
    static int m;
    static int n;
    static int[] nArr; // n개의 입력받은 수열
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); // n개의 수 중에
        m = Integer.parseInt(s[1]); // m개를 골라라
        s = br.readLine().split(" ");
        nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(nArr);
        func(0); // 맨처음 -> 0개니까
        bw.flush();
        br.close();
    }

    public static void func(int k) throws IOException { //nArr에서 m개
        // base condition
        if (k == m) { // m개가 되면 출력
            for (int i = 0; i < m; i++) {
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i =  0; i < n; i++) { // nArr의 모든 요소를 arr에
            if (!isused[i]){
                arr[k]=nArr[i]; // k번째 결정
                isused[i]=true;
                func(k+1);
                isused[i]=false;
            }
        }
    }
}