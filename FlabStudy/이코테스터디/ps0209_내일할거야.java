package 에프랩스터디.이코테;

import java.io.*;
import java.util.*;

public class ps0209_내일할거야 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Subject> subjects = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            subjects.add(new Subject(day, end));
        }

        subjects.sort((o1, o2) -> o2.end - o1.end);

        int temp = subjects.get(0).end;

        for (int i = 0; i < n; i++) {
            Subject now = subjects.get(i);

            if (temp > now.end) {
                temp = now.end;
            }
            temp -= now.day;
        }

        System.out.println(temp);
    }

    private static class Subject {

        int day;
        int end;

        public Subject(int day, int end) {
            this.day = day;
            this.end = end;
        }
    }

}
