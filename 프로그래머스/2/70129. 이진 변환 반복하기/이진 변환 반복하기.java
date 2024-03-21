class Solution {
    public int[] solution(String s) {
        int len = 0;
        int count = 0;
        int zeroSum = 0;
        
        while (! s.equals("1")){
            int before = s.length();
            s = s.replace("0",""); // remove 0
            len = s.length(); 
            zeroSum += before-len;
            s = Integer.toBinaryString(len);
            count++;
        }
        
        return new int[]{count, zeroSum};
    }
}