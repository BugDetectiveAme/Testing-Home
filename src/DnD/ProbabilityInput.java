package DnD;

import java.util.Scanner;

public class ProbabilityInput {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter modifier: ");
        int mod = Integer.parseInt(scan.nextLine());
        System.out.print("Enter limit: ");
        int limit = Integer.parseInt(scan.nextLine());
        float probability = 0;
        for (int i=1;i<=20;++i) {
            if (probability == 0 && i+mod < limit) {
                probability = ((float) 1/20);
            } else if (i+mod < limit) {
                probability = probability + (float) 1/20;
            }
        }
        System.out.println("Probability " + (int) Math.floor(probability*100)  + "%");
    }
}
