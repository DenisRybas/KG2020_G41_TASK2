package rybas.factories;

import rybas.linedrawers.LineDrawer;

import java.awt.*;

public interface LineDrawerFactory {
    LineDrawer createLineDrawer(Graphics g);
    void setType(LineDrawer.Type t);
    LineDrawer.Type getType();
}
