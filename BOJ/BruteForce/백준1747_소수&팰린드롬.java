//소수&팰린드롬
package 백준.PS6월;

import java.util.Scanner;

public class PS0601_1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = 0;
        for (int i = n; ; i++) {
            if (isPrime(i)) {
                if(isPalindrome(i)){
                    ans = i;
                    break;
                }
            }
        }

        System.out.println(ans);
    }

    private static boolean isPrime(int n) {
        if (n < 2){
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPalindrome(int n) {
        String temp = String.valueOf(n);

        for (int i = 0; i < temp.length() / 2; i++) {
            if (temp.charAt(i) != temp.charAt(temp.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
