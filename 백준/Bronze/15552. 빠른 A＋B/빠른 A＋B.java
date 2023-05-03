
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int iCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < iCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int iVal1 = Integer.parseInt(st.nextToken());
            int iVal2 = Integer.parseInt(st.nextToken());
            bw.write(iVal1 + iVal2 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
