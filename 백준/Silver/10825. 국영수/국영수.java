

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];

        for (int i=0;i<N;i++){
            String[] s = br.readLine().split(" ");
            String name = s[0];
            int kor = Integer.parseInt(s[1]);
            int eng = Integer.parseInt(s[2]);
            int math = Integer.parseInt(s[3]);
            students[i] = new Student(name,kor,eng,math);
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student m1, Student m2) {
                if (m1.kor < m2.kor) {
                    return 1; // 위치 바꿈
                }
                else if (m1.kor == m2.kor) {
                    if (m1.eng > m2.eng) {
                        return 1; // 위치 바꿈
                    }
                    else if (m1.eng == m2.eng) {
                        if (m1.math < m2.math) {
                            return 1; // 위치 바꿈
                        }
                        else if (m1.math == m2.math){
                            return m1.name.compareTo(m2.name);
                        }
                        else return -1;
                    }
                    else return -1;
                }
                else return -1;
            }
        });

        for (int i=0;i<N;i++) {
            bw.write(students[i].name +"\n");
        }
        bw.flush();
        br.close();

    }
}

class Student {
    String name;
    int kor;
    int eng;
    int math;
    public Student(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}
