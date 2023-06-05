
import java.io.*;

public class Main {
    static int N, maximum; // 보드 크기
    static int[][] board = new int[22][22];
    static int[][] newMap;

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        newMap = new int[N][N];
        for (int i = 0; i < N; i++) { // 초기 보드 입력
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j]= Integer.parseInt(s[j]);
            }
        }

        func(0,board);
        bw.write(maximum+"");
        bw.flush();
        br.close();
    }

    public static void func(int k, int map[][]){
        if (k==5) { //최대 5번
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j]> maximum)
                        maximum = map[i][j];
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {

            int[][] tmpBoard = check(i,map);
            func(k + 1, tmpBoard);
        }
    }

    public static int[][] check(int dir, int board[][]){
        newMap = new int[N][N]; // 초기화
        if (dir == 0){ // 위
            for (int j = 0; j < N; j++){
                int baseBlock = -1; // 이전에 만난 블록
                int nextIdx = 0; // newMap에 들어갈 index
                for (int i=0; i<N; i++) { // 1행부터
                    if (board[i][j] == 0) continue; // 빈칸이면
                    else if (board[i][j] != baseBlock) { // baseblock과 다를때
                        baseBlock = board[i][j];
                        newMap[nextIdx][j] = baseBlock;
                        nextIdx++; // 다음칸으로 이동
                    } else if (board[i][j] == baseBlock) { // 나랑 앞블록 같으면
                        newMap[nextIdx - 1][j] = baseBlock * 2;
                        baseBlock = -1;// 다른 블럭과 못합쳐지도록
                    }

                }
            }
        }
        else if (dir == 1){ // 오른
            for (int i = 0; i < N; i++){ // j = 0,1,2,3..
                int baseBlock = -1; // 이전에 만난 블록
                int nextIdx = N-1; // newMap에 들어갈 index , 처음엔 0, 1
                for (int j=N-1; j>=0; j--)  { // 3,2,1,0..
                    if (board[i][j] == 0) continue; // 빈칸이면
                    else if (board[i][j] != baseBlock) { // baseblock과 다를때
                        baseBlock = board[i][j];
                        newMap[i][nextIdx] = baseBlock;
                        nextIdx--; // 다음칸으로 이동
                    } else if (board[i][j] == baseBlock) { // 나랑 앞블록 같으면
                        newMap[i][nextIdx+1] = baseBlock * 2;
                        baseBlock = -1;// 다른 블럭과 못합쳐지도록
                    }
                }
            }
        }
        else if (dir == 2){ // 아래
            for (int j = 0; j < N; j++){ // j = 0,1,2,3..
                int baseBlock = -1; // 이전에 만난 블록
                int nextIdx = N-1; // newMap에 들어갈 index , 처음엔 3,2
                for (int i=N-1; i>=0; i--) { // 3,2,1,0..
                    if (board[i][j] == 0) continue; // 빈칸이면
                    else if (board[i][j] != baseBlock) { // baseblock과 다를때
                        baseBlock = board[i][j];
                        newMap[nextIdx][j] = baseBlock;
                        nextIdx--; // 다음칸으로 이동
                    } else if (board[i][j] == baseBlock) { // 나랑 앞블록 같으면
                        newMap[nextIdx + 1][j] = baseBlock * 2;
                        baseBlock = -1;// 다른 블럭과 못합쳐지도록
                    }
                }
            }
        }
        else if (dir == 3){ // 왼
            for (int i = 0; i < N; i++){ // j = 0,1,2,3..
                int baseBlock = -1; // 이전에 만난 블록
                int nextIdx = 0; // newMap에 들어갈 index , 처음엔 0, 1
                for (int j=0; j<N; j++) { // 3,2,1,0..
                    if (board[i][j] == 0) continue; // 빈칸이면
                    else if (board[i][j] != baseBlock) { // baseblock과 다를때
                        baseBlock = board[i][j];
                        newMap[i][nextIdx] = baseBlock;
                        nextIdx++; // 다음칸으로 이동
                    } else if (board[i][j] == baseBlock) { // 나랑 앞블록 같으면
                        newMap[i][nextIdx-1] = baseBlock * 2;
                        baseBlock = -1;// 다른 블럭과 못합쳐지도록
                    }
                }
            }
        }
        return newMap;
    }

    static void initBoard(int[][] a, int[][] b){
        // initBoard(a,b) b 데이터 -> a로 cntrl c 후,
        // initBoard(b,a) a 데이터 -> b로 cntrl v 하는 것
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = b[i][j];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
}
