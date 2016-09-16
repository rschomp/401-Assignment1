package a1jedi;

import java.util.Scanner;

public class A1Jedi {

	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);

	}

	public static void process(Scanner s) {
		
		//initial loop 
		
		int numAssignments = s.nextInt();
		int sum = 0;
	
		for (int i=0; i<numAssignments; i++ ) {
			sum += s.nextInt();	
		}
	
		int numStudents = s.nextInt();
	
		
		
		//arrays
		
		String[] firstName = new String[numStudents];	
		String[] lastName = new String[numStudents];
		double[] midterm1Grade = new double[numStudents];
		double[] midterm2Grade = new double[numStudents];
		double[] finalExam = new double[numStudents];
		double[] average = new double[numStudents];
		String[] letterGrade = new String [numStudents];
		double[] scaleRecitation = new double[numStudents];
		double[] scaleAssignments = new double[numStudents];
		double[] normalMidterm1 = new double[numStudents];
		double[] normalMidterm2 = new double[numStudents];
		double[] normalFinalExam = new double[numStudents];
		double[] curvedMidterm1 = new double[numStudents];
	    double[] curvedMidterm2 = new double[numStudents];
		double[] curvedFinalExam = new double[numStudents];
		
		//putting individual data into arrays
		
		for (int i= 0; i<numStudents; i++ ) {
			
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
	
				
		 }	

		//midterm1 stuff
		
		double add1 = 0;
		for (int m=0; m<midterm1Grade.length; m++){ 
			add1 += midterm1Grade[m];
		}
		
		double midterm1Average = add1/midterm1Grade.length; 
		double midterm1add = 0;
		for (int w=0; w<midterm1Grade.length; w++) {
			midterm1add += (midterm1Average-midterm1Grade[w])*(midterm1Average-midterm1Grade[w]);
		}
		double midterm1Var = midterm1add/midterm1Grade.length;
		double midterm1SD = Math.sqrt(midterm1Var);
		
		for (int b=0; b<numStudents; b++) {
			normalMidterm1[b] = (midterm1Grade[b]-midterm1Average)/midterm1SD;
			
			if (normalMidterm1[b] >= 1.0) {curvedMidterm1[b] = 4.0;}
			else if (normalMidterm1[b] >= -1.0) {
				curvedMidterm1[b] = 2.0 + (normalMidterm1[b] + 1);
				}
			else if (normalMidterm1[b] >= -2.0) {
				curvedMidterm1[b] = 0.0 + (2*(normalMidterm1[b] + 2.0));
				}
					else {curvedMidterm1[b] = 0.0;}
		}
		
		
		//midterm2 stuff
		
		double add2 = 0;
		for (int k=0; k<midterm2Grade.length; k++){ 
			add2 += midterm2Grade[k];
		}
		
		double midterm2Average = add2/midterm2Grade.length; 
		double midterm2add = 0;
		for (int w=0; w<midterm2Grade.length; w++) {
			midterm2add += (midterm2Average-midterm2Grade[w])*(midterm2Average-midterm2Grade[w]);
		}
		double midterm2Var = midterm2add/midterm2Grade.length;
		double midterm2SD = Math.sqrt(midterm2Var);
		
		for (int p=0; p<numStudents; p++) {
			normalMidterm2[p] = (midterm2Grade[p]-midterm2Average)/midterm2SD;
			
			if (normalMidterm2[p] >= 1.0) {curvedMidterm2[p] = 4.0;}
			else if (normalMidterm2[p] >= -1.0) {
				curvedMidterm2[p] = 2.0 + (normalMidterm2[p] + 1);
				}
			else if (normalMidterm2[p] >= -2.0) {
				curvedMidterm2[p] = 0.0 + (2*(normalMidterm2[p] + 2.0));
				}
					else {curvedMidterm2[p] = 0.0;}
		}
		
	
		
		//finalExam stuff
		
		
		double addFin = 0;
		for (int r=0; r<finalExam.length; r++){ 
			addFin += finalExam[r];
		}
		
		double finalExamAverage = addFin/finalExam.length; 
		double finalExamAdd = 0;
		for (int w=0; w<finalExam.length; w++) {
			finalExamAdd += (finalExamAverage-finalExam[w])*(finalExamAverage-finalExam[w]);
		}
		double finalExamVar = finalExamAdd/finalExam.length;
		double finalExamSD = Math.sqrt(finalExamVar);
		
		for (int t=0; t<numStudents; t++) {
			normalFinalExam[t] = (finalExam[t]-finalExamAverage)/finalExamSD;
			
			if (normalFinalExam[t] >= 1.0) {curvedFinalExam[t] = 4.0;}
			else if (normalFinalExam[t] >= -1.0) {
				curvedFinalExam[t] = 2.0 + (normalFinalExam[t] + 1);
				}
			else if (normalFinalExam[t] >= -2.0) {
				curvedFinalExam[t] = 0.0 + (2*(normalFinalExam[t] + 2.0));
				}
					else {curvedFinalExam[t] = 0.0;}
			
		}
		

		//counting number of each letter
		
		int countA = 0;
		int countAminus = 0;
		int countBplus = 0;
		int countB = 0;
		int countBminus = 0;
		int countCplus = 0;
		int countC = 0;
		int countCminus = 0;
		int countDplus = 0;
		int countD = 0;
		int countF = 0;
		
		for (int i=0; i<numStudents; i++ ) {
			
			average[i] = (   (scaleAssignments[i]*.4) + (scaleRecitation[i]*.1) + 
					(curvedMidterm1[i]*.15) + (curvedMidterm2[i]*.15) + (curvedFinalExam[i]*.2)   );
			
			//calculating letter grade
			
			if (average[i] >= 3.85) {letterGrade[i] = "A"; countA++;}
			else if (average[i] >= 3.5) {letterGrade[i] = "A-";countAminus++;}
			else if (average[i] >= 3.15) {letterGrade[i] = "B+"; countBplus++;}
			else if (average[i] >= 2.85) {letterGrade[i] = "B"; countB++;}
			else if (average[i] >= 2.5) {letterGrade[i] = "B-"; countBminus++; }
			else if (average[i] >= 2.15) {letterGrade[i] = "C+"; countCplus++;}
			else if (average[i] >= 1.85) {letterGrade[i] = "C"; countC++;}
			else if (average[i] >= 1.5) {letterGrade[i] = "C-"; countCminus++;}
			else if (average[i] >= 1.15) {letterGrade[i] = "D+"; countDplus++;}
			else if (average[i] >= .85) {letterGrade[i] = "D"; countD++;}
					else {letterGrade[i] = "F"; countF++;}
			
		}
		
		

		System.out.println("A " + ": " + countA);
		System.out.println("A-" + ": " + countAminus);
		System.out.println("B+" + ": " + countBplus);
		System.out.println("B " + ": " + countB);
		System.out.println("B-" + ": " + countBminus);
		System.out.println("C+" + ": " + countCplus);
		System.out.println("C " + ": " + countC);
		System.out.println("C-" + ": " + countCminus);
		System.out.println("D+" + ": " + countDplus);
		System.out.println("D " + ": " + countD);
		System.out.println("F " + ": " + countF);
		
		
		
	}

}
