class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int max = -1;
        int maxIdx = -1;
        int[] cnt = new int[1001];
        for (int i=0;i<array.length;i++){
            cnt[array[i]]++;
            if (max<cnt[array[i]]) {
                max = cnt[array[i]]; // 2번 등장
                maxIdx = array[i]; // 3이 
            }
        }
        int count=0;
        for (int i:cnt){
            if (max==i)
                count++;       
        }
        if (count!=1) return -1;
        return maxIdx;
    }
}