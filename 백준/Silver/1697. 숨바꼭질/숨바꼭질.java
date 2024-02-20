

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;
    static int n,k;

    public static void main(String[] args) throws IOException {
        visited = new boolean[100002];
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); // 시작 지점
        k = Integer.parseInt(s[1]); // 목표값

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n,0));
        visited[n] = true;

        while(!q.isEmpty()){
            Node poll = q.poll();
            int pos = poll.pos;
            int cnt = poll.cnt;
            if (pos== k){
                bw.write(cnt+"");
                break;
            }

            if (pos<100000 && !visited[pos+1]) {
                q.offer(new Node(pos+1,cnt+1)); // 방법1
                visited[pos+1]=true;
            }
            if (pos>0 && !visited[pos-1]) {
                q.offer(new Node(pos-1,cnt+1)); // 방법2
                visited[pos-1]=true;
            }
            if (pos<=50000 && !visited[pos*2]) {
                q.offer(new Node(pos*2,cnt+1)); // 방법3
                visited[pos*2]=true;
            }
        }
        bw.flush();
        br.close();
    }

    public static class Node{
        int pos;
        int cnt;
        public Node(int pos, int cnt){
            this.pos = pos;
            this.cnt = cnt;
        }

    }
}
