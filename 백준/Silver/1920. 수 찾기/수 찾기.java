

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] nArr = new int[n];
        for (int i=0;i<n;i++){
            nArr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(nArr); // 오름차순 정렬
        int m = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");
        int[] mArr = new int[m];
        for (int i=0;i<m;i++){
            mArr[i] = Integer.parseInt(s[i]);
            BS(0,n-1,nArr,mArr[i]);
        }

        bw.flush();
        br.close();
    }

    public static void BS(int s, int e, int[] arr, int target) throws IOException {
        int mid = (s+e)/2;
        if (s>e){ // 과정렬
            bw.write(0+"\n");
        }
        else if (arr[mid]==target){
            bw.write(1+"\n");
        }
        else if (arr[mid]<target){
            BS(mid+1,e,arr,target);
        }
        else // (arr[mid]>target)
            BS(s,mid-1,arr,target);

    }

}
