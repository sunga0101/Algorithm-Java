class Solution {
    public int solution(String[] friends, String[] gifts) {
        int num = friends.length;
        int[][] score = new int[num][num]; //[준사람][받은사람]
        int[][] count = new int[num][4]; // [준][받은][선물지수][다음달]
        for (int i=0;i<gifts.length;i++){
            String[] s = gifts[i].split(" ");
            
            int x=0;
            int y=0;
            for (int j=0;j<num;j++){
                if (s[0].equals(friends[j])){
                    x=j;
                    count[j][0]++;
                    count[j][2]++;
                }
                if (s[1].equals(friends[j])){
                    y=j;
                    count[j][1]++;
                    count[j][2]--;
                }
                score[j][j] = -1;
            }
            score[x][y]++;
        }
        
        
        for (int i=0;i<num;i++){
            for (int j=0;j<num;j++){
                if (score[i][j]>=0){
                    int a = score[i][j];
                    int b = score[j][i];
                    if (a>b) count[i][3]++; // 하나 받음
                    if (a==b) {
                        if (count[i][2]>count[j][2]) count[i][3]++; // 하나 받음
                    }
                }
            }
        }
        
        int max = -1;
        for (int i=0;i<num;i++){
            if (max<count[i][3])
                max = count[i][3];
        }
        
        return max;
    }
}