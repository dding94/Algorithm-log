package 백준.PS11월;

import java.io.*;
import java.util.*;

public class PS1108_5585 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = Arrays.asList(500, 100, 50, 10, 5, 1);

        int n = 1000 - Integer.parseInt(br.readLine());
        int count = 0;


        for (Integer money : list) {
            int temp = 0;
            if (n - money >= 0) {
                count += (n / money);
                temp = n / money;
                n -=  temp * money;
            }
        }

        System.out.println(count);
    }
}
