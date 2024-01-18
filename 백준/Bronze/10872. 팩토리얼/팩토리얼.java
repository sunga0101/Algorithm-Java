

import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int res = 1;
        for (int i=1;i<N+1;i++){
            res *= i;
        }
        bw.write(res+"");
        bw.flush();
        br.close();
    }
}
