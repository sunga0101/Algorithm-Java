
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Main {
    static int N, minRes = 1000;
    static int[][] board;
    static ArrayList<Integer> startTeam;
    static ArrayList<Integer> linkTeam;
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        board = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        
        // 1~N
        startTeam = new ArrayList<>(); // 초기화
        func(1, 0);
        bw.write(minRes+"");
        bw.flush();
        br.close();
    }


    // 조합 경우의 수
    public static void func(int k, int count) {
        if(count == N/2) {
            linkTeam = new ArrayList<>(); // 초기화
            for (int i = 1; i <= N ; i++) {
                if (!startTeam.contains(i)) // 이미 start 팀의 멤버인지
                    linkTeam.add(i); // 링크 팀 멤버 추가
            }
            check(startTeam,linkTeam);
            return;
        }

        for(int i = k; i <= N; i++) { // N에서 2/n명 뽑아야 함
            startTeam.add(i);
            func(i+1, count + 1);
            startTeam.remove(startTeam.size() - 1);
        }
    }

    public static void check(ArrayList<Integer> startTeam, ArrayList<Integer>  linkTeam){
        int startSum=0, linkSum=0;
        for (int i = 0; i < startTeam.size()-1; i++) { // size-1번째 멤버와
            for(int j = i + 1; j < startTeam.size(); j++) { // size번째 멤버 체크
                int x = startTeam.get(i);
                int y = startTeam.get(j);
                startSum += board[x][y] + board[y][x];
            }
        }

        for (int i = 0; i < linkTeam.size()-1; i++) { // size-1번째 멤버와
            for(int j = i + 1; j < linkTeam.size(); j++) { // size번째 멤버 체크
                int x = linkTeam.get(i);
                int y = linkTeam.get(j);
                linkSum += board[x][y] + board[y][x];
            }
        }
        minRes = min(minRes,abs(startSum-linkSum));
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
