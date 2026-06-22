package Labs.lab2;

import javax.swing.*;
import java.awt.*;

public class App {

    public App() {
        JFrame frame = new JFrame("Bandit App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //get Screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        frame.setSize(screenSize.width*3/4, screenSize.height*3/4);
        frame.setLocationRelativeTo(null);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //margin

        JPanel strategySelectionPanel = new JPanel();
        strategySelectionPanel.setLayout(new BoxLayout(strategySelectionPanel, BoxLayout.Y_AXIS));
        strategySelectionPanel.setBorder(BorderFactory.createTitledBorder("Selection strategy:"));

        JRadioButton radioBtnRndm = new JRadioButton("Random bandit  ", true);
        JRadioButton radioBtnEpsGreedy = new JRadioButton("Epsilon-greedy  ");
        ButtonGroup group = new ButtonGroup();
        group.add(radioBtnRndm);
        group.add(radioBtnEpsGreedy);
        strategySelectionPanel.add(radioBtnRndm);
        strategySelectionPanel.add(radioBtnEpsGreedy);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        JButton btnReset = new JButton("Reset bandits");
        JButton btnPlay1 = new JButton("Play 1x");
        JButton btnPlay10 = new JButton("Play 10x");
        JButton btnPlay100 = new JButton("Play 100x");
        JButton btnStart = new JButton("Start");
        buttonPanel.add(btnReset);
        buttonPanel.add(btnPlay1);
        buttonPanel.add(btnPlay10);
        buttonPanel.add(btnPlay100);
        buttonPanel.add(btnStart);

        //add nested buttons to top Panel
        topPanel.add(strategySelectionPanel);
        topPanel.add(buttonPanel);
        //TODO: Make Top Panel leftbound and smaller
        topPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, topPanel.getPreferredSize().height));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2, 1));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        BarGraph barGraph = new BarGraph();
        MoneyOverTime moneyOverTime = new MoneyOverTime();
        bottomPanel.add(barGraph);
        bottomPanel.add(moneyOverTime);

        contentPane.add(topPanel);
        contentPane.add(bottomPanel);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    static void main() {
        new App();
    }
}