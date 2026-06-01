package Labs.lab2;

import java.util.Scanner;

public class MultiBanditApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Input from user with Scanner
        double net = 0;
        double price = 1.0;
        int numberBandits = 7;
        System.out.printf("Gambling:\tMulti-Armed Bandit (%d Bandits)\n", numberBandits);
        System.out.printf("Price:\t\t %.2f EUR\n", price);
        System.out.println("How many rounds would you like to play? ");
        int rounds = scanner.nextInt();
        System.out.print("Enter epsilon in [0, 100] percent (typical value: 15) or any other number for random strategy: ");
        double epsilonInput = scanner.nextDouble() / 100.0; //convert to [0,1]

        MultiBandit multiBandit = new MultiBandit(numberBandits);
        MultiBanditSolver solver = new MultiBanditSolver(multiBandit); //

        // Determine strategy
        boolean useEpsilonGreedy = epsilonInput >= 0.0 && epsilonInput <= 1.0;
        if (useEpsilonGreedy) {
            solver.setGreedyEpsilon(epsilonInput);
        }

        System.out.println("Round\t| Bandit\t| Win [EUR]\t\t| Net [EUR]");
        for (int i = 1; i < rounds + 1; i++) {
            int banditIndex;

            if (useEpsilonGreedy) {
                banditIndex = solver.chooseEpsilonGreedy();
            } else {
                banditIndex = solver.chooseRandom();
            }

            double win = multiBandit.play(banditIndex);
            solver.addBanditResponse(banditIndex, win);
            net = multiBandit.getOverallProfit();
            System.out.printf("%5d\t| %5d\t\t| %8.2f\t\t| %8.2f%n", i, banditIndex, win, -net);
        }

        String strategy = useEpsilonGreedy ? "epsilon-greedy (epsilon = " + epsilonInput + ")" : "random";  //either
        System.out.println("\nApplied strategy: " + strategy);
        System.out.println("\nMulti-armed Bandit's statistics :");
        System.out.println("Rounds:\t" + rounds);
        System.out.printf("Profit:\t%.2f (%.2f EUR/round)", net, net / rounds);
    }

}
