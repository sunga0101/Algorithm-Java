
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int count; // 연쇄 카운트
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] board = new int[12][6];
    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // board에 데이터 입력
        for (int i = 0; i < 12; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < 6; j++) {
                if (s[j].equals("R")) board[i][j] = 1;
                else if (s[j].equals("G")) board[i][j] = 2;
                else if (s[j].equals("B")) board[i][j] = 3;
                else if (s[j].equals("P")) board[i][j] = 4;
                else if (s[j].equals("Y")) board[i][j] = 5;
                else board[i][j] = 0; // .일 경우
            }
        }

        // BFS 실행
        while (true) {
            if (BFS()) {
                count++;
                update();
            }
            else break; // 더이상 4개 이상 영역 없으면 반복 멈춤
        }
        System.out.println(count);
    }

    public static boolean BFS(){
        boolean[][] visitArr = new boolean[12][6];
        final int[] DX = {-1,1,0,0};
        final int[] DY = {0,0,1,-1};
        boolean result = false;


        // 첫 시작 위치 찾기
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (visitArr[i][j] || board[i][j]==0  ) continue;
                LinkedList<int[]> posList = new LinkedList<>();
                queue.offer(new int[]{i,j}); // 좌표 큐에 저장
                posList.offer(new int[]{i,j});
                visitArr[i][j] = true; // 방문 표시

                int val = board[i][j];
                while (!queue.isEmpty()) {
                    int[] visited = queue.poll();
                    int visitX = visited[0];
                    int visitY = visited[1];
                    for (int k = 0; k < 4; k++) {
                        int scopeX = visitX + DX[k];
                        int scopeY = visitY + DY[k];

                        if (scopeX < 0 || scopeY < 0 || scopeX >= board.length || scopeY >= board[0].length) // 벗어난 범위
                            continue;
                        if (visitArr[scopeX][scopeY] || (board[scopeX][scopeY] !=val) ) // 이미 체크 혹은 벽
                            continue;

                        //그렇지 않다면? 인접한 val을 찾았을 때
                        visitArr[scopeX][scopeY] = true;
                        queue.offer(new int[]{scopeX, scopeY});
                        posList.offer(new int[]{scopeX, scopeY});
                    }
                }
                // 동일한 문자의 연결한 한 영역 사이즈
                if (posList.size() > 3) {
                    result = true;
                    int N = posList.size();
                    for (int k = 0; k < N; k++) {
                        int[] pos = posList.poll();
                        int dx = pos[0];
                        int dy = pos[1];
                        board[dx][dy] = 0; // 벽으로 만들기 (0)
                    }
                }
            }
        }
        return result;
    }

    public static void update(){ // 값이
        for (int j = 0; j < 6; j++) {
            for (int i = 11; i > 0; i--) {
                if (board[i][j] != 0)  continue;
                int step = 1;
                while (step != i && (board[i-step][j] == 0)) step++; // 0행은 체크안하니까
                board[i][j] = board[i-step][j]; // 한 행 아래로 덮어씌우기
                board[i-step][j] = 0; // 빈 공간은 벽으로 변경
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Main cd = new Main();
        cd.solve();
    }
}
