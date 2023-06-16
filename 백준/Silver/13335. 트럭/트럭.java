
/*
*  TODO
*   상황 -> Queue 두개로 표현, 1단위시간마다 체크하는 것 -> while문 (한 번 반복에 1초 증가)
*   Queue 두개가 변하는 것 확인하면서 조건 체크하기
*   1. 다리를 하나의 Queue로 생각한다, 건너지 못한 트럭 리스트를 하나의 Queue로 생각한다.
*   2. 1초 ++ : while (건너지 못한 트럭이 존재하는 동안)
*   3. 1초별 상황 : 걸리는 시간++, 브릿지큐의 맨 앞 poll(), 다리위 트럭 무게합-=poll()
*   4. 그 후 브릿지 큐의 맨 뒤를 채워야하는데, 만약 (다리위 트럭 무게합 + 건널 순서의 트럭 무게) <= 다리의 최대하중
*       맞다면? -> 트럭이 다리 위로 올라가도록.
*           큐 : 브릿지큐.offer(현재트럭)
*           무게 : 다리위 트럭 무게합 += 건널 순서의 트럭 무게
*       아니라면? -> 1초는 지났으나 무게는 변함없고 트럭은 건너지 않아야함
*           큐 : 브릿지큐.offer(0)
*           무게 : 다리위 트럭 무게합 그대로
 *
 * */
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        // 데이터 입력
        int N = Integer.parseInt(s[0]); // 전체 N개의 트럭
        int dist = Integer.parseInt(s[1]); // 다리의 길이
        int limitW = Integer.parseInt(s[2]); // 다리의 최대하중

        // 다리를 하나의 Queue로, 건너지 못한 트럭 리스트를 하나의 Queue로 생각
        Queue<Integer> truckQ = new LinkedList<>();
        Queue<Integer> bridgeQ = new LinkedList<>();
        for (int i = 0; i < dist; i++) 
            bridgeQ.offer(0); // 다리 길이만큼 0으로 채움
        
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++)  // 각 트럭 weight 채움
            truckQ.offer(Integer.parseInt(s[i]));
        
        
        int onBridgeSum = 0; // 다리 위 트럭 무게 sum
        int time = 0; // 걸린 시간

        // 1초마다 반복
        while (!truckQ.isEmpty()){ // 트럭이 다 도착할 때까지
            time++;
            onBridgeSum -= bridgeQ.poll(); // 맨 앞 pop하고 한칸씩 땡김

            if (onBridgeSum + truckQ.peek() <= limitW) {
                // 다리에 트럭 추가
                onBridgeSum += truckQ.peek();
                bridgeQ.offer(truckQ.poll());
            }
            else // 다리 공백으로 채움
                bridgeQ.offer(0);
        }

        // 현재 -> 마지막 트럭이 막 다리 건너기 시작하는 상황
        // time에 건너는 시간 더해줘야 함
        time += dist;
        System.out.println(time);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
