
public class Main {

	public static void main(String[] args) {
		new TicTacToeGame(null).setGameInterface(new TicTacToeGame.GameInterface() {
			@Override

				public int moveMade(String[][] gameBoard, int player) {
				// print gameboard
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						System.out.printf("[%s]\t", gameBoard[i][j]);
					}
					System.out.println();
				}
				System.out.printf(" player : %d\n", player);

				// Row check
				for (int i = 0; i < 3; i++) {
					if (gameBoard[i][0].equals(gameBoard[i][1]) && gameBoard[i][1].equals(gameBoard[i][2])
							&& !gameBoard[i][0].equals(" ")) {
						if (gameBoard[i][0].equals("X")) {
							return 1; // X Wins
						} else if (gameBoard[i][0].equals("O")) {
							return 2; // O Wins
						}
					}
				}

				// Column check
				for (int j = 0; j < 3; j++) {
					if (gameBoard[0][j].equals(gameBoard[1][j]) && gameBoard[1][j].equals(gameBoard[2][j])
							&& !gameBoard[0][j].equals(" ")) {
						if (gameBoard[0][j].equals("X")) {
							return 1; // X Wins
						} else if (gameBoard[0][j].equals("O")) {
							return 2; // O Wins
						}
					}
				}

				// Cross check left to right
				if (gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2])
						&& !gameBoard[0][0].equals(" ")) {
					if (gameBoard[0][0].equals("X")) {
						return 1; // X Wins
					} else if (gameBoard[0][0].equals("O")) {
						return 2; // O Wins
					}
				}

				// Cross check right to left 
				if (gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0])
						&& !gameBoard[0][2].equals(" ")) {
					if (gameBoard[0][2].equals("X")) {
						return 1; // X Wins
					} else if (gameBoard[0][2].equals("O")) {
						return 2; // O Wins
					}
				}

				// draw situation check
				boolean isBoardFull = true;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (gameBoard[i][j].equals("")) {
							isBoardFull = false;
							break;
						
						}
					}

				}
				if (isBoardFull) {
					return 0; // Draw
				}

				// There is no winner, the game continues
				return -1;
			}

		});
	}

}
// gameBoard[i][j].equals(" ") i used to this method to check every column or
// row in gameBoard
// a00314852 Eren Sirin
// gameBoard[i] = row and gameboard[j] determine columns.