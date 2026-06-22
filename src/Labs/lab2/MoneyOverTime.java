package Labs.lab2;

import javax.swing.*;
import java.awt.*;

public class MoneyOverTime  extends JPanel {
    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw UML diagram
        g.setColor(Color.BLACK);
        g.drawRect(25, 50, 100, 30); // Super class
        g.drawString("JPanel", 55, 70);
        g.drawRect(25, 120, 100, 30); // Sub class
        g.drawString("MyPaintPanel", 40, 140);
        g.drawLine(75, 80, 75, 120); // Arrow
        g.fillPolygon(new int[]{70, 75, 80}, new int[]{90, 80, 90}, 3);
        // Exclamation mark
        g.setColor(Color.RED);
        g.fillRect(202, 70, 12, 42);
        g.fillOval(200, 120, 16, 16);

    }
}
