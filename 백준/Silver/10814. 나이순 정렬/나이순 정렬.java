import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static class Person{
        int age;
        String name;
        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }


    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 인원수
        Person[] people = new Person[n];

        // 클래스 생성, 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(),(" "));
            int pAge = Integer.parseInt(st.nextToken());
            String pName = st.nextToken();
            people[i] = new Person(pAge, pName);
        }

        // 정렬
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person s1, Person s2) {
                return s1.age - s2.age; // 리턴값 작은 순으로 정렬 
            }

        });

        //출력
        for (int i = 0; i < people.length; i++) {
            bw.write(people[i].age+" "+people[i].name+"\n");
        }
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}

