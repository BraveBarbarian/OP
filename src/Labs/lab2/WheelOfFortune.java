package Labs.lab2;

public class WheelOfFortune extends Gambling{

    private int numberFields;
    private final double categoryWins[];
    private final double categoryChances[] = {0};


    public  WheelOfFortune(double pricePerRound, int categoryNumberFields[], double categoryWins[]) {
        super("Unnamed WheelofFortune", pricePerRound);
        this.categoryWins = categoryWins;
        int numberCategories = categoryNumberFields.length;
        for(int numberFields : categoryNumberFields) {
            numberFields =+ numberFields;
        }

    }

    public int getNumberFields() {
        return numberFields;
    }


    protected double determineWin() {
        //weighted approach?!?
        //total NumberField approach!?!
        int winningField = random.nextInt(numberFields  + 1);
        //testcase: catNumFiel[15, 10, 4, 1]; catWin[0, 1, 2, 5];
        // total fields = 30
        categoryChances
        for(int i = 0; i <= numberFields; i++) {

        }

        return Math.round(win * 10.0)/10.0;
    }
}
