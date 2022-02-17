//좋은 수열
package 백준.PS2월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS0217_2661 {

    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        backtracking("");

    }

    static void backtracking(String s) {
        if(s.length() == n){
            System.out.println(s);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (canAns(s + i)) {
                backtracking(s + i);
            }
        }
    }

    static boolean canAns(String s) {
        int len = s.length() / 2;

        for (int i = 1; i <= len; i++) {
            String front = s.substring(s.length() - i * 2, s.length() - i);
            String back = s.substring(s.length() - i);

            if (front.equals(back)) {
                return false;
            }
        }

        return true;
    }
}
