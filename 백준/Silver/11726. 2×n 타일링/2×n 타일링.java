
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] ans;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        ans = new int[n+1];

        // An = An-1 + An-2
        ans[1] = 1;
        if (n>=2)
            ans[2] = 2;
        for (int i=3;i<=n;i++){
            ans[i] = ( ans[i-1]+ans[i-2])%10007;
        }

        bw.write(ans[n]+"");
        bw.flush();
        br.close();
    }
}
