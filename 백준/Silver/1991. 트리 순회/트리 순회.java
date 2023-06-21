import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    private static int nodes, N;
    private static String[][] arr; // 이진트리를 표현하기 위한 배열
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    //  {0,1,2,3,4,5,6,7,8,9,10,11 }
    public void setArr(String[][] arr) {
        this.arr = arr;
        this.nodes = arr.length;
    }

    // 전위순외 V-> L-> R
    // preorder(1);=>   V -> preorder(L) -> preorder(R)

    public void traversePreorder(String node) throws IOException{
        for (int i = 0; i < N; i++) {
            if(arr[i][0].equals(node)) {
                bw.write(arr[i][0]); // 내 자신 방문
                if (!arr[i][1].equals(".")) this.traversePreorder(arr[i][1]); // Left 자식 방문 모두 하고
                if (!arr[i][2].equals("."))  this.traversePreorder(arr[i][2]); // Right 자식 방문
            }
        }
    }


    public void traverseInorder(String node) throws IOException{
        for (int i = 0; i < N; i++) {
            if(arr[i][0].equals(node)) {
                if (!arr[i][1].equals(".")) this.traverseInorder(arr[i][1]); // Left 자식 방문 모두 하고
                bw.write(arr[i][0]); // 내 자신 방문
                if (!arr[i][2].equals("."))  this.traverseInorder(arr[i][2]); // Right 자식 방문
            }
        }
    }

    public void traversePostorder(String node) throws IOException {
        for (int i = 0; i < N; i++) {
            if(arr[i][0].equals(node)) {
                if (!arr[i][1].equals(".")) this.traversePostorder(arr[i][1]); // Left 자식 방문 모두 하고
                if (!arr[i][2].equals("."))  this.traversePostorder(arr[i][2]); // Right 자식 방문
                bw.write(arr[i][0]); // 내 자신 방문
            }
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new String[N][3];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = s[0];
            arr[i][1] = s[1];
            arr[i][2] = s[2];
        }

        Main tree = new Main();
        tree.setArr(arr);
        tree.traversePreorder(arr[0][0]); // 처음 방문점 root node
        bw.write("\n");
        tree.traverseInorder(arr[0][0]); //  중간 방문점 root node
        bw.write("\n");
        tree.traversePostorder(arr[0][0]); // 마지막 방문점 root node

        bw.flush();
        br.close();
    }
}
