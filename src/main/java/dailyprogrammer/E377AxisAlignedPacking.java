package dailyprogrammer;

public class E377AxisAlignedPacking {

    public static int fit1(int crateX, int crateY, int boxX, int boxY) {
        return (crateX / boxX) * (crateY / boxY);
    }


    public static int fit2(int crateX, int crateY, int boxX, int boxY) {
        return Math.max(fit1(crateX, crateY, boxX, boxY), fit1(crateX, crateY, boxY, boxX));
    }
}