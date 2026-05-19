package ai_bandit.lab1;

import java.util.Random;
import java.util.Scanner;

public class MultiBanditApp {

    public static void main(String[] args) {
        //Input from user with Scanner
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        double net = 0;
        double profit = 0;
        double price = 1.0;


        System.out.println("Gambling:\tMulti-Armed Bandit");
        System.out.printf("Price:\t\t %.2f EUR%n", price);

        System.out.println("How many rounds would you like to play? ");
        int rounds = scanner.nextInt();


        System.out.println("How many bandits would you like to play on?");
        int numberBandits = scanner.nextInt();
        MultiBandit multiBandit = new MultiBandit(numberBandits);

        System.out.println("Round\t| Bandit\t| Win [EUR]\t\t| Net [EUR]");
        for (int i = 1; i < rounds + 1; i++) {
            //choosing random bandit
            int banditIndex = random.nextInt(numberBandits);

            double win = multiBandit.play(banditIndex);

            net = multiBandit.getOverallProfit();
            profit = net;

            System.out.printf("%5d\t| %5d\t\t| %8.1f\t\t| %8.1f%n", i, banditIndex, win, net);

        }

        System.out.println("Multi-armed Bandit's statistics :");
        System.out.println("Rounds:\t" + rounds);
        System.out.printf("Profit:\t%.1f (%.1f EUR/round)", net, net / rounds);
    }
        //TODO: make number of bandits start from 1 instead of 0
        //TODO: Make display if more or 10 bandits played on better
}
