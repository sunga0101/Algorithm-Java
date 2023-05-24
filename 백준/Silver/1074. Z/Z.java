
/*
* 0  1  4  5
* 2  3  6  7
* 8  9  12 13
* 10 11 14 15
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N,r,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); // 2^N 크기 정사각형
        r = Integer.parseInt(s[1]); // 행
        c = Integer.parseInt(s[2]); // 열
        System.out.println(zCnt(N, r, c));
    }

    public static int zCnt(int N, int x, int y) {
        if(N==0){
            return 0;
        }
        // 입력받은 (x,y) 좌표
        int dist = 1<<(N-1); // 2^(n-1)
        int square = dist*dist;
        if (x <  dist && y < dist) { return zCnt(N-1,x,y);} //0구역
        if (x < dist && y >= dist) { return zCnt(N-1,x,y-dist)+ square;} //1구역 (y가 dist부터 시작)
        if (x >= dist && y < dist) { return zCnt(N-1,x-dist,y)+ 2*square;} //2구역 (x가 dist부터 시작)
         else { return zCnt(N-1,x-dist,y-dist)+ 3*square;} //3구역 (x,y가 dist부터 시작)
    }
}