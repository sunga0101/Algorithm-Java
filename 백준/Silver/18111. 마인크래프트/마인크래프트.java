import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 세로
        int M = Integer.parseInt(s[1]); // 가로
        int B = Integer.parseInt(s[2]); // 초기 블록 갯수
        int[][] map = new int[N][M];
        int curInvent;
        int curTime;

        // map에서 가장 높은 층과 낮은 층
        int highest = -1;
        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]); // 초기 땅의 높이
                if (highest < map[i][j]) highest = map[i][j];
                if (lowest > map[i][j]) lowest = map[i][j];
            }
        }

        //출력할 결과값들
        int resTime = Integer.MAX_VALUE;
        int resHeight = 0;

        for (int h = lowest; h <= highest; h++) {
            curInvent = B;
            curTime = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > h) { // 높이 1 줄이기 (2초 소요)
                        curInvent += map[i][j] - h;
                        curTime += 2 * (map[i][j] - h);
                    } else if (map[i][j] < h) { // 높이 1 높이기 (1초 소요)
                        curInvent -= h - map[i][j];
                        curTime += (h - map[i][j]);
                    }
                }
            }
            if (curInvent >= 0) {
                if (resTime >= curTime) {
                    resTime = curTime;
                    resHeight = h;
                }
            }
        }


        System.out.println(resTime);
        System.out.println(resHeight);
        bw.write("\n");
        bw.flush();
        br.close();
    }
}
