
import java.io.*;
import java.util.*;

public class Main {
    static List<ArrayList> QList = new LinkedList<>(); // 톱니바퀴 리스트
    static int[] rightArr = new int[4];
    static int[] leftArr = new int[4];
    static int times,target,dir; // 회전횟수, 회전톱니, 회전방향
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s;
        int sum = 0;

        // 데이터 입력 0,1,2,3 순서대로 톱니바퀴 입력
        for (int i = 0; i < 4; i++) {
            ArrayList<int[]> list = new ArrayList<>();
            QList.add(list); // 맨 앞 : 12시방향 극, 맨 뒤 : 11시방향 극
            s = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                if (j==2) rightArr[i] = Integer.parseInt(s[j]);
                if (j==6) leftArr[i] = Integer.parseInt(s[j]);
                QList.get(i).add(Integer.parseInt(s[j])); // N극은 0, S극은 1
            }
        }
        times = Integer.parseInt(br.readLine());
        for (int i = 0; i < times; i++) {
            s = br.readLine().split(" ");
            target = Integer.parseInt(s[0]);
            dir = Integer.parseInt(s[1]); // 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향
            rotate(target,dir);
            for (int j = 0; j < 4; j++) { //왼오 배열 업데이트
                rightArr[j]= Integer.parseInt(QList.get(j).get(2).toString());
                leftArr[j]= Integer.parseInt(QList.get(j).get(6).toString());
            }
        }
        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(QList.get(i).get(0).toString()) == 1){
                sum= sum + (2<<i)/2;
            }
        }
        bw.write(sum+"");
        bw.flush();
        br.close();
     }

     public static void rotate(int target, int dir){
         int pos = target-1; // 톱니 순서
         int resDir; // 반환받은 방향

         // 1.일단 타겟기어 회전하기
         if (dir == 1){ // 1을 2로, 2를 3으로,,, 7을 0으로
             moveClock(QList.get(pos)); // 시계방향
         } else if (dir == -1) { //7을 6으로, 1을 0으로, 0을 7로
             moveAntiClock(QList.get(pos));
         }

//       2. 회전 전 기어 left right 보고 양쪽체크
         if (pos==0){
             resDir = check(0, 1,dir);
             resDir = check(1, 2, resDir);
             check(2, 3, resDir);

         }
         else if (pos == 1){
             check(1, 0, dir);
             resDir = check(1, 2, dir );
             check(2, 3,resDir);
         }
         else if (pos == 2){
             check(2, 3, dir);
             resDir = check(2, 1, dir);
             check(1, 0, resDir);
         }
         else { // pos == 3
             resDir = check(3, 2, dir);
             resDir = check(2, 1, resDir);
             check(1, 0, resDir);
         }
     }



   public static int check(int currentPos, int nextPos, int currentDir) {
        // current 로부터 next 의 방향을 결정, current의 방향 넘겨줌
        int nextDir = 0;

        // 옆 기어 방향 정해주기
        if (currentPos < nextPos) { // current의 right와 next의 left 비교
            if (rightArr[currentPos] != leftArr[nextPos]){ // 다른 극
                nextDir = currentDir*(-1); //반대 방향
            }
        }
        else if (currentPos > nextPos) { // current의 left와 next의 right 비교
            if (leftArr[currentPos] != rightArr[nextPos]){ // 다른 극
                nextDir = currentDir*(-1); //반대 방향
            }
        }

        // 옆 기어 업데이트
        if (nextDir == 0){ // 앞 기어가 (안움직임)0이었거나, 극이 같음
            return nextDir; // 안움직일것
        }
        else if (nextDir == 1) { // 시계
            moveClock(QList.get(nextPos));
        } else if (nextDir == -1) {
            moveAntiClock(QList.get(nextPos)); // 반시계 방향
        }
        return nextDir;
    }

    public static void moveClock(ArrayList arr){  // 1을 2로, 2를 3으로,,, 7을 0으로
        arr.add(0,arr.get(arr.size()-1)); // 7을 0으로
        arr.remove(arr.size()-1);
    }
    public static void moveAntiClock(ArrayList arr){  // 1을 2로, 2를 3으로,,, 7을 0으로
        arr.add(arr.get(0)); // 0을 7뒤에 추가
        arr.remove(0);
    }
}