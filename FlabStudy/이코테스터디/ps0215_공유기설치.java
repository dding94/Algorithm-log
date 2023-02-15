package 에프랩스터디.이코테;

import java.io.*;
import java.util.*;

public class ps0215_공유기설치 {

    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int left = 0;
        int right = house[house.length - 1] - house[0];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (wifiCount(mid) >= c) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    private static int wifiCount(int dist) {
        int count = 1;
        int now = house[0];

        for (int i = 1; i < house.length; i++) {
            int next = house[i];

            if (next - now >= dist) {
                count++;
                now = next;
            }
        }

        return count;
    }
}
