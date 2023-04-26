package com.chessgame.model;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class Piece {
	protected String notazione;
	protected String simbolo;
	protected boolean isWhite;
	protected char colore;
	protected int riga;
	protected int colonna;
	//protected int[] mossa = {casaPartenza.riga, casaPartenza.colonna, casaArrivo.riga, casaArrivo.colonna};
	
	
	public abstract boolean checkMove(int x, int y, Square casaArrivo);
//	{
//		if (casaArrivo.pezzo != null)
//			if ((casaArrivo.pezzo.isWhite && isWhite) || (!casaArrivo.pezzo.isWhite && !isWhite)) {
//				return false;
//			}
//		return true;
//	}
	
	public abstract List<Integer[]> movesList(int x, int y);
	
	public void move(int riga, int colonna) {
		this.riga = riga;
		this.colonna = colonna;
	}
	

	public boolean isWhite() {
		return isWhite;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}

	@Override
	public String toString() {
		return "Pezzo [notazione=" + notazione + ", isWhite=" + isWhite + ", colore=" + colore + ", riga=" + riga
				+ ", colonna=" + colonna + "]";
	}


	
	
}
