package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	private Casa board[][];
	private boolean inicializouCorretamente = false;
	
	Tabuleiro(){
		this.board = new Casa[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++)
				this.board[i][j] = new Casa();
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++)
				this.board[i][j].makeUnvalid(inicializouCorretamente);
			for (int j = 5; j < 7; j++)
				this.board[i][j].makeUnvalid(inicializouCorretamente);
		}
		for (int i = 5; i < 7; i++) {
			for (int j = 0; j < 2; j++)
				this.board[i][j].makeUnvalid(inicializouCorretamente);
			for (int j = 5; j < 7; j++)
				this.board[i][j].makeUnvalid(inicializouCorretamente);
		}
		this.inicializouCorretamente = this.board[3][3].empty(false);	// Esvaziamento forçado para montagem do tabuleiro.
	}
	
	public boolean getInicializouCorretamente() {
		return inicializouCorretamente;
	}
	
	public void comando(String mov) {
		String posI = mov.substring(0, 2);
		String posF = mov.substring(3, 5);
		int auxIL = posI.charAt(0) - 97;
		int auxIC = Integer.valueOf(posI.substring(1)) - 1;
		int auxFL = posF.charAt(0) - 97;
		int auxFC = Integer.valueOf(posF.substring(1)) - 1;
		boolean permiss = auxIC == auxFC && Math.abs(auxIL - auxFL) == 2 || auxIL == auxFL && Math.abs(auxIC - auxFC) == 2;
		int auxL = Math.abs(auxIL + auxFL)/2, auxC = Math.abs(auxIC + auxFC)/2;
		if (permiss && board[auxFC][auxFL].getValid() && board[auxIC][auxIL].getValid() && board[auxIC][auxIL].getHaPeca() && board[auxC][auxL].getHaPeca()) {
			board[auxC][auxL].eat(board[auxFC][auxFL].fill(board[auxIC][auxIL].empty(board[auxFC][auxFL].getHaPeca())));
		}
	}
	
	public char[][] Apresenta(){
		char[][] tabuleiro = new char[7][7];
		for (int i = 0; i < 7; i++)
			for (int j = 0; j < 7; j++) {
				if (board[i][j].getValid()) {
					if (board[i][j].getHaPeca())
						tabuleiro[i][j] = 'P';
					else
						tabuleiro[i][j] = '-';
				}
				else
					tabuleiro[i][j] = ' ';
			}
		return tabuleiro;
	}
}