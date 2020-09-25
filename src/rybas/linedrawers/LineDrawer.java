package rybas.linedrawers;

import rybas.utils.Line;

public interface LineDrawer {
    enum Type {
        Briesenham,
        DDA,
        Graphics,
        Wu
    }
    void drawLine(Line line);
    Type getType();
}
