package com.chessgame;

import java.util.List;
import java.util.Scanner;

import com.chessgame.model.Piece;
import com.chessgame.model.Square;
import com.chessgame.model.Board;
import com.chessgame.model.pezzi.Bishop;
import com.chessgame.model.pezzi.Knight;
import com.chessgame.model.pezzi.Queen;
import com.chessgame.model.pezzi.Pawn;
import com.chessgame.model.pezzi.King;
import com.chessgame.model.pezzi.Rook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChessGameApplication {

	public static void main(String[] args) {	
		SpringApplication.run(ChessGameApplication.class, args);
		Board board = new Board();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++)
			System.out.println(board.caselle[i][j].toString());
		}
		board.view();
		Scanner scan = new Scanner(System.in);
		boolean isPlaying = true;
		while(isPlaying) {
			System.out.println("Row of your piece:");
			int rowStart = scan.nextInt();
			System.out.println("Column of your piece:");
			int columnStart = scan.nextInt();
			System.out.println("New row:");
			int rowFinal = scan.nextInt();
			System.out.println("New column:");
			int columnFinal = scan.nextInt();
			board.moving(rowStart,columnStart,rowFinal,columnFinal);
		}
//		Square e4 = new Square();
//		e4 = e4.getSquareByPosition(board, 4, 5);
//		System.out.println(e4.toString());
//		board.view();
//		System.out.println("***********************");
//		if (board.caselle[1][4].piece.checkMove(2, 5, board.caselle[3][4])) {
//			board.caselle[1][4].piece.move(4, 5);
//			e4.piece = board.caselle[1][4].piece;
//			board.caselle[1][4].piece = null;
//		}
//
//		board.view();
//		//test mosse alfiere
//		Piece alfiere = new Bishop();
//		List<Integer[]> listaMosse = alfiere.movesList(6, 4);
//		for (Integer[] mossa : listaMosse) {
//			System.out.println("Mossa Alfiere: " + mossa[0] + " " + mossa[1]);
//		}
//		System.out.println(alfiere.checkMove(6, 4, board.caselle[4][4]));
//
//		//test mosse cavallo
//		Piece cavallo = new Knight();
//		listaMosse = cavallo.movesList(5, 5);
//		for (Integer[] mossa : listaMosse) {
//			System.out.println("Mossa Cavallo: " + mossa[0] + " " + mossa[1]);
//		}
//		System.out.println(cavallo.checkMove(5, 5, board.caselle[5][2]));
//
//		//test mosse torre
//		Piece torre = new Rook();
//		torre.setWhite(true);
//		listaMosse = torre.movesList(5, 5);
//		for (Integer[] mossa : listaMosse) {
//			System.out.println("Mossa Torre: " + mossa[0] + " " + mossa[1]);
//		}
//		System.out.println(torre.checkMove(5, 5, board.caselle[1][4]));
//
//		//test mosse pedone
//		Piece pedone = new Pawn();
//		pedone.setWhite(true);
//		listaMosse = pedone.movesList(6, 4);
//		for (Integer[] mossa : listaMosse) {
//			System.out.println("Mossa Pedone: " + mossa[0] + " " + mossa[1]);
//		}
//		System.out.println(pedone.checkMove(6, 4, board.caselle[6][3]));
//
//		//test mosse donna
//		Piece donna = new Queen();
//		listaMosse = donna.movesList(5, 5);
//		for (Integer[] mossa : listaMosse) {
//			System.out.println("Mossa Donna: " + mossa[0] + " " + mossa[1]);
//		}
//		System.out.println(donna.checkMove(5, 5, board.caselle[2][2]));
//
//		//test mosse re
//		Piece re = new King();
//		listaMosse = re.movesList(5, 5);
//		for (Integer[] mossa : listaMosse) {
//			System.out.println("Mossa Re: " + mossa[0] + " " + mossa[1]);
//		}
//		System.out.println(re.checkMove(5, 5, board.caselle[3][3]));
	}

}
