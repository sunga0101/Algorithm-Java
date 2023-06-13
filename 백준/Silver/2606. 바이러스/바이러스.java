import java.io.*;
import java.util.Stack;

public class Main {
    static int maxNode, times;
    static int count;
    static boolean[] visited;
    static int[][] edgeMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        maxNode = Integer.parseInt(br.readLine());
        times = Integer.parseInt(br.readLine());

        edgeMap = new int[maxNode + 1][maxNode + 1];
        visited = new boolean[maxNode + 1];
        for (int i = 1; i <= times; i++) {
            String[] s = br.readLine().split(" ");
            int leftNode = Integer.parseInt(s[0]);
            int rightNode = Integer.parseInt(s[1]);
            edgeMap[leftNode][rightNode] = 1;
            edgeMap[rightNode][leftNode] = 1;
        }
        DFS(1);
        bw.write(count+"");
        bw.flush();
        br.close();
    }
    
    public static void DFS(int next){
        Stack<Integer> st = new Stack<>(); // 방문예정인 노드들
        st.push(next);
        visited[next] = true;

        while (!st.isEmpty()) {
            // 다음 갈 노드 탐색
            for (int i = 1; i <= maxNode; i++) {
                if (edgeMap[next][i] == 1 && !visited[i]) {
                    st.push(i);
                    visited[i]=true;
                    count++;
                    DFS(i);
                }
            }
            st.pop();
        }
    }
}

