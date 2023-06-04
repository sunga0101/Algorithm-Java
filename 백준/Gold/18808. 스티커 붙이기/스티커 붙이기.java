
import java.io.*;

public class Main {
    static int N,M,K,r,c; // 세로, 가로, 스티커 개수
    static int[][] note;
    static int[][] board = new int[11][11];

//    클래스는 굳이 필요 없는 듯..
//    ArrayList<Sticker> stickerArrayList = new ArrayList<>(); // 스티커 리스트 K개의 sticker
//    static class Sticker {
//        int R, C; // 행, 열
//        static int[][] board = new int[11][11];
//
//    }


    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);
        note = new int[N][M]; // 노트북 크기

        for (int i = 0; i < K; i++) { // 스티커 입력
            s = br.readLine().split(" ");
            r = Integer.parseInt(s[0]); // 행
            c = Integer.parseInt(s[1]); // 열
            // 각 스티커별 0/1값 넣기
            for (int j = 0; j < r; j++) {
                s = br.readLine().split(" ");
                for (int k = 0; k < c; k++) {
                    board[j][k]=Integer.parseInt(s[k]);
                }
            }

            for (int j = 0; j < 4; j++) { // 4방향 체크
                boolean check = false;
                for (int x = 0; x <= N-r; x++) { // 등호 넣어야함
                    if (check) break;
                    for (int y = 0; y <= M-c; y++) { // 등호 넣어야함
                        if (checkPut(x,y)) { // 노트북(x,y)자리에 (r,c)를 체크
                            check = true;
                            break;
                        }
                    }
                }
                if (check) break;
                rotate();// 90도 회전
            }
        }

        // count
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (note[i][j]==1)
                    cnt++;
            }

        }
        bw.write(cnt+""); // 결과 출력
        bw.flush();
        br.close();
    }

    static public boolean checkPut(int noteX, int noteY){
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j]==1 && note[i+noteX][j+noteY]==1)
                    return false;
            }
        } // 종료조건 되지 않고 모두 확인 완료라면
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j]==1)
                    note[i+noteX][j+noteY] = 1; // 노트북에 put
            }
        }
        return true;
    }

    public static void rotate() { // 90도 회전

        int[][] tmp = new int[r][c];
        for (int i = 0; i < r; i++) { // 복사
            if (c >= 0) System.arraycopy(board[i], 0, tmp[i], 0, c);
        }
        for (int i = 0; i < c; i++) { // 90도 회전한 보드 만들기
            for (int j = 0; j < r; j++) {
                board[i][j] = tmp[r - j - 1][i];
            }
        }

        int temp = r;
        r = c;
        c = temp; // 보드 가로세로 전환
    }

    public static void main(String[] args) throws IOException {
        Main code = new Main();
        code.solve();
    }
}
