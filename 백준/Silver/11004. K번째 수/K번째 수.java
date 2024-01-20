
import java.io.*;
import java.util.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        ArrayList<Integer> list = new ArrayList<>();

        s = br.readLine().split(" ");
        for (int i=0;i<N;i++){
            list.add(Integer.parseInt(s[i]));
        }

        Collections.sort(list);

        bw.write(list.get(K-1)+"\n");
        bw.flush();
        br.close();

    }
}
