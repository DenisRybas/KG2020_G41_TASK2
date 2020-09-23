package rybas;

import java.awt.*;

public class Line {
    private int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Point getStart() {
        return new Point(x1, y1);
    }

    public Point getEnd() {
        return new Point(x2, y2);
    }
}
