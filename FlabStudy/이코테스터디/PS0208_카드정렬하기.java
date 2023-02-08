package 백준23.PS1월;

import java.io.*;
import java.util.*;
public class PS0208_카드정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (q.size() > 1) {
            Integer cardOne = q.poll();
            Integer cardTwo = q.poll();

            answer += (cardOne + cardTwo);
            q.add(cardOne + cardTwo);

        }

        System.out.println(answer);

    }

}
