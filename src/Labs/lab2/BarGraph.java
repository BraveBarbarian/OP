package Labs.lab2;

import javax.swing.*;
import java.awt.*;

public class BarGraph extends JPanel {
    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Exclamation mark
        g.setColor(Color.RED);
        g.fillRect(202, 70, 12, 42);
        g.fillOval(200, 120, 16, 16);
    }
}
