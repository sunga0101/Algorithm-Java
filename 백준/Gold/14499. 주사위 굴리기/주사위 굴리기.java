
import java.io.*;

public class Main {

    static int N, M, K, x, y, dir, temp; // dir:입력받은 동서남북 방향
    static int[][] dice = new int[4][3]; // 전개도 2차원배열
    static int[][] map;
    static boolean possible = false;
    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        x = Integer.parseInt(s[2]);
        y = Integer.parseInt(s[3]);
        K = Integer.parseInt(s[4]);

        // 지도 만들기
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 주사위 전개도 만들기
        s = br.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            dir = Integer.parseInt(s[i]);
            rotate(dir);
            if (!possible) continue; // 명령 무시

            int upside = dice[1][1];
            int downside = dice[3][1];
            compareCopy(downside);
            bw.write(upside + "\n");

        }
        bw.flush();
        br.close();
    }

    public static void compareCopy(int valDice) { //  주사위값과 map 비교해서 복사
        // valDice: 주사위 아랫면
        if (x >= 0 && x <= N - 1 && y >= 0 && y <= M - 1) { // ArrayIndexOutOfBounds 방지
            if (map[x][y] == 0) { // 주사위 값을 map에 복사
                map[x][y] = valDice;
            } else {
                dice[3][1] = map[x][y];
                map[x][y] = 0;
            }
        }
    }

    public static void rotate(int direct) { // 회전시에 전개도에서 숫자 위치 변경하기
        switch (direct) {
            case 1: // 동 1
                if (y < M - 1) {
                    // map에서 현재위치 (x,y) 변경 -> 오른쪽으로 한 칸 이동
                    y += 1;
                    temp = dice[1][0];
                    dice[1][0] = dice[3][1];
                    dice[3][1] = dice[1][2];
                    dice[1][2] = dice[1][1];
                    dice[1][1] = temp;
                    possible = true;
                    break;
                }
                else possible = false;
                break;
            case 2: // 서 2
                if (y >= 1) {
                    // map에서 현재위치 (x,y) 변경 -> 왼쪽으로 한 칸 이동
                    y -= 1;
                    temp = dice[1][0];
                    dice[1][0] = dice[1][1];
                    dice[1][1] = dice[1][2];
                    dice[1][2] = dice[3][1];
                    dice[3][1] = temp;
                    possible = true;
                    break;
                } else possible = false;
                break;
            case 3: // 북 3
                if (x >= 1) {
                    // map에서 현재위치 (x,y) 변경 -> 위로 한 칸 이동
                    x -= 1;
                    temp = dice[0][1];
                    dice[0][1] = dice[1][1];
                    dice[1][1] = dice[2][1];
                    dice[2][1] = dice[3][1];
                    dice[3][1] = temp;
                    possible = true;
                    break;
                } else possible = false;
                break;
            case 4: // 남 4
                if (x < N - 1) {
                    // map에서 현재위치 (x,y) 변경 -> 아래로 한 칸 이동
                    x += 1;
                    temp = dice[0][1];
                    dice[0][1] = dice[3][1];
                    dice[3][1] = dice[2][1];
                    dice[2][1] = dice[1][1];
                    dice[1][1] = temp;
                    possible = true;
                    break;
                } else possible = false;
                break;
        }
    }


    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}
