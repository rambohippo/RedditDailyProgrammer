package dailyprogrammer;

public class E377AxisAlignedPacking {

    public static int fit1(int crateX, int crateY, int boxX, int boxY) {
        return (crateX / boxX) * (crateY / boxY);
    }
}