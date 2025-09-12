import java.util.Scanner;

public class Casiño {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int money;
        double[][] denomination = new double[12][2];

        denomination[0][0] = 1000;
        denomination[1][0] = 500;
        denomination[2][0] = 200;
        denomination[3][0] = 100;
        denomination[4][0] = 50;
        denomination[5][0] = 20;
        denomination[6][0] = 10;
        denomination[7][0] = 5;
        denomination[8][0] = 1;
        denomination[9][0] = 0.25;
        denomination[10][0] = 0.10;
        denomination[11][0] = 0.05;

        System.out.print("Enter the amount of money: ");
        money = scanner.nextInt();
        scanner.nextLine();

        for(int x = 0; x < denomination.length; x++){
            if(denomination[x][0] > money){
                denomination[x][1] = 0;
                continue;
            }
            double denomination_equivalent = money / denomination[x][0];
            denomination[x][1] = denomination_equivalent;
        }
        System.out.println("Denomination:");
        for(int x = 0; x < denomination.length; x++) {
            if (x < 9) {
                System.out.println((int) denomination[x][0] + ": " + (int) denomination[x][1]);
            } else {
                System.out.println(denomination[x][0] + ": " + (int) denomination[x][1]);
            }
        }


        scanner.close();

    }
}
