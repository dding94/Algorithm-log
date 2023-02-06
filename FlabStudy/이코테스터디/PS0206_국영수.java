package 백준23.PS1월;

import java.io.*;
import java.util.*;

public class PS0206_국영수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<People> peoples = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            peoples.add(new People(name, kor, eng, math));
        }

        peoples.sort(
            (o1, o2) -> {
                if (o1.kor == o2.kor) {
                    if (o1.eng == o2.eng) {
                        if (o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.math - o1.math;
                    }
                    return o1.eng - o2.eng;
                }
                return o2.kor - o1.kor;
            }
        );


        StringBuilder sb = new StringBuilder();
        for (People people : peoples) {
            sb.append(people.name).append("\n");
        }

        System.out.println(sb);
    }

    private static class People {

        String name;
        int kor;
        int eng;
        int math;

        public People(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }
}
