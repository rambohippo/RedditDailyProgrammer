package dailyprogrammer;

public class E375IncrementDigits {

    public static long incrementDigits(long input) {
        if (Math.abs(input) < 10) {
            return input + 1;
        }

        int sign = Long.signum(input);
        long lastNum = (input % 10) + 1;
        lastNum = (lastNum == 1) ? lastNum * sign : lastNum;
        long positionFactor = (Math.abs(lastNum) < 10) ? 10 : 100;
        long remainingDigits = incrementDigits(input / 10);

        return remainingDigits * positionFactor + lastNum;
    }
}