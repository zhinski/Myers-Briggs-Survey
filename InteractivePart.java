/*
 * The document that this file reads must be in the form:
 * notes;
 * Question; int; int;
 * Question; int; int;
 */
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException; 
import java.util.Scanner; 

public class InteractivePart {
	public static int[][] abcd = new int[4][2];
	
	public static void main(String[] args) {
		String qLocation = "realQuestions.txt"; //location of the questions
		File questions = new File(qLocation);
		Scanner qFinder = null;//creates scanner and uses it to fill in the questions
		
		try {
//			System.out.println(); //this is my attempt at dealing with incorrect file locations
			qFinder = new Scanner(questions);
		}
		catch (FileNotFoundException e) {
			System.out.println("the questions file couldnt be found");
			qFinder = new Scanner("this isn't right;\n this appears if the file could not be found ; 0; 0;");
		}
			
		qFinder.useDelimiter("\\s*;\\s*");	//the ";" symbol is used to separate elements or tokens that go into the question object as arguments
		if (qFinder.hasNextLine()) {
			qFinder.next();
			qFinder.nextLine();
		}
		
		QuestionObj[] Questions = new QuestionObj[6]; //the number of questions in the document must be equal to or greater than the number in this array
		for (int i = 0; qFinder.hasNext() && i < Questions.length; i++) {
			Questions[i] = new QuestionObj(qFinder.next(), qFinder.nextInt(), qFinder.nextInt());
		}
		qFinder.close();
		
		Scanner reply = new Scanner(System.in);
		for (QuestionObj i : Questions) { //for each question object in Questions, set i equal to that object, check if it is empty, then askYesNo
			if (i == null) break;
			askYesNo(i, reply);
		}
		reply.close();
		
		String personality = "";
		personality += abcd[0][0] > abcd[0][1] ? "E":"I";
		personality += abcd[1][0] > abcd[1][1] ? "S":"N";
		personality += abcd[2][0] > abcd[2][1] ? "F":"T";
		personality += abcd[3][0] > abcd[3][1] ? "P":"J";
		File result = new File("Types\\" + personality + ".txt");
		Scanner printResult = null;
		
		System.out.println("\n\n\n\nResults:\n");

		try{
			printResult = new Scanner(result);
		} catch (FileNotFoundException e) {
			System.out.println(personality);
			System.out.println("something went wrong, unable to find the results");
		}
		
		finally {
			if (printResult != null) {
				
				
				while(printResult.hasNextLine()) System.out.println(printResult.nextLine());
				
				printResult.close();
			}
			System.out.println("done");
			
		}
	}
	
public static void askYesNo(QuestionObj currentQ, Scanner reply) {	//takes string, what category, and if it is the first or second entry
		
		System.out.println(currentQ);
		String answer ="";
		while(true) {
			answer = reply.next();
			reply.nextLine();
			if (answer.equals("a")) {	//if the answer is yes, add one to the Trait in the category, otherwise add one to the other entry
				abcd[currentQ.getCategory()][currentQ.getTrait()] += 1;
				break;
			}
			else if (answer.equals("b")){
				abcd[currentQ.getCategory()][currentQ.getTrait()==0 ? 1:0] +=1;
				break;
			}
			else {
				System.out.println("Please enter 'a' or 'b' for your answers!");
			}
		}
		currentQ.setReply(answer);
	}
}
