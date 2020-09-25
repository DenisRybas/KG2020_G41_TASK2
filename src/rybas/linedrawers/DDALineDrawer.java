package rybas.linedrawers;


import rybas.utils.Line;
import rybas.pixeldrawers.PixelDrawer;

import java.awt.*;

public class DDALineDrawer implements LineDrawer {
    private PixelDrawer pd;
    private Type t;

    public DDALineDrawer(PixelDrawer pd) {
        this.t = Type.DDA;
        this.pd = pd;
    }

    @Override
    public void drawLine(Line line) {
        int x1 = line.getStart().x;
        int y1 = line.getStart().y;
        int x2 = line.getEnd().x;
        int y2 = line.getEnd().y;
        double dx = x2 - x1;
        double dy = y2 - y1;
        if (Math.abs(dx) > Math.abs(dy)) {
            if (x1 > x2) {
                int tmp = x1; x1 = x2; x2 = tmp;
                tmp = y1; y1 = y2; y2 = tmp;
            }
            double k = dy / dx;
            for (int j = x1; j <= x2; j++) {
                double i = k * (j - x1) + y1;
                pd.setPixel(j, (int) i, Color.RED);
            }
        } else {
            if (y1 > y2) {
                int tmp = x1; x1 = x2; x2 = tmp;
                tmp = y1; y1 = y2; y2 = tmp;
            }
            double kObr = dx / dy;
            for (int i = y1; i <= y2; i++) {
                double j = kObr * (i - y1) + x1;
                pd.setPixel((int) j, i, Color.RED);
            }
        }
    }

    @Override
    public Type getType() {
        return t;
    }

    @Override
    public String toString() {
        return "DDA line drawer";
    }
}
