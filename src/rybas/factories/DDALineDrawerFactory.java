package rybas.factories;

import rybas.linedrawers.LineDrawer;
import rybas.PixelDrawer;
import rybas.linedrawers.DDALineDrawer;


public class DDALineDrawerFactory implements LineDrawerFactory<PixelDrawer> {
    @Override
    public LineDrawer createLineDrawer(PixelDrawer drawer) {
        return new DDALineDrawer(drawer);
    }
}