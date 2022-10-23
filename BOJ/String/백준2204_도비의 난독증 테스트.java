package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1014_2204 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<String> list = new ArrayList<>();

            if (n == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                list.add(br.readLine());
            }

            sb.append(list.stream()
                .sorted((o1, o2) -> o1.toLowerCase().compareTo(o2.toLowerCase()))
                .findFirst().get() + "\n");
        }

        System.out.println(sb);
    }

}
