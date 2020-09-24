package rybas.factories;

import rybas.linedrawers.LineDrawer;
import rybas.linedrawers.GraphicsLineDrawer;

import java.awt.*;

public class GraphicsLineDrawerFactory implements LineDrawerFactory<Graphics> {

    @Override
    public LineDrawer createLineDrawer(Graphics drawer) {
        return new GraphicsLineDrawer(drawer);
    }
}
