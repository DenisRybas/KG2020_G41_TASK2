package rybas;

import rybas.linedrawers.BriesenhamLineDrawer;
import rybas.linedrawers.DDALineDrawer;
import rybas.linedrawers.GraphicsLineDrawer;
import rybas.linedrawers.WooLineDrawer;
import rybas.pixeldrawers.GraphicsPixelDrawer;
import rybas.utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class DrawPanel extends JPanel implements MouseMotionListener, KeyListener, MouseListener {
    private ArrayList<Line> lines;
    private LineDrawer ld;
    private Point[] points = {new Point(0, 0), new Point(0, 0)};

    public DrawPanel() {
        lines = new ArrayList<>();
        this.setFocusable(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
    }


    @Override
    public void paint(Graphics g) {

        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        ld = new DDALineDrawer(new GraphicsPixelDrawer(bi_g)); //TODO: в зависимости от внешних факторов, какой алгоритм использовать. Использовать порождающие паттерны (по типу абстрактной фабрики)
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.black);
        drawAll(ld);

        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();

    }

    private void drawAll(LineDrawer ld) {
        //DrawUtils.drawSnowflake(ld, getWidth() / 2, getHeight() / 2, 150, 32);
        ld.drawLine(new Line(points[0].x, points[0].y, points[1].x, points[1].y));
        for (Line l : lines) {
            ld.drawLine(l);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        HashMap<Character, LineDrawer> keys = new HashMap<>() {{
            put('b', new BriesenhamLineDrawer());
            put('d', new DDALineDrawer(new GraphicsPixelDrawer(
                    new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB).createGraphics())));
            put('w', new WooLineDrawer());
        }};
        //ld = keys.get(e.getKeyChar());
        //repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiersEx() & KeyEvent.CTRL_MASK) != 0)) {
            lines.remove(lines.size() - 1);
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        points[0] = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Line l = new Line(points[0].x, points[0].y, points[1].x, points[1].y);
        lines.add(l);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        points[1] = e.getPoint();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        points[1] = e.getPoint();
    }
}
