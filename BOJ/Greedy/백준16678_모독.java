package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0826_16678 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long count = 0;
        int[] people = new int[n];

        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(people);

        int target = 1;

        for (int i = 0; i < n; i++) {
            if (people[i] >= target) {
                count += people[i] - target;
                target++;
            }
        }

        System.out.println(count);
        
    }
}
