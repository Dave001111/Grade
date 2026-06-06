import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("How many students do you have?: ");
        int numberOfStudents = input.nextInt();

        System.out.print("How many subjects do they offer?: ");
        int numberOfSubjects = input.nextInt();

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
            int lowestScore = 101;
            int highestScoringStudent = -1;
            int lowestScoringStudent = -1;
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

        int hardestSubject = -1;
        int easiestSubject = -1;
        int maximumNumberOfFailures = -1;
        int minimumNumberOfFailures = numberOfStudents + 1;

        int maximumNumberOfPasses = -1;

        int overallHighestScore = -1;
        int overallLowestScore = 101;
        int overallHighestScoringStudent = -1;
        int overallHighestScoringSubject = -1;
        int overallLowestScoringStudent = -1;
        int overallLowestScoringSubject = -1;

        for (int subjectIndex = 0; subjectIndex < numberOfSubjects; subjectIndex++) {

            int numberOfFailures = 0;
            int numberOfPasses = 0;

            for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {

                int score = scores[studentIndex * numberOfSubjects + subjectIndex];

                if (score >= 50) {
                    numberOfPasses++;
                } else {
                    numberOfFailures++;
                }

                if (score > overallHighestScore) {
                    overallHighestScore = score;
                    overallHighestScoringStudent = studentIndex + 1;
                    overallHighestScoringSubject = subjectIndex + 1;
                }

                if (score < overallLowestScore) {
                    overallLowestScore = score;
                    overallLowestScoringStudent = studentIndex + 1;
                    overallLowestScoringSubject = subjectIndex + 1;
                }
            }

            if (numberOfFailures > maximumNumberOfFailures) {
                maximumNumberOfFailures = numberOfFailures;
                hardestSubject = subjectIndex + 1;
            }

            if (numberOfPasses > maximumNumberOfPasses) {
                maximumNumberOfPasses = numberOfPasses;
                easiestSubject = subjectIndex + 1;
            }
        }

        System.out.println("The hardest subject is Subject " + hardestSubject +
                " with " + maximumNumberOfFailures + " failures");

        System.out.println("The easiest subject is Subject " + easiestSubject +
                " with " + maximumNumberOfPasses + " passes");

        System.out.println("The overall highest score is Student " + overallHighestScoringStudent +
                " in Subject " + overallHighestScoringSubject + " with " + overallHighestScore);

        System.out.println("The overall lowest score is Student " + overallLowestScoringStudent +
                " in Subject " + overallLowestScoringSubject + " with " + overallLowestScore);

        System.out.println("=================================================");

        int bestGraduatingStudent = -1;
        int worstGraduatingStudent = -1;
        int maximumStudentTotal = -1;
        int minimumStudentTotal = numberOfSubjects * 100 + 1;
        int classTotalScore = 0;

        for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {

            int studentTotalScore = 0;

            for (int subjectIndex = 0; subjectIndex < numberOfSubjects; subjectIndex++) {
                studentTotalScore += scores[studentIndex * numberOfSubjects + subjectIndex];
            }

            classTotalScore += studentTotalScore;

            if (studentTotalScore > maximumStudentTotal) {
                maximumStudentTotal = studentTotalScore;
                bestGraduatingStudent = studentIndex + 1;
            }

            if (studentTotalScore < minimumStudentTotal) {
                minimumStudentTotal = studentTotalScore;
                worstGraduatingStudent = studentIndex + 1;
            }
        }

        System.out.println("=================================================");
        System.out.println("CLASS SUMMARY");
        System.out.println("Best graduating student is Student " + bestGraduatingStudent +
                " with " + maximumStudentTotal);

        System.out.println("Worst graduating student is Student " + worstGraduatingStudent +
                " with " + minimumStudentTotal);

        double classAverageScore = (double) classTotalScore / numberOfStudents;

        if (classAverageScore == (int) classAverageScore) {
            System.out.println("Class average score is " + (int) classAverageScore);
        } else {
            System.out.println("Class average score is " + classAverageScore);
        }

        System.out.println("=================================================");
    }
}