class Solution {
    public int solution(int number, int limit, int power) {
        int[] nArr = new int[number+1];
        nArr[1] = 1;
        for (int i=2;i<=number;i++){
            for (int j=1;j*j<=i;j++){
                if (i%j==0){
                    nArr[i]+=2;
                    if (i/j==j){
                    nArr[i]--;
                    }
                }
                
            }
            if (nArr[i]>limit) nArr[i] = power;
            System.out.print(nArr[i]);
        }
        
        int answer = 0;
        for (int i=1;i<nArr.length;i++){
            answer += nArr[i];
        }
        return answer;
    }
}