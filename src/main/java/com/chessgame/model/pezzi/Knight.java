package com.chessgame.model.pezzi;

import java.util.ArrayList;
import java.util.List;

import com.chessgame.model.Square;
import com.chessgame.model.Piece;

public class Knight extends Piece{

	public Knight() {
		
	}

	public Knight(boolean isWhite, int riga, int colonna) {
		this.isWhite = isWhite;
		notazione = isWhite ? "C" : "c";
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
		
		//nord-ovest 1
		if(riga < 7 && colonna > 1) {
			riga+=2;
			colonna--;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		riga = x;
		colonna = y;
		//nord-ovest 2
		if(riga < 8 && colonna > 2) {
			riga++;
			colonna-=2;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		riga = x;
		colonna = y;
		//nord-est 1
		if(riga < 7 && colonna < 8) {
			riga+=2;
			colonna++;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		riga = x;
		colonna = y;
		//nord-est 2
		if(riga < 8 && colonna < 7) {
			riga++;
			colonna+=2;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		riga = x;
		colonna = y;
		//sud-ovest 1
		if(riga > 1 && colonna > 2) {
			riga--;
			colonna-=2;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		riga = x;
		colonna = y;
		//sud-ovest 2
		if(riga > 2 && colonna > 1) {
			riga-=2;
			colonna--;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		riga = x;
		colonna = y;
		//sud-est 1
		if(riga > 1 && colonna < 7) {
			riga--;
			colonna+=2;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		riga = x;
		colonna = y;
		//sud-est 2
		if(riga > 2 && colonna < 8) {
			riga-=2;
			colonna++;
			Integer[] mossa = {riga, colonna};
			mosse.add(mossa);
		}
		
		return mosse;
	}
}
