package 백준.PS4월;

import java.io.*;

public class PS0419_17609 {

    static char[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <=t; tc++) {
            String s = br.readLine();
            arr = s.toCharArray();
            int left = 0;
            int right = s.length() - 1;
            if(check(left,right)) {
                sb.append(0 + "\n");
                continue;
            }
            if(checkS(left,right)) {
                sb.append(1 + "\n");
            }else {
                sb.append(2 + "\n");
            }

        }
        System.out.println(sb);
    }

    private static boolean check(int left,int right) {
        while(left<=right) {
            if (arr[left] != arr[right]) {//다름
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }

    private static boolean checkS(int left,int right) {
        while(left<=right) {
            if(arr[left]!=arr[right]) {//다름
                boolean a = check(left + 1, right);
                boolean b = check(left, right - 1);
                if(a==false && b==false) {
                    return false;
                }else return true;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
}
