package rybas.linedrawers;


import rybas.Line;
import rybas.LineDrawer;

import java.awt.*;

public class GraphicsLineDrawer implements LineDrawer {
    private Graphics g;

    public GraphicsLineDrawer(Graphics g) {
        this.g = g;
    }

    @Override
    public void drawLine(Line line) {
        g.drawLine(line.getStart().x, line.getStart().y, line.getEnd().x, line.getEnd().y);
    }
}
