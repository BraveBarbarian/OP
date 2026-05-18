package ai_bandit.lab1;
import java.util.Scanner;

public class BanditApp {

    public static void main(String[] args) {

        //Input from user with Scanner
        Scanner scanner = new Scanner(System.in);


        //Constructing first bandit
        Bandit myBandit = new Bandit("Slotty", 1.00, 0.80 , 0.20);

        String name = myBandit.getName();
        double price = myBandit.getPricePerRound();
        //TODO: Question, why does printf work and println not
        System.out.println("Gambling:\t One-Armed Bandit");
        System.out.printf("Price:\t\t %.2f EUR%n", price);

        System.out.println("How many rounds would you like to play? ");
        int rounds = scanner.nextInt();

        double profit = 0;
        //Print table as in the example
        System.out.println("Round\t| Win [EUR]\t| Net [EUR]");
        for(int i = 0; i < rounds; i++) {
            double win = myBandit.play();
            double net = myBandit.getOverallProfit();
            profit = net;
            System.out.printf("%d\t| %.1f\t\t| %.1f%n", i+1 , win, net);
        }

        System.out.println("\n" + name + "'s statistics :");
        System.out.println("Rounds:\t" + rounds);
        System.out.printf("Profit:\t%.1f (%.1f EUR/round)", profit, profit/rounds);
    }
}
