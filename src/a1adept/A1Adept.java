package a1adept;

import java.util.Scanner;

public class A1Adept {
	
	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
		
	}
	
	public static void process(Scanner s) {
		
		int numAssignments = s.nextInt();
		int sum = 0;
	
		for (int i=0; i<numAssignments; i++ ) {
			sum += s.nextInt();	
		}
	
		int numStudents = s.nextInt();
	
		
		String[] firstName = new String[numStudents];	
		String[] lastName = new String[numStudents];
		double[] midterm1Grade = new double[numStudents];
		double[] midterm2Grade = new double[numStudents];
		double[] finalExam = new double[numStudents];
		double[] average = new double[numStudents];
		String[] letterGrade = new String [numStudents];
		double[] scaleRecitation = new double[numStudents];
		double[] scaleAssignments = new double[numStudents];
		
		
		
		for (int i= 0; i<=numStudents; i++ ) {
			
		
			
			firstName[i] = s.next();	
			lastName[i] = s.next();
			int numRecitationsAt = s.nextInt();
			double recitationAverage = numRecitationsAt/15.0;
			if (recitationAverage >= .95) {scaleRecitation[i] = 4.0;}
			else if (recitationAverage >= .7) {scaleRecitation[i] =  (recitationAverage-.7)*10.0 +1.5;}
			else if (recitationAverage > .4) {scaleRecitation[i] = (recitationAverage-.4)*5.0;}
					else {scaleRecitation[i] = 0.0;}
			
			
			double sumAssignmentPoints = 0;
			for (int j=0; j<numAssignments; j++ ) {
				sumAssignmentPoints += s.nextDouble();
			}
			 
			double assignmentAverage = sumAssignmentPoints/sum;
			if (assignmentAverage >= .95) {scaleAssignments[i] = 4.0;}
			else if (assignmentAverage >= .7) {scaleAssignments[i] = (assignmentAverage-.7)*10.0 +1.5;}
			else if (assignmentAverage > .4) {scaleAssignments[i] = (assignmentAverage-.4)*5.0;}
					else {scaleAssignments[i] = 0.0;}
			
			midterm1Grade[i] = s.nextDouble();
			midterm2Grade[i] = s.nextDouble();
			finalExam[i] = s.nextDouble();
			average[i] = (   (scaleAssignments[i]*.4) + (scaleRecitation[i]*.1) + 
					(midterm1Grade[i]*.15) + (midterm2Grade[i]*.15) + (finalExam[i]*.2)   );
			
			
			if (average[i] >= 3.85) {letterGrade[i] = "A";}
			else if (average[i] >= 3.5) {letterGrade[i] = "A-";}
			else if (average[i] >= 3.15) {letterGrade[i] = "B+";}
			else if (average[i] >= 2.85) {letterGrade[i] = "B";}
			else if (average[i] >= 2.5) {letterGrade[i] = "B-";}
			else if (average[i] >= 2.15) {letterGrade[i] = "C+";}
			else if (average[i] >= 1.85) {letterGrade[i] = "C";}
			else if (average[i] >= 1.5) {letterGrade[i] = "C-";}
			else if (average[i] >= 1.15) {letterGrade[i] = "D+";}
			else if (average[i] >= .85) {letterGrade[i] = "D";}
					else {letterGrade[i] = "F";}
			
			
			System.out.println(firstName[i].charAt(0) + ". " + lastName[i] + " " + letterGrade[i]);
			
		 }	
		
		
	}

}
