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

        int zeroY = (int) (height - ((0 - minMoney) / range) * height);

        g.setColor(Color.black);
        g.drawLine(0, zeroY, width, zeroY);

        int numPoints = moneyHistory.size();
        double spaceBetweenPoints = Math.max(50.0, numPoints - 1);
        double xStep = (double) width / spaceBetweenPoints;

        for (int i = 0; i < numPoints; i++) {
            double currentMoney = moneyHistory.get(i);

            int x = (int) (i * xStep);
            int y = (int) (height - ((currentMoney - minMoney) / range) * height);

            if (currentMoney >= 0) {
                g.setColor(Color.green);
            } else {
                g.setColor(Color.red);
            }

            g.drawLine(x, zeroY, x, y);
        }

        double currentMoney = moneyHistory.get(numPoints - 1);
        String infoText = String.format("Available money: %.2f €", currentMoney);
        g.setColor(new Color(255, 255, 255, 220)); //rgb to set opacity
        g.fillRect(5, 5, 180, 25);
        g.setColor(Color.black);
        g.drawString(infoText, 10, 22);
    }
}

