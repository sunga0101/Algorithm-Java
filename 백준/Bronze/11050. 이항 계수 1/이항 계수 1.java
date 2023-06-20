import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        bw.write(punc(N,K)+"\n");
        bw.flush();
        br.close();
    }

    public static int punc(int n, int k){
        // base condition
        if (k == 0 || k== n) return 1;
        else // (k>0 || k<n)
            return punc(n-1,k-1)+punc(n-1,k);
        
    }
}
