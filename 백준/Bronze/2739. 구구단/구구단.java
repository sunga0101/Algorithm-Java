
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // n단
        for (int i=1;i<10;i++){
            bw.write(n+" * "+i+" = "+i*n+"\n");
        }
        bw.flush();
        br.close();
    }
}
