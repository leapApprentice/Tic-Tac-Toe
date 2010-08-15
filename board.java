import java.util.Random;
import java.util.Scanner;


public class board {

	//has two methods, one to store the info for the board and the other to draw the board
	//store info in an array
	//redraw the board when a move is made, keep a counter of moves

	//variable to count computer moves
	//int compMoveCounter = 0;

	//variable to count human moves
	//int humanMoveCounter = 0;

	protected int[][] gameBoard;

	//board constructor
	//length = rows, width = columns
	//every square starts as 
	public board(int length, int width) {

		gameBoard = new int[length][width];
		
		//set every square to 2 initially because that value isn't used in the game
		for (int i = 0; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[i].length; j++) {
				gameBoard[i][j] = 2;
			}
		}
	}

	//put this in game.java instead?
	//add code here to make board size user-modifiable
	//start with 3 by 3 board

	//board gameBoard = new board(3,3);

	
	//changes the board to reflect one move
	void makeMove(int row, int column, player thisPlayer) {
		gameBoard[row][column] = thisPlayer.token;
	}
	
	int randomCMove() {
		//temporarily makes the board move randomly
		Random randNum = new Random();
		return randNum.nextInt(2);
	}
	
	void computerMove(player computerPlayer, int row, int col) {
		//rank the current board
		
		//move to the highest-ranked square
		if (gameBoard[row][col] > 1) {
			makeMove(row,col,computerPlayer);
		}
	}

	//asks the human player for a move
	void humanMove(player humanPlayer) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Your Move. Type the number of the row you want " +
				"followed by the number of the column that you want.");
		
		//get the column and row of the player's move
		int moveRow = input.nextInt();
		int moveCol = input.nextInt();
		
		//make the move!
		makeMove(moveRow,moveCol,humanPlayer);
	}
	
	//prints board to console
	void printBoard() {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (gameBoard[i][j] == 2) {
					System.out.print("-");
				} else if (gameBoard[i][j] == 0) {
					System.out.print("x");
				} else if (gameBoard[i][j] == 1) {
					System.out.print("o");
				}
			}
			System.out.println();
		}
	}

	//checks to see if the game is over
	//is over if all moves have been made or three squares in a row match
	//up/down, across, diagonal

	//redo this. There has a be a more concise way to express this.
	//also this will only work with a 3,3 board. Try to make this more general
	boolean isOver() {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {

				//set up variables to keep track of the previous and 
				//next squares on the board
				//5 is a randomly chosen number that can't be a legitimate value
				int prev = 5, next = 5, current = gameBoard[i][j];
				int above = 5, below = 5;

				//over by horizontal win
				if (j > 0) { prev = gameBoard[i][j-1]; }
				if (j < gameBoard[i].length) { next = gameBoard[i][j+1];}

				if (prev == next && prev == current) { return true; }

				//over by vertical win
				if (i > 0) { above = gameBoard[i-1][j];}
				if (i < gameBoard.length) { below = gameBoard[i+1][j];}

				if (above == below && current == below) { return true; }

				//over by diagonal win

			}
		}

		//if it's not true, it's false
		return false;
	}

	//ranks computer moves
	//center move is worth the most
	//if other player has two in a row, the winning square is worth the most
	//without other factors, mid and end squares are worth the same
	void rankMove(int row, int column, int piece) {
		//name the squares
		//int center = 

		//if ()
	}

}
