import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static int count, N, M, dir, gen; // 좌표 map[N][M], 방향, 세대
    public static int[][] map = new int[103][103]; // 넉넉하게
    public static ArrayList<Integer> direct;


    public static void solve() throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine()); // 드래곤커브 개수
        String[] s;
        int res = 0;
        for (int i = 0; i < count; i++) {
            s = br.readLine().split(" ");
            M = Integer.parseInt(s[0]); // 열
            N = Integer.parseInt(s[1]); // 행
            dir = Integer.parseInt(s[2]);
            gen = Integer.parseInt(s[3]);
            // 각 드래곤커브마다 맵에 표시
            draw(N, M, dir, gen);
        }

        // 이후에 꼭짓점 사각형 개수 세기
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i][j + 1] == 1 && 
                    map[i + 1][j] == 1 && map[i + 1][j + 1] == 1)
                    res++;
            }
        }

        System.out.println(res);
    }

    // 한개의 드래곤커브 마다 map에 표시하는 함수
    public static void draw(int n, int m, int d, int g) {
        map[n][m] = 1;
        // 현 드래곤커브의 방향, 세대에 대한 direct 경로 생성
        makeCurve(g, d); // direct = [0, 1, 2, 1, 2, 3, 2, 1]
        for (Integer dir : direct) {
            if (dir == 0) {
                m += 1;
            } else if (dir == 1) {
                n -= 1;
            } else if (dir == 2) {
                m -= 1;
            } else if (dir == 3) {
                n += 1;
            }
            map[n][m] = 1; // 사용되는 꼭짓점
        }
    }

    // 이전 : a,b,c,d 
    // 이후 : a,b,c,d + (d+1),(c+1),(b+1),(a+1)
    public static void makeCurve(int gen, int dir) {
        direct = new ArrayList<>();
        direct.add(dir);
        if (gen == 0) return;
        for (int i = 1; i <= gen; i++) {
            for (int j = direct.size() - 1; j >= 0; j--) { // 이전 경로의 맨 뒤에서부터
                int t = direct.get(j);
                direct.add((t + 1) % 4);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        solve();
    }
}