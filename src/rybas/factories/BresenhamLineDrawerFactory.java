package rybas.factories;

import rybas.linedrawers.LineDrawer;

public class BresenhamLineDrawerFactory implements LineDrawerFactory {
    @Override
    public LineDrawer createLineDrawer() {
        return null;
    }

    @Override
    public LineDrawer.Type getType() {
        return LineDrawer.Type.Briesenham;
    }
}
