package swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class PanelCard extends JPanel {
    public PanelCard() {
        setOpaque(false);
    }

    @Override

    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 =
        (Graphics2D) grphcs;
        g2.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2.setColor(new Color(0,0,0,20));
        g2.fillRoundRect(
        5,
        5,
        getWidth()-10,
        getHeight()-10,
        25,
        25
        );
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(
        0,
        0,
        getWidth()-10,
        getHeight()-10,
        25,
        25
        );
        super.paintComponent(grphcs);
    }
}
