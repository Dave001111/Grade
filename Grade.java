import java.util.Scanner;

public class grade {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("How many students Do you have?: ");
        int students = input.nextInt();

        System.out.print("How many subjects do they offer?: ");
        int subjects = input.nextInt();

        int[] scores = new int[students * subjects];

        for (int index = 0; index < students; index++) {
            System.out.println("Entering scores for student " + (index + 1));

            for (int subindex = 0; subindex < subjects; subindex++) {
                System.out.print("Enter score for subject " + (subindex + 1) + ": ");

                int score = input.nextInt();

                while (score < 0 || score > 100) {
                    System.out.print("Score must be 0 - 100. Try again: ");
                    score = input.nextInt();
                }

                scores[index * subjects + subindex] = score;
            }

            System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Saved Successfully");
        }
    }
}