package com.chessgame.model.pezzi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.chessgame.exception.IllegalPieceException;
import com.chessgame.model.Square;
import com.chessgame.model.Piece;

public class Bishop extends Piece{
	
	public Bishop() {
		notazione = super.isWhite == true ? "A" : "a";
	}
	
	public Bishop(boolean isWhite, int riga, int colonna) {
		this.isWhite = isWhite;
		simbolo = isWhite ? "♗" : "♝";
		notazione = isWhite ? "B" : "b";
		colore = isWhite ? 'W' : 'B';
		super.riga = riga;
		super.colonna = colonna;
	}
	
	public Bishop(int riga, int colonna) throws IllegalPieceException {
		if (riga < 1 || riga > 8 
				|| colonna < 1 || colonna > 8)
			throw new IllegalPieceException("Mossa illegale");
		else {
			super.riga = riga;
			super.colonna = colonna;
		}
		
	}

	@Override
	public boolean checkMove(int x, int y, Square casaArrivo) {
		List<Integer[]> listaMosse = movesList(x, y);
		boolean result = false;
		for (Integer[] mossa : listaMosse) {
			if (mossa[0] == casaArrivo.riga && mossa[1] == casaArrivo.colonna)
				result = true;
		}
		if (casaArrivo.piece != null) {
			if ((casaArrivo.piece.isWhite() && isWhite) || (!casaArrivo.piece.isWhite() && !isWhite)) {
				result = false;
			}
		}
		return result;
	}

	@Override
	public List<Integer[]> movesList(int x, int y) {
		List<Integer[]> mosse = new ArrayList<>();
		int riga = x;
		int colonna = y;
		
		//nord-ovest
		while(riga < 8 && colonna > 1) {
			riga++;
			colonna--;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		riga = x;
		colonna = y;
		//nord-est
		while(riga < 8 && colonna < 8) {
			riga++;
			colonna++;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		riga = x;
		colonna = y;
		//sud-ovest
		while(riga > 1 && colonna > 1) {
			riga--;
			colonna--;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		riga = x;
		colonna = y;
		//sud-est
		while(riga > 1 && colonna < 8) {
			riga--;
			colonna++;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		return mosse;
	}

	
	
}
