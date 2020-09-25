package rybas.factories;

import rybas.linedrawers.LineDrawer;
import rybas.pixeldrawers.PixelDrawer;
import rybas.linedrawers.DDALineDrawer;


public class DDALineDrawerFactory implements LineDrawerFactory {
    private PixelDrawer p;

    public DDALineDrawerFactory(PixelDrawer p) {
        this.p = p;
    }

    @Override
    public LineDrawer createLineDrawer() {
        return new DDALineDrawer(p);
    }

    @Override
    public LineDrawer.Type getType() {
        return LineDrawer.Type.DDA;
    }
}