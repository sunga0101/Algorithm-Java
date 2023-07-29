
import java.io.*;
import java.util.*;

public class Main {
    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int num = Integer.parseInt(s[0]);
        int maxNum = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");

        Map<Integer,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < num; i++) { //  해시맵에 저장
            if (map.containsKey(Integer.parseInt(s[i]))) // n번째
                map.replace // n-1번째의 값 get -> +1 로 replace
                    (Integer.parseInt(s[i]), map.get(Integer.parseInt(s[i])) + 1);
            else
                map.put(Integer.parseInt(s[i]),1); // 첫번째
        }

        ArrayList<Integer> mapList = new ArrayList<>(map.keySet()); // map의 키값을 모두 리스트로 저장
        Collections.sort(mapList,
                (o1, o2) -> Integer.compare(map.get(o2), map.get(o1))); // value 로 내림차순 정렬

        for (Integer key : mapList){
            int times = map.get(key);
            for (int i = 0; i < times; i++) {
                bw.write(key+" ");
            }
        }
        bw.flush();
        br.close();

        // 이터레이터 사용 시
        //        Iterator<Integer> it = mapList.iterator();
        //        while (it.hasNext()) {
        //            Integer element = it.next();
        //            for(int i=0; i<map.get(element); i++){
        //                System.out.print(element+" "); } }

    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}

//        /*
//        9 3
//        1 3 3 3 2 2 2 1 1
//       ->maxNum[1][] 0 0
//               [1]   3 1
//               [2]   3 5
//               [3]   3 2
//        **/
