package rybas.factories;

import rybas.linedrawers.DDALineDrawer;
import rybas.linedrawers.LineDrawer;
import rybas.pixeldrawers.GraphicsPixelDrawer;

import java.awt.*;

public class DDAFactory implements LineDrawerFactory {
    @Override
    public LineDrawer createLineDrawer(Graphics g) {
        return new DDALineDrawer(new GraphicsPixelDrawer(g));
    }

    @Override
    public void setType(LineDrawer.Type t) {

    }

    @Override
    public LineDrawer.Type getType() {
        return null;
    }
}
