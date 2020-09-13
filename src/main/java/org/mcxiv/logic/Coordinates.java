package org.mcxiv.logic;

public class Coordinates {

    private int x, y, mx, my, Mx, My;

    public Coordinates(int x, int y, int mx, int my, int Mx, int My) {
        this.x = x;
        this.y = y;
        this.mx = mx;
        this.my = my;
        this.Mx = Mx;
        this.My = My;
    }

    public Coordinates(int mx, int my, int Mx, int My) {
        this(M.avg(mx, Mx), M.avg(my, My), mx, my, Mx, My);
    }

    public Coordinates() {
        x = y = mx = my = Mx = My = 0;
    }

    public void add(int nx, int ny) {
        if (nx != 0) x = M.cut(x + nx, mx, Mx);
        if (ny != 0) y = M.cut(y + ny, my, My);
    }

    public void set(int x, int y, int mx, int my, int Mx, int My) {
        this.x = x;
        this.y = y;
        this.mx = mx;
        this.my = my;
        this.Mx = Mx;
        this.My = My;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMx() {
        return mx;
    }

    public int getMy() {
        return my;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                ", mx=" + mx +
                ", my=" + my +
                ", Mx=" + Mx +
                ", My=" + My +
                '}';
    }

    public int getWidth() {
        return Mx - mx;
    }
}
