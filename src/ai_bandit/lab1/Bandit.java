package ai_bandit.lab1;
import java.util.Random;
import java.lang.Math;

public class Bandit {
    //alternativ über Math.random
    private static Random random = new Random();

    private String name;
    private double pricePerRound;
    private double averageWin;
    private double stdDevWin;
    private double overallProfit;
    private int roundsPlayed;

    public Bandit(String name, double pricePerRound, double averageWin, double stdDevWin) {
        this(pricePerRound, averageWin, stdDevWin);
        this.name = name;
    }

    public Bandit(double pricePerRound, double averageWin, double stdDevWin) {
        this();
        this.pricePerRound = pricePerRound;
        this.averageWin = averageWin;
        this.stdDevWin = stdDevWin;
    }

    public Bandit() {

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
        //TODO: calculate Mean Profit per Round, if no rounds played, return 0
        double meanProfit = 1;
        return meanProfit;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public double play() {
        /*TODO: Die Methode play() spielt eine Runde und aktualisiert die entsprechenden Attribute der
        TODO: Spielstatistiken. Sie ermittelt den Gewinn durch Aufruf der nachfolgend beschriebenen Methode
        TODO: determineWin() und gibt diesen zurück.
         */
        return 0;
    }

    private double determineWin() {
        // Win gets determined by the formula p(x) = 1/sqrt(2PIσ)*exp(-0.5*(x-µ/σ)^2)
        // Equation is divided across multiple lines for better readability
        double x = random.nextDouble(); //x as rand number
        double p = 1/Math.sqrt(2*Math.PI*stdDevWin);
        double a = Math.pow((x-averageWin)/stdDevWin, 2);
        p *= Math.exp(-0.5*a);
        return p;
    }



}







