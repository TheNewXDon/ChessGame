package com.chessgame.exception;

public class IllegalPieceException extends RuntimeException{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public IllegalPieceException(String messaggio) {
		super(messaggio);
	}
}
