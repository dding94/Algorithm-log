package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0803_5635 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<People> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            list.add(new People(name, day, month, year));
        }

        Collections.sort(list, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o1.year == o2.year) {
                    if (o1.month == o2.month) {
                        return o1.day - o2.day;
                    }
                    return o1.month - o2.month;
                }
                return o1.year - o2.year;

            }
        });

        System.out.println(list.get(list.size() - 1).name);
        System.out.println(list.get(0).name);

    }

    static class People {
        String name;
        int day;
        int month;
        int year;

        public People(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
}
