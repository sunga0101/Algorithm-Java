class Solution {
    public int solution(String[] babbling) {
        String[] keywords = {"aya", "ye", "woo", "ma" };
        int n = babbling.length;
        int cnt = 0;
        
        for (int i=0;i<n;i++){
            babbling[i] = babbling[i].replace("ayaaya","!");
            babbling[i] = babbling[i].replace("yeye","!");
            babbling[i] = babbling[i].replace("woowoo","!");
            babbling[i] = babbling[i].replace("mama","!");
            
            
            babbling[i] = babbling[i].replace("aya"," ");
            babbling[i] = babbling[i].replace("ye"," ");
            babbling[i] = babbling[i].replace("woo"," ");
            babbling[i] = babbling[i].replace("ma"," ");
            
            babbling[i] = babbling[i].replace(" ","");
            System.out.println(babbling[i]);
            
            if (babbling[i].length() ==0) cnt++;
        }
        
        
        return cnt;
    }
}