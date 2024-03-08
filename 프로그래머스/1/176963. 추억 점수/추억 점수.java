import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        ArrayList<Member> members = new ArrayList<>();
        int idx = 0;
        for (String s : name){
            members.add(new Member(s,yearning[idx]));
            idx++;
        }   
        
        int count = photo.length;
        int[] result = new int[count];
        for (int i=0;i<count;i++){
            String[] str = photo[i];
            for (int j=0;j<str.length;j++){
                for (Member m: members){
                    if (m.name.equals(str[j]))
                        result[i]+= m.yearning;
                }
            }
        }
        return result;
    }
    
    class Member {
        String name;
        int yearning;
        public Member(String name, int yearning){
            this.name = name;
            this.yearning = yearning;
        }
    }
}