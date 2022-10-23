package 백준.PS9월;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class PS0904_2870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<BigInteger> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("\\D");

            for (int j = 0; j < split.length; j++) {
                if (!split[j].equals("")) {
                    list.add(new BigInteger(split[j]));
                }
            }
        }

        Collections.sort(list);

        for (BigInteger num : list) {
            sb.append(num + "\n");
        }

        System.out.println(sb);
    }

}
