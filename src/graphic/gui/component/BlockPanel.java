package graphic.gui.component;

import java.awt.*;

import javax.swing.JPanel;

public class BlockPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.GRAY);
        g.drawRect(500, 500, 40, 40);
    }
}
