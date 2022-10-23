package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1020_19598 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            rooms.add(new Room(start, end));
        }

        Collections.sort(rooms, (o1, o2) -> o1.start - o2.start);

        Queue<Room> q = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);

        for (int i = 0; i < n; i++) {
            if (!q.isEmpty()) {
                Room room = q.peek();
                if (room.end <= rooms.get(i).start) {
                    q.poll();
                }
            }
            q.add(rooms.get(i));
        }
        System.out.println(q.size());
    }

    private static class Room {

        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
