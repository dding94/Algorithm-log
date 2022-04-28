package 백준.PS4월;

import java.io.*;
import java.util.*;

public class PS0428_1269 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<Integer> hs = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aNum = Integer.parseInt(st.nextToken());
        int bNum = Integer.parseInt(st.nextToken());
        int count = 0;

        StringTokenizer a = new StringTokenizer(br.readLine());
        for(int i=0; i<aNum; i++) {
            hs.add(Integer.parseInt(a.nextToken()));
        }

        StringTokenizer b = new StringTokenizer(br.readLine());
        for(int i=0; i<bNum; i++) {
            int value = Integer.parseInt(b.nextToken());
            if(hs.contains(value)) {
                count++;
            }
            else {
                hs.add(value);
            }
        }

        System.out.println((String.valueOf(aNum + bNum - count * 2)));

    }

} 