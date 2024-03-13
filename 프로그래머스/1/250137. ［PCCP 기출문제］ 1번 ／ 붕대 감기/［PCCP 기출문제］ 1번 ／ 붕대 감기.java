class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int curHP = health; // 현재 체력
        int curTime = 0; // 현재 시간
        int combo = 0; // 지속 횟수
        int attackN = attacks.length; // 공격 갯수
        int limitTime = attacks[attackN-1][0]; // 이때까지
        int t = 0;
        
        for (int i=0;i<=limitTime;i++){ // 매 초마다
            if (curTime == attacks[t][0]){
                curHP -= attacks[t][1];
                t++;
                combo = 0;
                if (curHP <1){
                    return -1;
                }
            }
            else {
                curHP += bandage[1];
                combo++;
                if (combo == bandage[0]) {
                    curHP+=bandage[2];
                    combo = 0;
                }
                curHP = Math.min(curHP,health);
            }
            curTime++;
        }
        return curHP;
    }
}