package a1novice;

import java.util.Scanner;

public class A1Novice {

	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
	}
	
	public static void process(Scanner s) {
	
	int numStudents = s.nextInt();	
		
	String[] firstName = new String[numStudents];	
	String[] lastName = new String[numStudents];
	double[] assignmentGrade = new double[numStudents];
	double[] recitationGrade = new double[numStudents];
	double[] midterm1Grade = new double[numStudents];
	double[] midterm2Grade = new double[numStudents];
	double[] finalExam = new double[numStudents];
	double[] average = new double[numStudents];
	String[] letterGrade = new String [numStudents];
	
	
	for (int i= 0; i<=numStudents; i++ ) {
		
		
		firstName[i] = s.next();	
		lastName[i] = s.next();
		assignmentGrade[i] = s.nextDouble();
		recitationGrade[i] = s.nextDouble();
		midterm1Grade[i] = s.nextDouble();
		midterm2Grade[i] = s.nextDouble();
		finalExam[i] = s.nextDouble();
		average[i] = (   (assignmentGrade[i]*.4) + (recitationGrade[i]*.1) + 
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
