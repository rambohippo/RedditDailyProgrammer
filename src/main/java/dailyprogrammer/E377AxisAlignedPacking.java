package dailyprogrammer;

import java.util.stream.*;

public class E377AxisAlignedPacking {

    public static int fit1(int crateX, int crateY, int boxX, int boxY) {
        return (crateX / boxX) * (crateY / boxY);
    }


    public static int fit2(int crateX, int crateY, int boxX, int boxY) {
        return Math.max(fit1(crateX, crateY, boxX, boxY),
            fit1(crateX, crateY, boxY, boxX));
    }


    public static int fit3(int crateX, int crateY, int crateZ,
        int boxX, int boxY, int boxZ) {
        return IntStream.of(fit3_single(crateX, crateY, crateZ, boxX, boxY, boxZ),
            fit3_single(crateX, crateY, crateZ, boxX, boxZ, boxY),
            fit3_single(crateX, crateY, crateZ, boxY, boxX, boxZ),
            fit3_single(crateX, crateY, crateZ, boxY, boxZ, boxX),
            fit3_single(crateX, crateY, crateZ, boxZ, boxX, boxY),
            fit3_single(crateX, crateY, crateZ, boxZ, boxY, boxX)).max().getAsInt();
    }


    private static int fit3_single(int crateX, int crateY, int crateZ,
        int boxX, int boxY, int boxZ) {
        return (crateX / boxX) * (crateY / boxY) * (crateZ / boxZ);
    }
}