
import java.io.*;
import java.util.*;

 /*
 * i) 첫번째 원소이면? 그냥 뽑기
 * ii) n/2보다 작으면 ? 2번 연산 왼쪽으로 이동
 * iii) n/2보다 크면 ? 3번
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> queue = new LinkedList<>();
        int last = 0;
        int cnt=0;
        int iNum = sc.nextInt();
        int target = sc.nextInt();

        int[] targetArr = new int[target];
        for (int i = 1; i <= iNum; i++) {
            queue.offer(i);
        }

        // 순서대로 뽑아낼 원소배열
        for (int i = 0; i < target; i++) {
            targetArr[i]=sc.nextInt();
        }

        for (int i = 0; i < targetArr.length; i++) {
            int half;
            /*  사이즈 홀짝 구분해서 조건 맞춰주기  */
            if (queue.size() % 2 ==0) {
                half = queue.size() / 2 - 1;
            } else {
                half = queue.size() / 2;
            }


            int n = queue.indexOf(targetArr[i]); // 큐에 있는 타겟 원소가 현재 있는 위치

            if (n <= half){
                for (int j = 0; j < n; j++) {
                    queue.offerLast(queue.pollFirst()); //2번연산
                    cnt++;
                }
            }
            else {
                for (int j = 0; j < queue.size() - n; j++) {
                    queue.offerFirst(queue.pollLast()); //3번연산
                    cnt++;
                }
            }
            queue.pollFirst(); // 1번연산
        }
        System.out.println(cnt);
    }
}