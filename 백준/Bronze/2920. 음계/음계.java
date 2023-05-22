
import java.io.*;
public class Main {
    static int[] arr = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < 8; i++) {
            arr[i+1] = Integer.parseInt(s[i]);
        }
        int incCnt = 0;
        int desCnt = 0;
        for (int i = 1; i <= 8; i++) {
            if(arr[i]==i) incCnt+=1;
            if(arr[i]==9-i) desCnt+=1;
        }
        if (incCnt == 8) bw.write("ascending");
        else if (desCnt == 8) bw.write("descending");
        else bw.write("mixed");
        bw.flush();
        br.close();
    }
}
