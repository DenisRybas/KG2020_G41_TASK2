package rybas.factories;

import rybas.linedrawers.LineDrawer;

public interface LineDrawerFactory {
    LineDrawer createLineDrawer();
    LineDrawer.Type getType();
}
