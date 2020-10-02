package rybas.factories;

import rybas.linedrawers.*;
import rybas.pixeldrawers.GraphicsPixelDrawer;

import java.awt.*;

public class LDFactory implements LineDrawerFactory {
    private LineDrawer.Type t;

    @Override
    public LineDrawer createLineDrawer(Graphics g) {
        switch (t) {
            case Graphics -> {
                return new GraphicsLineDrawer(g);
            }
            case Briesenham -> {
                return new BresenhamLineDrawer(new GraphicsPixelDrawer(g));
            }
            case DDA -> {
                return new DDALineDrawer(new GraphicsPixelDrawer(g));//провайдер
            }
            case Wu -> {
                return new WuLineDrawer(new GraphicsPixelDrawer(g));
            }
        }
        return null;
    }

    @Override
    public LineDrawer.Type getType() {
        return t;
    }

    @Override
    public void setType(LineDrawer.Type t) {
        this.t = t;
    }
}
