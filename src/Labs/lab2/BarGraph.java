package Labs.lab2;

import javax.swing.*;
import java.awt.*;

public class BarGraph extends JPanel {

    private int[] counts;

    public BarGraph() {
        counts = new int[]{0, 0, 0, 0, 0, 0, 0};
        counts = new int[]{15, 30, 45, 10, 5, 20, 500};
    }

    public void updateBarGraph(int[] newCounts) {
        this.counts = newCounts;
        repaint();
    }

    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int barWidth = width / (counts.length*2);

        int maxCount = 1;
        for (int count : counts) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        g.setColor(Color.BLACK);
        g.drawLine(20, height - 30, width, height - 30);
        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i < counts.length; i++) {

            int barHeight = (int) (((double) counts[i] / maxCount) * (height - 60)); //height dependant on maxCount, casting to prevent 0 pixel heights
            int x = (i * 2 * barWidth) + barWidth;
            int y = height - 30 - barHeight;
            g.fillRect(x, y, barWidth, barHeight);
            if (counts[i] > 0) {
                g.drawString(String.valueOf(counts[i]), x, y - 5);
            }
        }
    }
}