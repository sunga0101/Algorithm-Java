import java.io.*;

public class Main {
    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int C = Integer.parseInt(s[2]);
        bw.write(((A+B)%C)+"\n"); //1
        bw.write((((A%C)+(B%C))%C)+"\n"); //2
        bw.write(((A*B)%C)+"\n"); //3
        bw.write((((A%C)*(B%C))%C)+""); //4
        bw.flush();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        Main cd = new Main();
        cd.solve();
    }
}
