package Labs.lab2;

public class WheelOfFortune extends Gambling{

    private final int numberFields;
    private final double[] categoryWins;
    private final double[] categoryChances;


    public  WheelOfFortune(double pricePerRound, int[] categoryNumberFields, double[] categoryWins) {
        super("Unnamed WheelofFortune", pricePerRound);
        this.categoryWins = categoryWins;
        this.categoryChances = new double[categoryNumberFields.length];

        int totalFields = 0;
        for (int categoryNumberField : categoryNumberFields) {
            totalFields += categoryNumberField;
        }
        for (int i = 0; i < categoryNumberFields.length; i++) {
            this.categoryChances[i] = categoryNumberFields[i] / (double) totalFields; //cast to prevent integer precision
        }
        this.numberFields = totalFields;
    }

    public int getNumberFields() {
        return numberFields;
    }

    protected double determineWin() {
        double winningField = random.nextDouble();
        double cumulChance = 0.0;

        for (int i = 0; i < categoryChances.length; i++) {
            cumulChance += categoryChances[i]; //add chance to cumulative chance
            if (winningField < cumulChance) { //lookup the Win category
                return categoryWins[i];
            }
        }
        return 0.0; //Fallback
    }
}

