import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] s = {"code", "date", "maximum", "remain"};
        int extIdx=0;
        // int sortIdx=0;
        final int[] sortIdx = {0};
        
        for (int i=0;i<4;i++){
            if (ext.equals(s[i])){
                extIdx=i;
            }
            if (sort_by.equals(s[i])){
                sortIdx[0]=i;
            }
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        
        for (int i=0;i<data.length;i++){
            if (data[i][extIdx]<val_ext){
                list.add(data[i]);
            }
        }
        
        
        
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[sortIdx[0]]-arr2[sortIdx[0]];
            }
        });
        
        
        
        int[][] answer = new int[list.size()][4];
        for (int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}