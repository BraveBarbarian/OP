package Labs.lab2;

import java.util.Random;

public class MultiBandit{

    //Array of bandits
    private Bandit[] bandits;
    private static Random random = new Random(); //can somehow be deleted?

    public MultiBandit(int numberBandits) {
        this.bandits = new Bandit[numberBandits];
        int numberWinningBandit = random.nextInt(numberBandits);    //get one random bandit that is always winning


        for(int i = 0; i < numberBandits; i++) { //generate multiple bandits with 1 winning bandit
            double mu = 0.0;

            //check if i is the number of the winning Bandit
            if(i == numberWinningBandit) { //mu from range 1.1 to 1.3
                mu = 1.1 + (0.2 * random.nextDouble());
            }
            else { //mu in range 0.5 to 0.8
                mu = 0.5 + (0.3 * random.nextDouble());
            }

            this.bandits[i] = new Bandit("Bandit " + i, 1.0, mu, 1.0);
        }
    }

    public int getNumberBandits() {
        //using length to call number of bandits for other functions
        return bandits.length;
    }

    public double getPricePerRound() {

        //can use index 0 because the price is same for each
        return bandits[0].getPricePerRound();
    }

    public double getOverallProfit() {
        double totalProfit = 0;

        for (Bandit bandit : bandits) {
            totalProfit += bandit.getOverallProfit();
        }

        return totalProfit;
    }

    public double getMeanProfitPerRound() {
        int rounds = getRoundsPlayed();

        if(rounds == 0) {   //return 0 with no played rounds to avoid /0
            return 0;
        }
        else {
            return getOverallProfit() / rounds;
        }
    }

        public int getRoundsPlayed() {
            int numberRoundsPlayed = 0;
            for (Bandit bandit : bandits) {
                numberRoundsPlayed += bandit.getRoundsPlayed();
            }

            return numberRoundsPlayed;
        }

    public double play(int banditIndex) {
        return bandits[banditIndex].play();
    }
}
