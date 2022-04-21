package 백준.PS4월;

import java.io.*;
import java.util.*;

public class PS0421_1094 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());

        int stick = 64;
        int temp = 0;
        int count = 0;
        int result = x;

        while (true) {

            if (x == 64) {
                count++;
                break;
            }

            stick /= 2; //
            if (stick <= x) {
                temp += stick;
                count++;
                if (result == temp) {
                    break;
                }
                x -= stick;
            }

        }
        System.out.println(count);
    }

}



