package Labs.lab1;
import java.util.Random;
import java.lang.Math;

public class Bandit {
    private static Random random = new Random();
    private String name;
    private double pricePerRound;
    private double averageWin; //used for µ
    private double stdDevWin; //used for σ
    private double overallProfit;
    private int roundsPlayed;

    public Bandit(String name, double pricePerRound, double averageWin, double stdDevWin) {
        this(pricePerRound, averageWin, stdDevWin);
        this.name = name;
    }

    public Bandit(double pricePerRound, double averageWin, double stdDevWin) {
        this.name = "Unnamed Bandit";
        this.pricePerRound = pricePerRound;
        this.averageWin = averageWin;
        this.stdDevWin = stdDevWin;
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

    private double determineWin() {
       double p = averageWin + stdDevWin * random.nextGaussian();

        if(p <= 0) { //If the win is negative set the win to 0
            return 0;
        }

        return Math.round(p * 10.0)/10.0;
    }
}







