package rybas.factories;

import rybas.linedrawers.LineDrawer;

public interface LineDrawerFactory<T> {

    LineDrawer createLineDrawer(T drawer);
}
