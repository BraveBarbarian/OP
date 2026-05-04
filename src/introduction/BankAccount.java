package introduction;

public class BankAccount {


    public static void main(String[] args) {
        final double moneyGoal = 2000;
        double money = 1000;
        double interest = 1.0035;
        int year = 0;

        while(money <= moneyGoal) {
            money *= interest;
            year++;
            //System.out.println(String.format("Your current balance is: %.4f after %d Years!", money, year));
        }
        System.out.printf("The time it takes to double the money with an interest rate of %.4f is %d Years!%n", interest, year);
    }
}
