import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer>scores = readScores("/Users/ufn6978/Boston University/Module 2/scores.txt");
        double avg = calculateAverage(scores);

        // Step 2: calculate statistics
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        // Step 3: write and print report
        for(int score : scores) {
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }
        writeReport(scores, avg, highest, lowest, "report.txt");

    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while((line = reader.readLine()) !=null ) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                try {
                    scores.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid value: " + line);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
            System.out.println();
        }
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        
        for (int score : scores) {
            total += score;

        }
        return total/scores.size();

    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;

            } else if (score >= 70){
                countC++;
            } else if (score >= 60){
                countD++;
            } else {
                countF++;
            }

        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            writer.write("Grade Analysis Report\n");

            writer.write("GRADE REPORT\n");
            writer.write(String.format("Average score: %.2f%n", avg));
            writer.write(String.format("Highest score: %d%n", high));
            writer.write(String.format("Lowest score: %d%n", low));

        
            writer.write("Grade distribution\n");
            writer.write(String.format("A %d%n", countA));
            writer.write(String.format("B %d%n", countB));
            writer.write(String.format("C %d%n", countC));
            writer.write(String.format("D %d%n", countD));
            writer.write(String.format("F %d%n", countF));           
            
            writer.write("\n");


            System.out.println("Grade Analysis Report");
            System.out.println();

            System.out.println("GRADE REPORT");
            System.out.println(String.format("Average score: %.2f%n", avg));
            System.out.println(String.format("Highest score: %d%n", high));
            System.out.println(String.format("Lowest score: %d%n", low));


            System.out.println("Grade distribution");
            System.out.println("A: " + countA);
            System.out.println("B: " + countB);
            System.out.println("C: " + countC);
            System.out.println("D: " + countD);
            System.out.println("F: " + countF);


        } catch (IOException e) {
            System.out.println("Could not write report: " + e.getMessage());
        }

    }
} 