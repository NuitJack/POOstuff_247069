package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	int tamAquario;
	int tamLombriga;
	int posCabeca;
	boolean paraDireita;
	String apresentacao;
	
	AquarioLombriga(String entrada){
		this.tamAquario = Integer.parseInt(entrada.substring(0, 2));
		this.tamLombriga = Integer.parseInt(entrada.substring(2, 4));
		this.posCabeca = Integer.parseInt(entrada.substring(4, 6));
		this.paraDireita = false;
		if (this.tamLombriga > this.tamAquario)
			this.tamLombriga = this.tamAquario;
		if (this.posCabeca < 1 || this.posCabeca > this.tamAquario || this.posCabeca + this.tamLombriga > this.tamAquario)
			this.posCabeca = 1;
		
		// Gera a string que representa a lombriga no aquário
		this.apresentacao = "";
		for (int i = 1; i < this.posCabeca; i++)
			this.apresentacao += "#";
		this.apresentacao += "O";
		for (int i = 1; i < this.tamLombriga; i++)
			this.apresentacao += "@";
		for (int i = this.posCabeca + this.tamLombriga; i <= this.tamAquario; i++)
			this.apresentacao += "#";
	}
	
	boolean naBorda() {
		return (paraDireita && posCabeca -1 == tamAquario || !paraDireita && posCabeca == 1);
	}
	
	void crescer() {
		if (paraDireita && posCabeca - tamLombriga > 1 || !paraDireita && posCabeca + tamLombriga <= tamAquario) {
			int index;
			if (paraDireita) {
				index = posCabeca - 1 - tamLombriga;
				apresentacao = apresentacao.substring(0, index-1) + "@" + apresentacao.substring(index);
			}
			else {
				index = posCabeca -1 + tamLombriga;
				apresentacao = apresentacao.substring(0, index) + "@" + apresentacao.substring(index+1);
			}
			tamLombriga++;
		}
	}
	
	void mover() {
		if (paraDireita) {
			int index = posCabeca - tamLombriga - 1;
			apresentacao = apresentacao.substring(0, index) + "#" + apresentacao.substring(index, apresentacao.length()-1);
			posCabeca++;
		}
		else {
			apresentacao = apresentacao.substring(0, posCabeca - 2) + apresentacao.substring(posCabeca - 1) + "#";
			posCabeca--;
		}

	}
	
	void virar() {
		if (tamAquario != 1) {
			if (paraDireita) {
				apresentacao = apresentacao.replaceFirst("O", "#").replaceFirst("@", "O");
				posCabeca = posCabeca - tamLombriga;
				apresentacao = apresentacao.substring(0, posCabeca) + "@" + apresentacao.substring(posCabeca, apresentacao.length()-1);
				paraDireita = false;
			}
			else {
				apresentacao = apresentacao.replaceFirst("O", "@");
				posCabeca = posCabeca + tamLombriga;
				apresentacao = apresentacao.substring(0, posCabeca - 2) + "O" + apresentacao.substring(posCabeca - 1);
				paraDireita = true;
			}
		}
	}

	String apresenta() {
		return apresentacao;
	}

}