import java.util.Scanner;

public class ChocolateDistribution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = input.nextInt();
        System.out.print("Enter number of children: ");
        int numberOfChildren = input.nextInt();
        
        int eachChildGets = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;

        System.out.println("The number of chocolates each child gets is " + eachChildGets +
                           " and the number of remaining chocolates is " + remainingChocolates);
    }
}
