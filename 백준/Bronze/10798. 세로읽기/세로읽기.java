
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[][] board = new String[5][15];
        int max = 0;
        for (int i = 0; i < 5; i++) {
            String[] s = br.readLine().split("");
            int n = s.length;
            if (n > max) max = n;
            for (int j = 0; j < n; j++) {
                board[i][j] = s[j];
            }
        }
        for (int j = 0; j < max; j++) {
            for (int i = 0; i < 5; i++) {
                if (board[i][j] != null)
                    bw.write(board[i][j]);
            }
        }
        bw.flush();
        br.close();
    }
}

