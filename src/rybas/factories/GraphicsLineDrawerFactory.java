package rybas.factories;

import rybas.linedrawers.LineDrawer;
import rybas.linedrawers.GraphicsLineDrawer;

import java.awt.*;

public class GraphicsLineDrawerFactory implements LineDrawerFactory {
    private Graphics g;

    public GraphicsLineDrawerFactory(Graphics g) {
        this.g = g;
    }

    @Override
    public LineDrawer createLineDrawer() {
        return new GraphicsLineDrawer(g);
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    @Override
    public LineDrawer.Type getType() {
        return LineDrawer.Type.Graphics;
    }

}
