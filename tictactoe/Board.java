package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
	int size;
	PlayingPiece[][] board;
	
	Board(int size){
		this.size=size;
		board=new PlayingPiece[size][size];
	}

	public void printBoard() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]!=null) {
					System.out.print(board[i][j].pieceType.name()+" |");
				}else {
					System.out.print("  |");
				}
			}
			System.out.println();
		}
	}

	public List<Pair> getFreeCells() {
		// TODO Auto-generated method stub
		List<Pair> list=new ArrayList();
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]==null) {
					list.add(new Pair(i,j));
				}
			}
		}
		return list;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public PlayingPiece[][] getBoard() {
		return board;
	}

	public void setBoard(PlayingPiece[][] board) {
		this.board = board;
	}
	
}
