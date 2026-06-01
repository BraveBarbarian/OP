package Labs.lab2;

import java.util.Random;

public abstract class Gambling {
    protected static Random random = new Random();
    private final String name;
    private final double pricePerRound;
    private double overallProfit;
    private int roundsPlayed;

    public Gambling(String name, double pricePerRound) {
        this.name = name;
        this.pricePerRound = pricePerRound;
    }

    public String getName() {
        return name;
    }

    public double getPricePerRound() {
        return pricePerRound;
    }

    public double getOverallProfit() {
        return overallProfit;
    }

    public double getMeanProfitPerRound() {

        if (roundsPlayed == 0) { //return 0 if no rounds are played (to prevent /0)
            return 0;
        }
        else {
            return overallProfit/ roundsPlayed;
        }
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public double play() {
        double win = determineWin();

        this.overallProfit += this.pricePerRound - win;
        this.roundsPlayed++;
        return win;
    }

    abstract protected double determineWin();


}
