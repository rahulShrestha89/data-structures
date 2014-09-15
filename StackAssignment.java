/**
 * 
 * @author Rahul Shrestha
 * CMPS 390-Assignment 02 
 * Dr. Patrick McDowell
 * 
 * Stack
 *
 */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StackAssignment {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws IOException {

		Scanner myScan = new Scanner(System.in);
		
		// instantiate InfixToPostfix class
		InfixToPostfix toPostfix = new InfixToPostfix();
		
		System.out.println(" Please provide the name of the text file with extension:>>");
		String textFileName = myScan.next();	// store the name of text file
		
		// object to read and assign infix expressions 
		Scanner scanTextFile = new Scanner(new File(textFileName));
		
		// read text file to calculate number of lines to allocate String array of INFIX
		int numberOfLines = 0;
		try {
		    BufferedReader textFileReader = new BufferedReader(new FileReader (textFileName));
			while (textFileReader.readLine() != null) {
			    numberOfLines++;
			}
			System.out.println("Text file found!!! Processing ....");
		} catch (FileNotFoundException e) {
			System.out.println("File not found, check file name again");
			e.printStackTrace();
		}
		
		// infixString array to store expressions
		String infixString[] = new String[numberOfLines];
		
		// assign infix expressions to String array
		for(int i=0 ; i<infixString.length ; i++){
			 infixString[i] = scanTextFile.nextLine();
		}
		
		// a) Check whether the given expressions are valid
		boolean expressionCondition = true; 
		System.out.println("A) PARENTHESES TEST!!!");
		for (int i=0;i<infixString.length;i++){
			
			expressionCondition = toPostfix.checkEquation(infixString[i]); // call to checkEquation() in InfixToPostfix class	
			if(expressionCondition == true){ // true if equation is balanced
				System.out.println(" The equation" + infixString[i] + " is balanced.");
			}
			else{ // false if equation is not balanced
				System.out.println(" The equation" + infixString[i] + " is invalid.");
			}
			System.out.println("");
		
		}
	
	} // end of main method

}
