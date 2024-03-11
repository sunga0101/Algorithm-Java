class Solution {
    public String solution(String X, String Y) {
        String[] Xstr = X.split("");
        String[] Ystr = Y.split("");
        
        int[] numXCnt = new int[10];
        for (int i=0;i<Xstr.length;i++){
            int idx = Integer.parseInt(Xstr[i]);
            numXCnt[idx]++;
        }
        
        int[] numYCnt = new int[10];
        for (int i=0;i<Ystr.length;i++){
            int idx = Integer.parseInt(Ystr[i]);
            numYCnt[idx]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=9;i>=0; i--){
            for (int j=0;j<Math.min(numXCnt[i],numYCnt[i]);j++){
                sb.append(i);
            }
        }
        
        
        if (sb.toString().equals("") ) 
            return "-1";
        else if (sb.toString().charAt(0)==48) 
            return "0";
        else return sb.toString();
    }
}