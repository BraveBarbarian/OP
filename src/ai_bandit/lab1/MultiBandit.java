package ai_bandit.lab1;

import java.util.Random;

public class MultiBandit{

    //Array of bandits
    private Bandit[] bandits;
    private static Random random = new Random();

    public MultiBandit(int numberBandits) {
        this.bandits = new Bandit[numberBandits];

        //get one random bandit that is always winning
        int numberWinningBandit = random.nextInt(numberBandits);

        //generate multiple bandits with 1 winning bandit
        for(int i = 0; i < numberBandits; i++) {
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

        for(int i = 0; i < bandits.length; i++) {
            Bandit currentBandit = bandits[i];
            totalProfit += currentBandit.getOverallProfit();
        }

        return totalProfit;
    }

    public double getMeanProfitPerRound() {
        int rounds = getRoundsPlayed();

        //return 0 with no played rounds to avoid /0
        if(rounds == 0) {
            return 0;
        }
        else {
            return getOverallProfit() / rounds;
        }
    }

        public int getRoundsPlayed() {
            int numberRoundsPlayed = 0;

            //get roundsplayed for each bandit and add (I feel like there is a better method)
            for (int i = 0; i < bandits.length; i++) {
                Bandit currentBandit = bandits[i];
                numberRoundsPlayed += currentBandit.getRoundsPlayed();
            }

            return numberRoundsPlayed;
        }

    public double play(int banditIndex) {
        Bandit chosenBandit = bandits[banditIndex];

        double win = chosenBandit.play();

        return win;
    }
}
