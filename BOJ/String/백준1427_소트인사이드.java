package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0517_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        char[] chars = n.toCharArray();

        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(new String(chars)).reverse());
    }
}
