
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        long tmp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long iVal1 = Integer.parseInt(st.nextToken());
        long iVal2 = Integer.parseInt(st.nextToken());

        //swap
        if (iVal1 > iVal2) {
            tmp = iVal1;
            iVal1 = iVal2;
            iVal2 =tmp;
        }

        if (iVal1 == iVal2) {
            bw.write("0");
        } else {
            bw.write(iVal2 - iVal1 - 1 + "\n");
            for (long i = iVal1 + 1; i < iVal2; i++) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}