package Labs.lab2;

public class Bandit extends  Gambling{
    private final double averageWin; //used for µ
    private final double stdDevWin; //used for σ

    public Bandit(String name, double pricePerRound, double averageWin, double stdDevWin) {
        super(name, pricePerRound);
        this.averageWin = averageWin;
        this.stdDevWin = stdDevWin;
    }

    public Bandit(double pricePerRound, double averageWin, double stdDevWin) {
        super("Unnamed Bandit", pricePerRound);
        this.averageWin = averageWin;
        this.stdDevWin = stdDevWin;
    }

    protected double determineWin() {
        double win = averageWin + stdDevWin * random.nextGaussian();

        if(win <= 0) { //If the win is negative set the win to 0
            return 0;
        }

        return Math.round(win * 10.0)/10.0;
    }
}







