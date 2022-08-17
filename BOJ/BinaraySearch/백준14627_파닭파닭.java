package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0817_14627 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long s = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        long answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < s; i++) {
            list.add(Integer.parseInt(br.readLine()));
            answer += list.get(i);
        }
        Collections.sort(list);

        //파의길이를 조절해서 만들 수 있는 치킨의 양이 5가 되어야함
        long left = 1;
        long right = list.get(list.size() - 1);

        while (left <= right) {
            long mid = (left + right) / 2;

            long temp = 0;
            for (int i = 0; i < s; i++) {
                temp += list.get(i) / mid;
            }

            if (temp >= c) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer - right * c);
    }
}
