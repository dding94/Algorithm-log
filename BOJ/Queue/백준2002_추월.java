//추월
package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0608_2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<String> inCar = new LinkedList<>();
        Queue<String> outCar = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            inCar.add(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            outCar.add(br.readLine());
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!inCar.peekFirst().equals(outCar.peek())) {
                ans++;
            }
            inCar.remove(outCar.poll());
        }

        System.out.println(ans);

    }
}
