
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 시간초과
        // 버퍼로 입력 변경
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int iTarget;
        int cnt = 0;
        int iNum = Integer.parseInt(st.nextToken());
        int[] numArr = new int[iNum];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < iNum; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        iTarget = Integer.parseInt(st.nextToken());

        Arrays.sort(numArr);
        // 투포인터
        int startIdx=0;
        int endIdx=iNum-1;
        int sum = 0;

        while (startIdx < endIdx) {
            sum = numArr[startIdx] + numArr[endIdx];
            if (sum == iTarget) {
                cnt++;
            }
            if (sum <= iTarget) {
                startIdx+=1;
            }
            else {
                endIdx-=1;
            }
        }
        bw.write(cnt+"\n");
        bw.flush();
        br.close();
    }
}