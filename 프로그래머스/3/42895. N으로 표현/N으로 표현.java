import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        List<Set<Integer>> setList = new ArrayList<>(); // set을 담을 list
        for (int i=0;i<9;i++){
            setList.add(new HashSet<Integer>()); // 1~8개의 해시셋
        }
        setList.get(1).add(N); // 1개로 만들 수 있는 수 자기 자신
        for (int i=2;i<9;i++){
            for (int j=1;j<=i/2;j++){
                func(setList.get(i),setList.get(j),setList.get(i-j));
                func(setList.get(i),setList.get(i-j),setList.get(j));
            }
            String nStr = Integer.toString(N);
            setList.get(i).add(Integer.parseInt(nStr.repeat(i)));
        }
        for (int i=1;i<9;i++){
            if (setList.get(i).contains(number)) return i;
        }
        return -1;
    }
    
    public void func(Set<Integer> target, Set<Integer> a, Set<Integer> b){
        for (int i:a){
            for (int j:b){
                target.add(i+j);
                target.add(i*j);
                target.add(i-j);
                if (j!=0) target.add(i/j);
            }
        }
    }
}