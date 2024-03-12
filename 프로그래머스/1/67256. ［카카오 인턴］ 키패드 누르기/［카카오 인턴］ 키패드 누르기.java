class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] board = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-2}};
        String answer="";
        int leftX = 3;
        int leftY = 0; // -1지점에서 시작
        int leftVal = -1;
        int rightX = 3;
        int rightY = 2; // -2지점에서 시작
        int rightVal = -2;
        
        int nextX=0;
        int nextY=0;
        
        for (int i=0;i<numbers.length;i++){
            int next = numbers[i];
            
            if (next==1||next==4||next==7){
                leftVal = next;
                answer+="L";
            }
            else if (next==3||next==6||next==9){
                rightVal = next;
                answer+="R";
            }
            else {
                if (next==2){
                    nextX=0;
                    nextY=1;
                }else if (next==5){
                    nextX=1;
                    nextY=1;
                }else if (next==8){
                    nextX=2;
                    nextY=1;
                }else{
                    nextX=3;
                    nextY=1;
                }
                
                for (int j=0;j<4;j++){
                    for (int k=0;k<3;k++){
                        if (board[j][k]==leftVal){
                            leftX=j;
                            leftY=k;
                        }
                        if (board[j][k]==rightVal){
                            rightX=j;
                            rightY=k;
                        }
                    }
                }
                
                int leftDiff = Math.max(leftX,nextX)-Math.min(leftX,nextX)
                    +Math.max(leftY,nextY)-Math.min(leftY,nextY);
                int rightDiff = Math.max(rightX,nextX)-Math.min(rightX,nextX)
                    +Math.max(rightY,nextY)-Math.min(rightY,nextY);
                
                if (leftDiff == rightDiff) {
                    if (hand.equals("right")){
                        answer+="R";
                        rightVal=next;
                    }
                    else {
                        answer+="L";
                        leftVal=next;
                    }
                }
                else if (leftDiff > rightDiff) {
                    answer+="R";
                    rightVal=next;
                }
                else {
                    answer+="L";
                    leftVal=next;
                }
            }
        }
        
        return answer;
    }
}