package 백준.PS9월;

import java.io.*;
import java.util.*;

public class PS0906_20365 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> bList = new ArrayList<>();
        List<String> rList = new ArrayList<>();

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, "R");

        while (st.hasMoreTokens()) {
            bList.add(st.nextToken());
        }

        st = new StringTokenizer(s, "B");

        while (st.hasMoreTokens()) {
            rList.add(st.nextToken());
        }

        System.out.println(rList.size() >= bList.size() ? bList.size() + 1 : rList.size() + 1);
    }

}
