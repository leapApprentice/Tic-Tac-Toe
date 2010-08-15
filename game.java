import java.util.Scanner;

public class game {

	//makes a tic-tac-toe board
	//it works with static, but I don't know why
	//find out why
	//static board thisBoard = new board(3,3);


	public static void main( String[] args) {
		
		board thisBoard = new board(3,3);
		
		//set up player variables to keep track of whose turn it is
		player playerX = new player(0);
		player playerO = new player(1);

		thisBoard.printBoard();

		//you need a scanner to make moves
		//decide whose turn it is and ask that player to move

		Scanner firstMove = new Scanner(System.in);
		
		//decide who goes first
		System.out.println("Type 0 if you would like to go first.");

		int gameMove = firstMove.nextInt();

		//start the game
		//see who will get the first move
		if (gameMove == 0) { 
			//humanPlayer moves first and is X
			while (!thisBoard.isOver()) {
				thisBoard.humanMove(playerX);
				thisBoard.printBoard();
				thisBoard.computerMove(playerO, thisBoard.randomCMove(), thisBoard.randomCMove());
				thisBoard.printBoard();
			}
		} else {
			//computerPlayer moves first and is X
			while (!thisBoard.isOver()) {
				thisBoard.computerMove(playerX, thisBoard.randomCMove(), thisBoard.randomCMove());
				thisBoard.printBoard();
				thisBoard.humanMove(playerO);
				thisBoard.printBoard();
			}
		}

		//exchange move until isOver
		if (!thisBoard.isOver()) { System.out.print("Game Over!"); }
	}
}