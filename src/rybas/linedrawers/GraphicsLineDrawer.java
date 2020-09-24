package rybas.linedrawers;


import rybas.utils.Line;

import java.awt.*;

public class GraphicsLineDrawer implements LineDrawer {
    private Graphics g;
    private Type t;
    public GraphicsLineDrawer(Graphics g) {
        this.t = Type.Graphics;
        this.g = g;
    }

    @Override
    public void drawLine(Line line) {
        g.drawLine(line.getStart().x, line.getStart().y, line.getEnd().x, line.getEnd().y);
    }

    @Override
    public Type getType() {
        return t;
    }

    @Override
    public String toString() {
        return "Graphics line drawer";
    }
}
