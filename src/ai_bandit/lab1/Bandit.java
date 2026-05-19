package ai_bandit.lab1;
import java.util.Random;
import java.lang.Math;

public class Bandit {
    //alternativ über Math.random
    private static Random random = new Random();
    private String name;
    private double pricePerRound;
    private double averageWin; //used for µ
    private double stdDevWin; //used for σ
    private double overallProfit;
    private int roundsPlayed;

    //Constructors with different amounts of Parameters

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

    //Getters

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

        //return 0 if no rounds are played (to prevent /0)
        if (roundsPlayed == 0) {
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
        // Win gets determined by the formula p(x) = 1/sqrt(2PIσ)*exp(-0.5*(x-µ/σ)^2)
        // Equation is divided across multiple lines for better readability
        /* double x = random.nextDouble(); //x as rand number
        double p = 1/Math.sqrt(2*Math.PI*stdDevWin);
        double a = Math.pow((x-averageWin)/stdDevWin, 2);
        p *= Math.exp(-0.5*a); */
        //TODO: Question nextGaussian

       double p = averageWin + stdDevWin * random.nextGaussian();

        //If the win is negative set the win to 0
        if(p <= 0) {
            return 0;
        }

        return Math.round(p * 10.0)/10.0;
    }
}







