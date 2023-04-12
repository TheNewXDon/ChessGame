package com.chessgame.model.pezzi;

import java.util.ArrayList;
import java.util.List;

import com.chessgame.model.Square;
import com.chessgame.model.Piece;

public class Rook extends Piece{

	public Rook() {
	}

	public Rook(boolean isWhite, int riga, int colonna) {
		this.isWhite = isWhite;
		notazione = isWhite ? "R" : "r";
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
		
		//nord
		while(riga < 8) {
			riga++;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		riga = x;
		colonna = y;
		//sud
		while(riga > 1 ) {
			riga--;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		riga = x;
		colonna = y;
		//est
		while(colonna < 8) {
			colonna++;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		riga = x;
		colonna = y;
		//ovest
		while(colonna > 1) {
			colonna--;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		return mosse;
	}

}
