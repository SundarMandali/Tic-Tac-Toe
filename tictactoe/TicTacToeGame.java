package tictactoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
	Board gameBoard;
	Deque<Player> players;

	public void initialize() {
		players=new LinkedList();

		//add players
		Player player1=new Player("Player1",new PlayingPieceX() );
		Player player2=new Player("Player2",new PlayingPieceO());

		players.add(player1);
		players.add(player2);

		gameBoard=new Board(3);
	}

	public String start() {
		boolean isWinner=false,isTie=false;
		String res="";
		while(!isWinner && !isTie) {
			Player currentPlayer=players.removeFirst();
			gameBoard.printBoard();
			List<Pair> freeSpaces=gameBoard.getFreeCells();//list of free spaces
			if(freeSpaces.isEmpty()) {//if freespaces  is empty means there is no space on board to place a piece
				res="Tie";
				isWinner=true;
			}else {
				System.out.println("Enter the row and col");
				Scanner sc=new Scanner(System.in);
				int row=sc.nextInt();
				int col=sc.nextInt();
				boolean pieceAddedSuccessfully = addPiece(row,col,currentPlayer);
				if(!pieceAddedSuccessfully) {
					System.out.println("You have entered incorrect input.Please try again");
					players.addFirst(currentPlayer);
				}else {
					boolean status=isTheWinner(row,col,currentPlayer);
					if(status) {
						res=currentPlayer.name;
						isWinner=true;
					}else {
						players.addLast(currentPlayer);
					}
				}
			}
		}
		gameBoard.printBoard();
		return res;
	}

	private boolean isTheWinner(int row, int col, Player currentPlayer) {
		
		PlayingPiece[][] board = gameBoard.getBoard();
		PlayingPieceType currentPiece=currentPlayer.getPlayingPiece().pieceType;
		int len=gameBoard.size;
		boolean rowMatch=true,colMatch=true,diagMatch=true,antiDiagMatch=true;
		//check row
		for(int j=0;j<len;j++) {
				if(board[row][j]==null || board[row][j].pieceType!=currentPiece) {
					rowMatch=false;
				}
		}
		
		//column check
		for(int i=0;i<len;i++) {
			if( board[i][col]==null || board[i][col].pieceType!=currentPiece) {
				colMatch=false;
			}
		}
		
		//diagonal check
		for(int i=0;i<len;i++) {
			if(board[i][i]==null || board[i][i].pieceType!=currentPiece) {
				diagMatch=false;
			}
		}
		
		//anti diagonal check
		for(int i=0;i<len;i++) {
				if(board[i][len-1-i]==null || board[i][len-1-i].pieceType!=currentPiece) {
					antiDiagMatch=false;
				}
		}
		return rowMatch || colMatch || diagMatch || antiDiagMatch;
	}

	private boolean addPiece(int row, int col, Player currentPlayer) {
		PlayingPiece[][] board = gameBoard.getBoard();
		if(row>=board.length || col>=board.length || row<0 || col<0) {
			return false;
		}else {
			if(board[row][col]==null) {
				board[row][col]=currentPlayer.playingPiece;
				return true;
			}else {
				return false;
			}
		}
		
	}

}
