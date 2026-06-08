import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numberOfStudents;
        int numberOfSubjects;

        System.out.print("How many students do you have?: ");
        numberOfStudents = input.nextInt();

        System.out.print("How many subjects do they offer?: ");
        numberOfSubjects = input.nextInt();

        String choice = "yes";

        while ((numberOfStudents <= 0 || numberOfSubjects <= 0) && choice.equals("yes")) {

            System.out.println("Invalid input! You must enter at least 1 student and 1 subject.");

            System.out.print("Do you want to continue? (yes/no): ");
            choice = input.next();

            if (choice.equals("yes")) {

                System.out.print("How many students do you have?: ");
                numberOfStudents = input.nextInt();

                System.out.print("How many subjects do they offer?: ");
                numberOfSubjects = input.nextInt();

            } else if (choice.equals("no")) {

                System.out.println("Application closed.");
            } else {

                System.out.println("Invalid choice. Type yes or no only.");
               }
         }

        if (numberOfStudents > 0 && numberOfSubjects > 0 && choice.equals("yes")) {

            int[] scores = new int[numberOfStudents * numberOfSubjects];

            for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {

                System.out.println("Entering scores for Student " + (studentIndex + 1));

            for (int subjectIndex = 0; subjectIndex < numberOfSubjects; subjectIndex++) {

                    System.out.print("Enter score for Subject " + (subjectIndex + 1) + ": ");

                    int score = input.nextInt();

                    while (score < 0 || score > 100) {
                        System.out.print("Score must be between 0 and 100. Try again: ");
                        score = input.nextInt();
                     }

                    scores[studentIndex * numberOfSubjects + subjectIndex] = score;
                 }

                System.out.println("Saving ................................");
                System.out.println("Saved Successfully");
            }

            System.out.println("=================================================");
            System.out.printf("%-12s", "STUDENT");

            for (int subjectIndex = 0; subjectIndex < numberOfSubjects; subjectIndex++) {
                System.out.printf("%-8s", "SUBJECT" + (subjectIndex + 1));
             }

            System.out.printf("%-8s%-8s%n", "TOTAL", "AVERAGE");
            System.out.println("=================================================");

            for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {

                int totalScore = 0;

                System.out.printf("%-12s", "Student " + (studentIndex + 1));

                for (int subjectIndex = 0; subjectIndex < numberOfSubjects; subjectIndex++) {

                    int score = scores[studentIndex * numberOfSubjects + subjectIndex];
                    totalScore += score;

                    System.out.printf("%-8d", score);
                  }

                double averageScore = (double) totalScore / numberOfSubjects;

                if (averageScore == (int) averageScore) {
                    System.out.printf("%-8d%-8d%n", totalScore, (int) averageScore);
                } else {
                    System.out.printf("%-8d%-8.2f%n", totalScore, averageScore);
                 }
            }

            System.out.println("\nSUBJECT SUMMARY");

            for (int subjectIndex = 0; subjectIndex < numberOfSubjects; subjectIndex++) {

                int totalSubjectScore = 0;
                int highestScore = 0;
                int lowestScore = 100;
                int highestScoringStudent = 0;
                int lowestScoringStudent = 0;
                int numberOfPasses = 0;
                int numberOfFails = 0;

                for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {

                    int score = scores[studentIndex * numberOfSubjects + subjectIndex];

                    totalSubjectScore += score;

                    if (score >= 50) {
                        numberOfPasses++;
                    } else {
                        numberOfFails++;
                    }

                    if (score > highestScore) {
                        highestScore = score;
                        highestScoringStudent = studentIndex + 1;
                    }

                    if (score < lowestScore) {
                        lowestScore = score;
                        lowestScoringStudent = studentIndex + 1;
                    }
                }

                System.out.println("Subject " + (subjectIndex + 1));
                System.out.println("Highest scoring student is Student " + highestScoringStudent + " with " + highestScore);
                System.out.println("Lowest scoring student is Student " + lowestScoringStudent + " with " + lowestScore);
                System.out.println("Total subject score is " + totalSubjectScore);

                double averageSubjectScore = (double) totalSubjectScore / numberOfStudents;

                if (averageSubjectScore == (int) averageSubjectScore) {
                    System.out.println("Average subject score is " + (int) averageSubjectScore);
                } else {
                    System.out.printf("Average subject score is %.2f%n", averageSubjectScore);
                }

                System.out.println("Number of passes is " + numberOfPasses);
                System.out.println("Number of fails is " + numberOfFails + "\n");
            }

            System.out.println("=================================================");
            System.out.println("CLASS SUMMARY");

            int bestStudent = 0;
            int worstStudent = 0;
            int maxTotal = 0;
            int minTotal = numberOfSubjects * 100;
            int classTotal = 0;

            for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {

                int studentTotal = 0;

                for (int subjectIndex = 0; subjectIndex < numberOfSubjects; subjectIndex++) {
                    studentTotal += scores[studentIndex * numberOfSubjects + subjectIndex];
                }

                classTotal += studentTotal;

                if (studentTotal > maxTotal) {
                    maxTotal = studentTotal;
                    bestStudent = studentIndex + 1;
                   }

                if (studentTotal < minTotal) {
                    minTotal = studentTotal;
                    worstStudent = studentIndex + 1;
                 }
            }

            System.out.println("Best graduating student is Student " + bestStudent + " with " + maxTotal);
            System.out.println("Worst graduating student is Student " + worstStudent + " with " + minTotal);

            double classAverage = (double) classTotal / numberOfStudents;

            if (classAverage == (int) classAverage) {
                System.out.println("Class average score is " + (int) classAverage);
            } else {
                System.out.println("Class average score is " + classAverage);
            }

            System.out.println("=================================================");
          }

        
     }
}