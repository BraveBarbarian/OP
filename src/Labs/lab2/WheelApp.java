package Labs.lab2;

import java.util.Scanner;

public class WheelApp {

    static void main() {

        Scanner scanner = new Scanner(System.in); //User Input
        WheelOfFortune myWheel = new WheelOfFortune(1.00, new int[]{15, 10, 4, 1}, new double[]{0, 1, 2, 5});
        int numberFields = myWheel.getNumberFields();
        double price = myWheel.getPricePerRound();

        System.out.println("Gambling:\t Wheel of Fortune");
        System.out.printf("Price:\t\t %.2f EUR\n", price);
        System.out.printf("Fields: %d\n", numberFields);
        System.out.println("How many rounds would you like to play? ");
        int rounds = scanner.nextInt();
        double profit = 0;

        System.out.println("Round\t| Win [EUR]\t| Net [EUR]");
        for(int i = 0; i < rounds; i++) {
            double win = myWheel.play();
            double net = myWheel.getOverallProfit();
            profit = net;
            System.out.printf("%5d\t| %8.1f\t| %8.1f\n", i+1 , win, -net);
        }

        System.out.println("\n Wheel of Fortune statistics :");
        System.out.println("Rounds:\t" + rounds);
        System.out.printf("Profit:\t%.1f (%.1f EUR/round)", profit, profit/rounds);
    }

}
