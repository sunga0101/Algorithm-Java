class Solution {
    public String solution(int a, int b) {
        int sum = 0;
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] month = {0,31,29,31,30,31,30,31,31,30,31,30};
        for (int i=0; i<a;i++){
            sum+=month[i];
        }
        sum+=(b-1);
        String answer = day[sum%7];
        return answer;
    }
}