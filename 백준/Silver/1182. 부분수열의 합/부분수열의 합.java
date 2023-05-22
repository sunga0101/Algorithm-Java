import java.io.*;

public class Main {
    static int S, N;
    static int[] arr; // 숫자 배열
    static int[] res = new int[1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); // 정수 개수
        S = Integer.parseInt(s[1]); // targetSum
        arr = new int[N+1]; // 입력된 수열로 만든 배열
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(s[i]);
        func(0,0);
        if (S == 0) res[0] -= 1; // targetSum = 0의 경우 공집합의 경우의수 제거
        bw.write(res[0]+"");
        bw.flush();
        br.close();
    }

    // N개 중에 K개의 합이 S이어야 한다
    public static void func(int k,int currentSum){
        if (k == N) {// 최대 N개의 합까지 봤으면 종료
            if (currentSum == S)   res[0]++;
            return;
        }

        // k=0 ~ N 까지 ++
        func(k+1,currentSum);// 제외하는 경우
        func(k+1,currentSum+arr[k]); //포함하는 경우
    }
}