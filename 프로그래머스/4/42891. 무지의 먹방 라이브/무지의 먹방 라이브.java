// 모든 음식 총 섭취량이 k보다 작,같으면 -> 리턴 -1
// 섭취 시간이 적게 걸리는 음식부터 큐에 삽입.
// (이 음식이 기준이 되어야 다른 음식들도 동일한 만큼 섭취 가정 가능)
// 최소 섭취의 음식을 다 먹은 시간
// 2 x 10^13 -> long을 사용해야 함


import java.util.*;
class Solution {
    public int solution(int[] food_times, long k) {
        long foodSum = 0; // 모든 음식 총 섭취시간
        for (int i=0;i<food_times.length;i++){
            foodSum+=food_times[i]; // 모든 음식 총 섭취시간
        }
        
        if (k>=foodSum) return -1; // 시간안에 섭취 마친 경우
        
        // 우선순위큐 저장
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i=0;i<food_times.length;i++){
            pq.offer(new Food(food_times[i],i+1)); // 각 시간, i번째
        }
        
        long total = 0; // 먹기 위해서 사용한 시간
        long previous = 0; // 직전에 다 먹은 음식 시간
        long n = food_times.length; // 남은 음식 갯수
        
        while(k>= total+(pq.peek().time-previous)*n){
           // k>= 지금까지 먹은 총 시간 + 현재 음식을 다 먹는데 걸리는 시간
           //                = (원래 걸리는 시간 - 미리 먹은 시간)*남은 갯수
            long now = pq.poll().time; // 이 음식 먹는데 원래 걸리는 시간
            total += (now-previous)*n; // 먹음
            n--; // 한 개 다 먹음
            previous = now; // 다음 음식에서 뺄 시간
        }
        
        ArrayList<Food> result = new ArrayList<>();
        while(!pq.isEmpty()){ // 시간안에 못먹은 음식이 있는 상황
            result.add(pq.poll());             
        }
               
        Collections.sort(result, new Comparator<Food>() {

            @Override
            public int compare(Food a, Food b){
                return Integer.compare(a.idx, b.idx); // 음식 순서 오름차순
            }
            
        });

        return result.get((int) ((k-total)%n)).idx;

    }
    
    
    // Food 클래스
    class Food implements Comparable<Food>{
        int time; // 각 음식을 먹는데 걸리는 시간
        int idx; // 각 음식의 순서
        public Food(int time, int idx){
            this.time = time;
            this.idx = idx;
        }
        @Override
        public int compareTo(Food other){
            return Integer.compare(this.time, other.time);
        }
    }
}