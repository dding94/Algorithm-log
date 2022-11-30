package 에프랩스터디;


public class ps1130_키패드누르기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");


    }

    private static class Solution {
        static StringBuilder sb = new StringBuilder();
        public String solution(int[] numbers, String hand) {
            Finger finger = new Finger(hand);
            String answer = "";

            for (int i = 0; i < numbers.length; i++) {
                int selectNumber = numbers[i];

                if (selectNumber == 1 || selectNumber == 4 || selectNumber == 7) {
                    sb.append("L");
                    finger.left = selectNumber;
                }

                if (selectNumber == 3 || selectNumber == 6 || selectNumber == 9) {
                    sb.append("R");
                    finger.right = selectNumber;
                }

                if (selectNumber == 2 || selectNumber == 5 || selectNumber == 8 || selectNumber == 0) {
                    if (selectNumber == 0) {
                        selectNumber = 11;
                    }

                    String choice = choiceFinger(selectNumber, finger);

                    if (choice.equals("right")) {
                        finger.right = selectNumber;
                        sb.append("R");
                    }

                    if (choice.equals("left")) {
                        finger.left = selectNumber;
                        sb.append("L");
                    }
                }
            }

            return sb.toString();
        }

        private static String choiceFinger(int selectNumber, Finger finger) {
            int left = Math.abs(selectNumber - finger.left);
            int leftDiff = (left / 3) + (left % 3);

            int right = Math.abs(selectNumber - finger.right);
            int rightDiff = (right / 3) + (right % 3);

            if (leftDiff == rightDiff) {
                return finger.useHand;
            }

            return leftDiff > rightDiff ? "right" : "left";
        }


        private static class Finger {
            int left = 10;
            int right = 12;
            String useHand;

            public Finger(String useHand) {
                this.left = left;
                this.right = right;
                this.useHand = useHand;
            }
        }
    }
}
