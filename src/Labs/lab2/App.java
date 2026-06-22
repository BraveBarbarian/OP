package Labs.lab2;

import javax.swing.*;
import java.awt.*;

public class App {
    public App() {
        JFrame frame = new JFrame("Bandit App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Get Screen Res for Dynamic Size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        frame.setSize(screenSize.width*3/4, screenSize.height*3/4);
        frame.setLocationRelativeTo(null); //place in the middle of the screen
        frame.setVisible(true);
        frame.setResizable(false);

        // Create contents
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        panel1.add(new JButton("Reset Bandits"));
        panel1.add(new JButton("Play 1x"));
        panel1.add(new JButton("Play 10x"));
        panel1.add(new JButton("Play 100x"));
        panel1.add(new JButton("Play 1000x"));
        panel1.add(new JButton("Start"));
        JRadioButton radioButton1 = new JRadioButton("Random Bandit");
        JRadioButton radioButton2 = new JRadioButton("Epsilon-Greedy");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        panel1.add(radioButton1);
        panel1.add(radioButton2);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(3, 1));
        contentPane.add(panel1);
        contentPane.add(new BarGraph());
        contentPane.add(new MoneyOverTime());
        frame.pack();
    }


    public static void main(String[] args) {


        new App();

    }
}
