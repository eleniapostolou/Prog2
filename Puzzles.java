package mysterylab;

import java.util.Scanner;

public class Puzzles {

	private int row = 1;

	public void instructions() {
		System.out.println("Congratulations! You reached the final level!");
		System.out.println("Now to finally escape the room you need to solve those three puzzles, using the given hints from the previous levels.");
		System.out.println("Use your remaining time wisely and good luck! Let's get started! ");
	}

	public void getPuzzle(int room) { //To room einai to dwmatio kai i the to dexomaste ws orisma apo ti main i an ftiaksoume klasi dwmatiou na to exoume metavliti klasis na to pairnoume apeutheias.


		System.out.println("questions[room][Puzzles.getRow]"); //To row einai se poio grifo kata seira vriskomaste gia na prosdioristei kai i thesi tou ston pinaka questions
	}

	public void getResult(int room) {

		Scanner in = new Scanner(System.in);
		boolean flag = false;
		String answer;

		while (flag == false) {
			answer = in.next();

			if (answer == "answer[room][Puzzles.getRow]" ) {
				System.out.println(" Crongatulations! You are correct! We move to the next puzzle");
				flag = true;
				row = Puzzles.setRow();
			} else {
				System.out.println(" Oops.. You missed that! Try again!");
			}
		}
	}

	public void setRow() {

		row = row + 1;
	}

	public int getRow() {
		return row;
	}



}






