class Solution {
    public int solution(int n) {
        int count = 0;
        int sum=0;
        for (int i=1;i<=n/2;i++){
            sum = 0;
            for (int j=i;j<=n/2+1;j++){
                if (n>sum){
                    sum+=j;
                    if (n==sum) {
                        count++;
                        break;
                    }
                }
                else break;
            }
        }
        return count+1;
    }
}