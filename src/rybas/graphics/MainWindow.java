package rybas.graphics;

import rybas.graphics.DrawPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private DrawPanel dp;

    public MainWindow() throws HeadlessException {
        dp = new DrawPanel();
        this.add(dp);
    }

}
