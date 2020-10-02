package rybas.factories;

import rybas.linedrawers.GraphicsLineDrawer;
import rybas.linedrawers.LineDrawer;

import java.awt.*;

public class GraphicsFactory implements LineDrawerFactory {
    @Override
    public LineDrawer createLineDrawer(Graphics g) {
        return new GraphicsLineDrawer(g);
    }

    @Override
    public void setType(LineDrawer.Type t) {

    }

    @Override
    public LineDrawer.Type getType() {
        return null;
    }
}
