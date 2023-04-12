package com.chessgame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.chessgame.model.pezzi.Bishop;
import com.chessgame.model.pezzi.Knight;
import com.chessgame.model.pezzi.Queen;
import com.chessgame.model.pezzi.Pawn;
import com.chessgame.model.pezzi.King;
import com.chessgame.model.pezzi.Rook;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Board {
	
	public Square[][] caselle = new Square[8][8];
	public List<Piece> pezzi = new ArrayList<Piece>();
	public String configurazione;
	
	public Board() {
		for (int righe = 0; righe < 8; righe++) {
			for (int colonne = 0; colonne < 8; colonne++) {
				caselle[righe][colonne] = new Square();
				Square c = caselle[righe][colonne];
				c.riga = righe + 1;
				c.colonna = colonne + 1;
				if ((righe % 2 == 1 && colonne % 2 == 1)
						|| (righe % 2 == 0 && colonne % 2 == 0))
					c.isWhite = false;
				else 
					c.isWhite = true;
				if (righe == 0 || righe == 7) {
					switch(colonne) {
						case 0, 7: boolean isWhite = righe == 0 ? true : false;
								c.piece = new Rook(isWhite, righe + 1, colonne + 1);
								this.pezzi.add(c.piece);
								break;
						case 1, 6: isWhite = righe == 0 ? true : false;
								c.piece = new Knight(isWhite, righe + 1, colonne + 1);
								this.pezzi.add(c.piece);
								break;
						case 2, 5: isWhite = righe == 0 ? true : false;
								c.piece = new Bishop(isWhite, righe + 1, colonne + 1);
								this.pezzi.add(c.piece);
								break;
						case 3, 4: isWhite = righe == 0 ? true : false;
								c.piece = colonne == 3 ? new Queen(isWhite, righe + 1, colonne + 1) : new King(isWhite, righe + 1, colonne + 1);
								this.pezzi.add(c.piece);
								break;
					} 
				} else if (righe == 1 || righe == 6) {
					boolean isWhite = righe == 1 ? true : false;
					c.piece = new Pawn(isWhite, righe + 1, colonne + 1);
					this.pezzi.add(c.piece);
				}
			}
		}
		
	}

	public void view() {
		for (int righe = 7; righe >= 0; righe--) {
			for (int colonne = 0; colonne < 8; colonne++) {
				System.out.print("[");
				if (this.caselle[righe][colonne].piece != null) 
					System.out.print(this.caselle[righe][colonne].piece.notazione);
				else
					System.out.print(" ");
				System.out.print("]");
			}
			System.out.println();
		}
		System.out.println("***********************");
	}
	
	@Override
	public String toString() {
		return "Scacchiera [caselle=" + Arrays.toString(caselle) + ", pezzi=" + pezzi + ", configurazione="
				+ configurazione + "]";
	}
	
	
}
