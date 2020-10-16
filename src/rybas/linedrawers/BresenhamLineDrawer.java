package rybas.linedrawers;

import rybas.pixeldrawers.PixelDrawer;
import rybas.utils.Line;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {
    private Type t;
    private PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.t = Type.DDA;
        this.pd = pd;
    }

    @Override
    public void drawLine(Line line) {
        int x2 = line.getEnd().x;
        int x1 = line.getStart().x;
        int y2 = line.getEnd().y;
        int y1 = line.getStart().y;
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int dx2 = 2 * dx;
        int dy2 = 2 * dy;

        int ix = x1 < x2 ? 1 : -1;
        int iy = y1 < y2 ? 1 : -1;

        int d = 0;
        if (dx >= dy) {
            while (true) {
                pd.setPixel(x1, y1, Color.ORANGE);
                if (x1 == x2)
                    break;
                x1 += ix;
                d += dy2;
                if (d > dx) {
                    y1 += iy;
                    d -= dx2;
                }
            }
        } else {
            while (true) {
                pd.setPixel(x1, y1, Color.ORANGE);
                if (y1 == y2)
                    break;
                y1 += iy;
                d += dx2;
                if (d > dy) {
                    x1 += ix;
                    d -= dy2;
                }
            }
        }
    }

    @Override
    public Type getType() {
        return Type.Briesenham;
    }

    @Override
    public String toString() {
        return "Bresenham line drawer";
    }
}
