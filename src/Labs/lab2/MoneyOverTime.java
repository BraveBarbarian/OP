package Labs.lab2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoneyOverTime extends JPanel {

    private List<Double> moneyHistory;

    public MoneyOverTime() {
        moneyHistory = new ArrayList<>();
        moneyHistory.add(10.0);
    }

    public void updateMoney(double currentMoney) {
        moneyHistory.add(currentMoney);
        repaint();
    }

    public void reset() {
        moneyHistory.clear();
        moneyHistory.add(10.0);
        repaint();
    }

    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        double maxMoney = 10.0;
        double minMoney = 0.0;

        for (double money : moneyHistory) {
            if (money > maxMoney) maxMoney = money;
            if (money < minMoney) minMoney = money;
        }

        double range = maxMoney - minMoney;
        if (range == 0) range = 10.0;

        // 2. Position der Nulllinie (Y-Koordinate) berechnen
        int zeroY = (int) (height - ((0 - minMoney) / range) * height);

        // Nulllinie zeichnen
        g.setColor(Color.BLACK);
        g.drawLine(0, zeroY, width, zeroY);
        g.drawString("Available money", 10, 20);

        int numPoints = moneyHistory.size();

        double xStep = (double) width / Math.max(1, (numPoints - 1));

        for (int i = 0; i < numPoints; i++) {
            double currentMoney = moneyHistory.get(i);

            // X-Koordinate für den aktuellen Punkt
            int x = (int) (i * xStep);

            // Y-Koordinate für den aktuellen Punkt
            int y = (int) (height - ((currentMoney - minMoney) / range) * height);

            if (currentMoney >= 0) {
                g.setColor(Color.green);
            } else {
                g.setColor(Color.red);
            }

            g.drawLine(x, zeroY, x, y);
        }
    }
}