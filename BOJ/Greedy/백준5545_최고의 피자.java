package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0623_5545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); //도우 가격
        int b = Integer.parseInt(st.nextToken()); //토핑 가격
        int c = Integer.parseInt(br.readLine()); //도우 열량

        ArrayList<Integer> d = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            d.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(d, Collections.reverseOrder());

        int pizzaPrice = a;
        int calorie = c;
        int ans = calorie / pizzaPrice;

        for (int i = 0; i < n; i++) {
            calorie += d.get(i);
            pizzaPrice += b;

            ans = Math.max(ans, calorie / pizzaPrice);
        }

        System.out.println(ans);
    }
}
