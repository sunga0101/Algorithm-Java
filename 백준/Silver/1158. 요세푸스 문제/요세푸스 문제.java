

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<N;i++)
            q.offer(i+1); // 1부터 시작
        bw.write("<");
        while (q.size()>1){
            for (int i=0;i<K-1;i++){
                q.offer(q.poll());
            }
            bw.write(q.poll()+", ");
        }
        bw.write(q.poll()+">");
        bw.flush();
        br.close();

    }
}