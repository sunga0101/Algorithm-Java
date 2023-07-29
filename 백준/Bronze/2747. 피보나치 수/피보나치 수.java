
import java.io.*;

public class Main {
    static int fibo;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int target = Integer.parseInt(br.readLine());
        fibonacci(target);
        bw.write(fibo+"\n");
        bw.flush();
        br.close();
    }

    public static void fibonacci(int k){
        int first = 0; // 첫번째 자리
        int second = 1; // 두번째 자리
        int fiboSum = 0; // 결과값 (세번째 자리)

        if (k==0) {
            fibo = 0;
            return;
        }
        else if (k==1) {
            fibo++;
            return;
        }
        else {
            for (int i = 1; i < k; i++) {
                fiboSum = first+second;
                first = second;
                second = fiboSum;
            }
            fibo = second;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
