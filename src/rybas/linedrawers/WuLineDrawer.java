package rybas.linedrawers;


import rybas.pixeldrawers.PixelDrawer;
import rybas.utils.Line;
import java.awt.*;

public class WuLineDrawer implements LineDrawer {
    private Type t;
    private PixelDrawer pd;
    private Color c = Color.BLACK;

    public WuLineDrawer(PixelDrawer pd) {
        t = Type.Wu;
        this.pd = pd;
    }

    @Override
    public void drawLine(Line line) {
        int y2 = line.getEnd().y;
        int x2 = line.getEnd().x;
        int y1 = line.getStart().y;
        int x1 = line.getStart().x;

        boolean steep = Math.abs(y1 - y2) > Math.abs(x1 - x2);
        if (steep) {
            int temp = x1; x1 = y1; y1 = temp;
            temp = x2; x2 = y2; y2 = temp;
        }

        if (x1 > x2) {
            int temp = x1; x1 = x2; x2 = temp;
            temp = y1; y1 = y2; y2 = temp;
        }

        double dx = x2 - x1;
        double dy = y2 - y1;
        
        double gradient = dy / dx;
        double y = y1 + gradient;
        for (int x = x1 + 1; x < x2; ++x) {
            int intY = (int) y;
            pd.setPixel(
                    steep ? intY + 1 : x, steep ? x : intY + 1,
                    new Color(0, 0, 0, (float)  (y - intY))
            );
            pd.setPixel(
                    steep ? intY : x, steep ? x : intY,
                    new Color(0, 0, 0, (float)  (1 - (y - intY)))
            );
            y += gradient;
        }
    }

    @Override
    public Type getType() {
        return t;
    }

    @Override
    public String toString() {
        return "Wu line drawer";
    }
}
