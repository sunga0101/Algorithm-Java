

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<n;i++){
            q.add(i+1); // 1,2,3,4,5,6,7
        }
        bw.write("<");
        while(q.size()>1){
            for (int i=0;i<k-1;i++){
                q.add(q.poll());
            } // 3,4,5,6,7,1,2
            bw.write(q.poll()+", ");
        }
        bw.write(q.poll()+">");
        bw.flush();
        br.close();
    }
}