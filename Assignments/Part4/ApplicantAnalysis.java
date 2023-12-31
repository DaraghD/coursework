//DARAGH DOWNES 22351159
//CAYLUM HURLEY 22356363
//DARRAGH QUINN 22359621
//JOE CONSIDINE 22344977

import java.util.*;
import java.io.*;

/*
 * This program reads applicant grades from a CSV (Comma Separated Values) file and calculates
 * each applicants points total. To use the program you need to specify the CSV filename and the
 * cutoff value. Use the following format
 *
 *             ApplicantAnalysis filepath cutoff
 *
 * If the filepath contains spaces then enclose it in quotation marks (e.g. "The filename has spaces.CSV").
 */
public class ApplicantAnalysis {

    public static void main(String[] args) {

        if(args.length == 2) {
            // File containg applicant information
            String filePath = args[0];
            // Course points cutoff
            int cutoff = Integer.parseInt(args[1]);
            // TreeMap stores the applicant Number and associated points total (i.e. ID ---> Points)
            TreeMap<String,Integer> candidateScores = calculateApplicantScores(filePath);
            if(candidateScores != null) {
                // LinkedList stores a list of applicantNumbers containing the applicants with Points >= cutoff
                LinkedList<String> chosenApplicants = select(candidateScores,cutoff);
                // Uses LinkedList toString method to display list of successful applicantNumbers
                if(chosenApplicants != null) {
                    System.out.println(chosenApplicants);
                    String expectedOutput = "[21219388, 21236556, 21270186, 21321912, 21483698, 21497189, 21745566, 21767774, 21803928, 21905621, 21942586]";
                    if(chosenApplicants.toString().compareTo(expectedOutput) != 0) {
                        System.out.println("Output is NOT correct");
                    }
                } else {
                    System.out.println("There are no applicants with sufficient points for the course!");
                }
            } else {
                System.out.println("There are no applicants for the course!");
            }
        } else {
            // Program command line is incorrect
            System.out.println("Command Line format error.");
            System.out.println("Use 'ApplicantAnalysis filepath cutoff'");
            System.out.println("For example - ApplicantAnalysis LM999.CSV 390'");
        }
    }
    public static LinkedList<String> select(TreeMap<String,Integer> candidateScores,int cutoff){
        LinkedList<String> studentsCutoff = new LinkedList<String>(); //list of student ids that are >= cutoff

        for(Map.Entry<String, Integer> student : candidateScores.entrySet()){
            String studentID = student.getKey();
            int points = student.getValue();

            if(points >= cutoff){
                studentsCutoff.add(studentID);
            }
        }
        if(studentsCutoff.isEmpty()){
            return null;
        }
        return studentsCutoff;
    }

    public static int pointsScore(String[] subjectGrades){
        ArrayList<Integer> studentPoints = new ArrayList<Integer>();
        String[] grades = {"H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "O1", "O2", "O3", "O4", "O5", "O6", "O7", "O8"};
        int[] points = {100,     88,   77,   66,   56,   46,   37,    0,   56,   46,   37,   28,   20,   12,    0,    0};
        for(String grade : subjectGrades){
            int temp = Arrays.asList(grades).indexOf(grade);
            studentPoints.add(points[temp]);
        }
        studentPoints.sort(Collections.reverseOrder());
        //System.out.println(studentPoints);
        //System.out.println("DEBUG \n \n \n \n");

        int gradesTotal = 0;
        for(int i=0; i<6; i++){
            gradesTotal = gradesTotal + studentPoints.get(i);
        }
        return gradesTotal;
    }

    public static TreeMap<String,Integer> calculateApplicantScores(String filePath) {
        try {
            // Create a File object to access the file
            File fileHandle = new File(filePath);
            // Create an instance of the Scanner to actually read the file
            Scanner csvFile = new Scanner(fileHandle);
            // TreeMap stores the applicant applicantNumber and associated points total (i.e. ID ---> Points)
            TreeMap<String,Integer> candidates = new TreeMap<String,Integer>();
            // Read through the CSV file of Applicant Numbers and  LCE grades  
            // and calculate the applicant points scores
            while(csvFile.hasNext()){
                // Read the next applicant data line (applicantNumber followed by grades - comma separated)
                String applicantDetails = csvFile.nextLine();
                // Find end of applicant Number (i.e. first comma)
                int posFirstComma = applicantDetails.indexOf(",");
                // Extract the applicant Exam Number
                String applicantID = applicantDetails.substring(0,posFirstComma);
                // Extract the part of the CSV line that contains the grades (i.e. from position after first comma)
                String applicantGrades = applicantDetails.substring(posFirstComma+1);
                // Use String split operation to create array from grades
                String[] grades = applicantGrades.split(",");
                // For testing purposes we might want to display the data
                System.out.printf("\n%s Start Applicant %s %s \n","-".repeat(25),applicantID,"-".repeat(25));
                System.out.printf("\nApplicant Grades : %s\n",applicantGrades);
                // Use the "pointsScore" method to calculate the applicants points total
                int applicantScore = pointsScore(grades);
                System.out.printf("\nApplicant Score : %d\n",applicantScore);
                // add the applicantNumber and points score to the TreeMap
                candidates.put(applicantID,applicantScore);
                System.out.printf("%s End Applicant %s %s \n","-".repeat(25),applicantID,"-".repeat(25));
            }
            // Return the TreeMap
            return candidates;
        } catch (IOException e) {
            // If there is some problem with the file we just report it
            System.out.printf("Cannot access the file named '%s'!\n",filePath);
            return null;
        }
    }
}
