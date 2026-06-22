package Labs.lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    private BarGraph barGraph;
    private MoneyOverTime moneyOverTime;
    private MultiBandit multiBandit;
    private MultiBanditSolver solver;
    private int[] banditCounts;

    private JRadioButton radioBtnRndm;
    private JRadioButton radioBtnEpsGreedy;

    public App() {
        multiBandit = new MultiBandit(7);
        solver = new MultiBanditSolver(multiBandit);
        solver.setGreedyEpsilon(0.15); // Typischer Wert: 15%
        banditCounts = new int[7];

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

        radioBtnRndm = new JRadioButton("Random bandit  ", true);
        radioBtnEpsGreedy = new JRadioButton("Epsilon-greedy  ");
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
        JButton btnPlay10000 = new JButton("Play 10000x");
        JButton btnStart = new JButton("Start");
        buttonPanel.add(btnReset);
        buttonPanel.add(btnPlay1);
        buttonPanel.add(btnPlay10);
        buttonPanel.add(btnPlay100);
        buttonPanel.add(btnPlay10000);
        buttonPanel.add(btnStart);

        //add nested buttons to top Panel
        topPanel.add(strategySelectionPanel);
        topPanel.add(buttonPanel);
        //TODO: Make Top Panel leftbound and smaller
        topPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, topPanel.getPreferredSize().height));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2, 1));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        barGraph = new BarGraph();
        moneyOverTime = new MoneyOverTime();
        bottomPanel.add(barGraph);
        bottomPanel.add(moneyOverTime);

        //Implementing Button-ActionListener
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                multiBandit = new MultiBandit(7);
                solver = new MultiBanditSolver(multiBandit);
                solver.setGreedyEpsilon(0.15);
                banditCounts = new int[7];

                // Graphen leeren bzw. zurücksetzen
                barGraph.updateBarGraph(banditCounts);
                moneyOverTime.reset();
            }
        });

        btnPlay1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                playRounds(1);
            }
        });

        btnPlay10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                playRounds(10);
            }
        });

        btnPlay100.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                playRounds(100);
            }
        });

        btnPlay10000.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                playRounds(10000);
            }
        });

        contentPane.add(topPanel);
        contentPane.add(bottomPanel);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void playRounds(int rounds) {
        boolean useEpsilonGreedy = radioBtnEpsGreedy.isSelected();

        for (int i = 0; i < rounds; i++) {
            int banditIndex;

            // Strategie auswerten
            if (useEpsilonGreedy) {
                banditIndex = solver.chooseEpsilonGreedy();
            } else {
                banditIndex = solver.chooseRandom();
            }

            // Runde spielen
            double win = multiBandit.play(banditIndex);
            solver.addBanditResponse(banditIndex, win);
            banditCounts[banditIndex]++;

            // Kontostand berechnen: Startkapital (10.0) minus Verlust der Banditen
            double currentMoney = 10.0 - multiBandit.getOverallProfit();
            moneyOverTime.updateMoney(currentMoney);
        }

        // Balkendiagramm nach den Zügen aktualisieren
        barGraph.updateBarGraph(banditCounts);
    }

    static void main() {
        new App();
    }
}

