package com.chessgame.model.pezzi;

import java.util.ArrayList;
import java.util.List;

import com.chessgame.model.Square;
import com.chessgame.model.Piece;

public class Pawn extends Piece{

	
	public Pawn() {

	}
	
	public Pawn(boolean isWhite, int riga, int colonna) {
		this.isWhite = isWhite;
		simbolo = isWhite ? "♙" : "♟︎";
		notazione = isWhite ? "P" : "p";
		colore = isWhite ? 'W' : 'B';
		super.riga = riga;
		super.colonna = colonna;
	}

	@Override
	public boolean checkMove(int x, int y, Square casaArrivo) {
		List<Integer[]> listaMosse = movesList(x, y);
		boolean result = false;
		for (Integer[] mossa : listaMosse) {
			if (mossa[0] == casaArrivo.riga && mossa[1] == casaArrivo.colonna)
				result = true;
		}
		// avanza
		if (casaArrivo.piece != null) {
			result = false;	
		}
		//mangia
		if (casaArrivo.piece != null && Math.abs(casaArrivo.riga - x) == 1 && Math.abs(casaArrivo.colonna) - y == 1) {
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
		
		//casa di partenza bianco
		if (isWhite && this.riga == 2) {
			for (int i = 1; i <= 2; i++) {
				riga++;
				Integer[] mossa = {riga, colonna};
				mosse.add(mossa);
			}	
		}
		riga = x;
		colonna = y;
		if (isWhite && riga < 8 && riga > 2) {
			riga++;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		
		// mangia est
		riga = x;
		colonna = y;
		if (isWhite && riga < 8 && colonna < 8) {
			riga++;
			colonna++;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		// mangia ovest
		riga = x;
		colonna = y;
		if (isWhite && riga < 8 && colonna > 1) {
			riga++;
			colonna--;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		//casa di partenza nero
		riga = x;
		colonna = y;
		if (!isWhite && this.riga == 7) {
			for (int i = 1; i <= 2; i++) {
				riga--;
				Integer[] mossa = {riga, colonna};
				mosse.add(mossa);
			}	
		}
		riga = x;
		colonna = y;
		if (!isWhite && riga > 1 && riga < 7) {
			riga--;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		// mangia est
		riga = x;
		colonna = y;
		if (!isWhite && riga > 1 && colonna < 8) {
			riga--;
			colonna++;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		// mangia ovest
		riga = x;
		colonna = y;
		if (!isWhite && riga > 1 && colonna > 1) {
			riga--;
			colonna--;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}

		return mosse;
	}

}
