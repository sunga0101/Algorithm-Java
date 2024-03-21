class Solution {
    public int solution(int n) {
        int answer = 0;
        int nextN = n;
        String nStr = Integer.toBinaryString(n);
        int beforeN = nStr.length();
        int afterN = nStr.replace("1","").length();
        int cntN = beforeN-afterN;
        
        while (answer<n){
            nextN += 1;
            String nextNstr = Integer.toBinaryString(nextN);
            int before = nextNstr.length();
            int after = nextNstr.replace("1","").length();
            int cnt = before-after;
            
            if (cnt == cntN) answer = nextN;
        }
        return answer;
    }
}