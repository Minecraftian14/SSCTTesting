package logic;

public class M {

    public static int avg(int a, int b) {
        return (a + b) >> 1;
    }

    public static int cut(int i, int mi, int Mi) {
        return Math.max(mi, Math.min(i, Mi));
    }
}
