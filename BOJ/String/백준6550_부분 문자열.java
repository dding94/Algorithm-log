package 백준.PS10월;

import java.util.*;
import java.io.*;

public class PS1002_6550 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = "Yes";
            char[] chars = sc.next().toCharArray();
            String t = sc.next();

            int start = 0;

            for (int i = 0; i < chars.length; i++) {
                while (true) {
                    if (start >= t.length()) {
                        s = "No";
                        break;
                    }
                    if (chars[i] == t.charAt(start)) {
                        start++;
                        break;
                    } else {
                        start++;
                    }
                }
            }
            System.out.println(s);
        }
    }
}
