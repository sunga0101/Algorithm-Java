class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = (brown-4)/2;     
        int x = 0;
        
        for (int i=1;i<=sum/2;i++){
            if (yellow%i==0 && i*(sum-i)==yellow){
                x = i;
                break;
            }
        }
        int[] answer = {sum-x+2,x+2};
        return answer;
    }
}