package Labs.lab2;
import java.util.Random;

public class MultiBanditSolver {
    private static final Random random = new Random();
    private final MultiBandit bandits;
    private final int[] counts;
    private final double[] wins; //wins - costPerRound
    private double epsilon;

    public MultiBanditSolver(MultiBandit bandits) {
        this.bandits = bandits;
        this.counts = new int[bandits.getNumberBandits()];
        this.wins = new double[bandits.getNumberBandits()];
    }

    public void setGreedyEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public void addBanditResponse(int banditIndex, double win)  {
        counts[banditIndex]++;
        wins[banditIndex] += win;
    }

    public double getAverageWin(int banditIndex) {
        if (counts[banditIndex] == 0) { //for BanditIndex 0
            return 0;
        }

        return wins[banditIndex] / counts[banditIndex];
    }

    public int chooseRandom() {
        return random.nextInt(bandits.getNumberBandits());
    }

    public int chooseGreedy() {
        int bestBanditIndex = 0;
        double bestAverageWin = getAverageWin(0);

        for (int i = 1; i < bandits.getNumberBandits(); i++) {
            double currentAverageWin = getAverageWin(i);

            if (currentAverageWin > bestAverageWin) {
                bestAverageWin = currentAverageWin;
                bestBanditIndex = i;
            }
        }

        return bestBanditIndex;
    }

    public int chooseEpsilonGreedy() {
        if (random.nextDouble() < epsilon) {
            return chooseRandom();
        } else {
            return chooseGreedy();
        }
    }


}

