package rybas.graphics;

import rybas.utils.DrawUtils;
import rybas.utils.Line;
import rybas.factories.*;
import rybas.linedrawers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements MouseMotionListener, KeyListener, MouseListener {
    private ArrayList<Line> lines;
    private Point[] points = {new Point(0, 0), new Point(0, 0)};
    private LineDrawerFactory f;

    private enum State {
        DeleteLines,
        Paint,
        ChangeLineDrawer;
    }
    State state = State.Paint;

    public DrawPanel() {
        lines = new ArrayList<>();
        f = new LDFactory();
        f.setType(LineDrawer.Type.Graphics);
        this.setFocusable(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();

//        current.createLineDrawer(g);
        LineDrawer ld = f.createLineDrawer(bi_g);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.black);
        bi_g.drawString(ld.toString(), 0, getFontMetrics(getFont()).getHeight());
        drawAll(ld);

        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();
    }

    private void drawAll(LineDrawer ld) {
        DrawUtils.drawSnowflake(ld, getWidth() / 2, getHeight() / 2, 150, 32);
        if (state == State.Paint) {
            ld.drawLine(new Line(points[0].x, points[0].y, points[1].x, points[1].y));
        }
        for (Line l : lines) {
            ld.drawLine(l);
        }
        state = State.Paint;
    }

//    static private HashMap<Character, LineDrawerFactory> mmm = new HashMap<>();
//    static {
//        mmm.put('g', new GraphicsFactory());
//        mmm.put('d', new DDAFactory());
//    }


//    LineDrawerFactory current = null;
    @Override
    public void keyTyped(KeyEvent e) {
        state = State.ChangeLineDrawer;
//        current = mmm.getOrDefault(e.getKeyChar(), null);
        if (e.getKeyChar() == 'b') {
            lines.clear();
            f.setType(LineDrawer.Type.Briesenham);
        } else if (e.getKeyChar() == 'd') {
            lines.clear();
            f.setType(LineDrawer.Type.DDA);
        } else if (e.getKeyChar() == 'g') {
            lines.clear();
            f.setType(LineDrawer.Type.Graphics);
        } else if (e.getKeyChar() == 'w') {
            lines.clear();
            f.setType(LineDrawer.Type.Wu);
        }
        repaint();
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            if (lines.size() != 0) {
                state = State.DeleteLines;
                lines.remove(lines.size() - 1);
                repaint();
            }
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
