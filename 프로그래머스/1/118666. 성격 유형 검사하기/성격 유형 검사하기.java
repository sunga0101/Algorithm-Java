class Solution {
    public String solution(String[] survey, int[] choices) {
        int[][] board = new int[4][2];
        String[][] str = {{"R","T"},{"C","F"},{"J","M"},{"A","N"}};
        int n = survey.length;
        for (int i=0;i<n;i++){
            String type = survey[i];
            int point = choices[i];
            if (type.equals("RT")){
                if(point>4){
                    board[0][1]+=point-4; // T
                }
                else board[0][0]+=4-point; // R
            } else if (type.equals("TR")){
                if(point>4){
                    board[0][0]+=point-4; // T
                }
                else board[0][1]+=4-point; // R
            }
            
            else if (type.equals("CF")){
                if(point>4){
                    board[1][1]+=point-4; // F
                }
                else board[1][0]+=4-point; // C
            } else if (type.equals("FC")){
                if(point>4){
                    board[1][0]+=point-4; // F
                }
                else board[1][1]+=4-point; // C
            }
            
            else if (type.equals("JM")){
                if(point>4){
                    board[2][1]+=point-4; // M
                }
                else board[2][0]+=4-point; // J
            } else if (type.equals("MJ")){
                if(point>4){
                    board[2][0]+=point-4; // M
                }
                else board[2][1]+=4-point; // J
            }
            
            else if (type.equals("AN")){
                if(point>4){
                    board[3][1]+=point-4; // N
                }
                else board[3][0]+=4-point; // A
            } else if (type.equals("NA")){
                if(point>4){
                    board[3][0]+=point-4; // N
                }
                else board[3][1]+=4-point; // A
            }
            
        }
        
        String answer = "";

        for (int i=0;i<4;i++){
            if (board[i][0]>=board[i][1]){
                answer+=str[i][0];
            } else answer+=str[i][1];
        }
        return answer;
    }
}