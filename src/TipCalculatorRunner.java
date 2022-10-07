import java.util.Scanner;
import java.text.DecimalFormat;

public class TipCalculatorRunner {
    public static void main(String[] args){
       //Ask User for Some Info like how many people and tip percentage
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Tip Calculator!");
        System.out.print("How many people are in your group ? ");
        int numPeople = input.nextInt();
        System.out.print("What's the tip percentage (0-1): ");
        double tipPercentage = input.nextDouble();
        TipCalculator receipt = new TipCalculator(numPeople, tipPercentage);

        //Using While loop to constantly let the user enter a cost until they are done adding all the costs
        int i = 1;
        while  (i == 1){
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end) ");
            double cost = input.nextDouble();
            if (cost == -1) {
                i = -1;
                break;
            }
            receipt.addMeal(cost);

        }
        //Printing out the data using methods in the TipCalculator class and using decimal formatter to round
        DecimalFormat dFormatter = new DecimalFormat("##.##");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Total Bill Before Tip: " + dFormatter.format(receipt.getTotalBillBeforeTip()));
        System.out.println("Tip Percentage: " + (receipt.getTipPercentage() * 100) + "%");
        System.out.println("Total Tip: " + dFormatter.format(receipt.tipAmount()));
        System.out.println("Total Bill With Tip: " + dFormatter.format(receipt.totalBill()));
        System.out.println("Per Person Cost Before Tip: " + dFormatter.format(receipt.perPersonCostBeforeTip()));
        System.out.println("Tip Per Person: " + dFormatter.format(receipt.perPersonTipAmount()));
        System.out.println("Total Cost Per Person: " + dFormatter.format(receipt.perPersonTotalCost()));

    }
}

