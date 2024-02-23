import java.util.*;


class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];
        
        // 1로 초기화
        for (int i=1;i<=m;i++){
            map[1][i] = 1;
        }
        for (int i=1;i<=n;i++){
            map[i][1] = 1;
        }
        
        for (int i=0;i<puddles.length;i++){
            int y = puddles[i][0];
            int x = puddles[i][1];
            map[x][y] = -1;
            if (x==1)// 1행이라면
            {
                for (int j=y;j<=m;j++){
                    map[x][j]=-1;
                }
            }
            if (y==1)// 1열이라면
            {
                for (int j=x;j<=n;j++){
                    map[j][y]=-1;
                }
            }
        }
        
        // 경우의 수 구하기
        for (int i=2;i<map.length;i++){
            for (int j=2;j<map[0].length;j++){
                if (map[i][j]==0){
                int up = map[i][j-1];
                int left = map[i-1][j];
                if (up<0) up = 0;
                if (left<0) left = 0;
                map[i][j] = up%1000000007+left%1000000007;
                }
            }
        }
        
        return map[n][m]%1000000007;
    }
}