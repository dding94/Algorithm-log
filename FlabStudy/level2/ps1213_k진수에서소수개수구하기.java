package 에프랩스터디;

public class ps1213_k진수에서소수개수구하기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int result = sol.solution(437674, 3);
        int result = sol.solution(1000000, 3);

        System.out.println(result);
    }

    //에라토스테네스 체 사용 못하는 이유 => 배열의 크기 21억을 넘어가는 수를 체크해야하기 때문에 배열자체를 만들 수 없음
    private static class Solution {

        public int solution(int n, int k) {
            int answer = 0;

            //log(1000000)
            String s = Integer.toString(n, k);

            StringBuilder sb = new StringBuilder();

            //O(13)
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    if (!sb.toString().equals("") && isPrime(sb.toString())) {
                        answer++;
                    }
                    sb.setLength(0);
                } else {
                    sb.append(s.charAt(i));
                }
            }

            if (!sb.toString().equals("") && isPrime(sb.toString())) {
                answer++;
            }

            //토탈 O(100만) + log(1000000)
            return answer;
        }

        private static boolean isPrime(String s) {
            long n = Long.parseLong(s);

            if (n < 2) {
                return false;
            }

            //o(root1조 => 100만)
            for (long i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }

}
