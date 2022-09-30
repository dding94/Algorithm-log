package 백준.PS9월;

import java.io.*;
import java.util.*;

public class PS0930_9933 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String reverse = new StringBuilder(s).reverse().toString();

            if (list.contains(reverse) || s.equals(reverse)) {
                System.out.println(s.length() + " " + s.charAt(s.length() / 2));
                return;
            } else {
                list.add(s);
            }
        }
    }

}
