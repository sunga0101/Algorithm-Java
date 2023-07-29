
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n,m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void solution() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split("\n");
        int testN = Integer.parseInt(s[0]);
        for (int i = 0; i < testN; i++) {
            s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            int result =
                    pairCount(n,m);
            bw.write(result+"\n");
        }
        bw.flush();
        br.close();
    }

    private static int pairCount(int a, int b) throws IOException {
        int result = 0;
        ArrayList aList = new ArrayList();
        ArrayList bList = new ArrayList();
        String[] s = br.readLine().split(" ");

        // 리스트 삽입, 중복 제거
        for (int i = 0; i < a; i++){
            int value = Integer.parseInt(s[i]);
                aList.add(value);
        }
        s = br.readLine().split(" ");
        for (int i = 0; i < b; i++){
            int value = Integer.parseInt(s[i]);
                bList.add(value);
        }
        Collections.sort(bList);

        // 이분탐색
        for (int j = 0; j < n; j++) {
            int first = 0;
            int end = m - 1;
            int index = 0;

            while (first <= end) {
                int mid = (first + end) / 2;
                if ((int)bList.get(mid) < (int)aList.get(j)) {
                    first = mid + 1;
                    index = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            result += index;
        }
        return (result);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
