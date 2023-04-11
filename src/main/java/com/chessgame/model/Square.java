package com.chessgame.model;

import lombok.ToString;

@ToString
public class Square {
	public Piece piece;
	public boolean isWhite;
	public int riga;
	public int colonna;	
	
	
	public Square getSquareByPosition(Board board, int riga, int colonna) {
		for (int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				if (board.caselle[x][y].riga == riga && board.caselle[x][y].colonna == colonna) 
					return board.caselle[x][y];
			}
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Casa [isWhite=" + isWhite + ", pezzo=" + piece + ", riga=" + riga
				+ ", colonna=" + colonna + "]";
	}
	
	
	
}
