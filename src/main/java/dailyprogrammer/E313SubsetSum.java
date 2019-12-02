package dailyprogrammer;

public class E313SubsetSum {

    public static boolean subsetSumToZeroBasic(int[] input) {
        int front = 0;
        int back = input.length - 1;
        int frontValue;
        int backValue;
        int sum;

        while (front < back) {
            frontValue = input[front];
            backValue = input[back];
            sum = frontValue + backValue;

            if (frontValue == 0 || backValue == 0) {
                return true;
            }

            if (sum == 0) {
                return true;
            } else if (sum > 0) {
                back--;
            } else {
                front++;
            }
        }

        return false;
    }
}