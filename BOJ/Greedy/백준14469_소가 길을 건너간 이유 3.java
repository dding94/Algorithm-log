package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1017_14469 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Cow> cows = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrival = Integer.parseInt(st.nextToken());
            int check = Integer.parseInt(st.nextToken());

            cows.add(new Cow(arrival, check));
        }

        Collections.sort(cows, (o1, o2) -> {
            if (o1.arrival == o2.arrival) {
                return o1.check - o2.check;
            }
            return o1.arrival - o2.arrival;
        });

        int ans = 0;
        for (int i = 0; i < n; i++) {
            Cow cow = cows.get(i);

            if (cow.arrival > ans) {
                ans = cow.arrival + cow.check;
            } else {
                ans += cow.check;
            }
        }

        System.out.println(ans);
    }

    private static class Cow {

        int arrival;
        int check;

        public Cow(int arrival, int check) {
            this.arrival = arrival;
            this.check = check;
        }
    }


}
