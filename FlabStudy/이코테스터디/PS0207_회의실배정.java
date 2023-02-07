package 백준23.PS1월;

import java.io.*;
import java.util.*;

public class PS0207_회의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(start, end));
        }

        // O(nlogn)
        meetings.sort(
            (o1, o2) -> {
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        );

        int temp = meetings.get(0).end;
        int answer = 1;

        // O(n)
        for (int i = 1; i < n; i++) {
            if (temp <= meetings.get(i).start) {
                temp = meetings.get(i).end;
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static class Meeting {

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
