//감소하는 수
package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0502_1038 {

    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n <= 10){
            System.out.println(n);
            return;
        }else{
            for (int i = 0; i < 10; i++) {
                findAnswer(i, 1);
            }
        }
        Collections.sort(list);

        System.out.println(n >= list.size() ? -1 : list.get(n));
    }

    static void findAnswer(long num, int digit) {
        if(digit > 10){
            return;
        }

        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            findAnswer((num * 10) + i, digit + 1);
        }
    }
}
