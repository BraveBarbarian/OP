package Labs.lab1;
import java.util.Scanner;

public class BanditApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //User Input

        Bandit myBandit = new Bandit("Slot Machine", 1.00, 0.80 , 0.20);
        String name = myBandit.getName();
        double price = myBandit.getPricePerRound();

        System.out.println("Gambling:\t One-Armed Bandit");
        System.out.printf("Price:\t\t %.2f EUR%n", price);
        System.out.println("How many rounds would you like to play? ");
        int rounds = scanner.nextInt();
        double profit = 0;

        System.out.println("Round\t| Win [EUR]\t| Net [EUR]");
        for(int i = 0; i < rounds; i++) {
            double win = myBandit.play();
            double net = myBandit.getOverallProfit();
            profit = net;
            System.out.printf("%5d\t| %8.1f\t| %8.1f%n", i+1 , win, net);
        }

        System.out.println("\n" + name + "'s statistics :");
        System.out.println("Rounds:\t" + rounds);
        System.out.printf("Profit:\t%.1f (%.1f EUR/round)", profit, profit/rounds);
    }
}
