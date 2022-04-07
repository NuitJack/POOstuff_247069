package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
		AquarioLombriga lombriga;
		String comandos;
		boolean viva;
	
		Animacao(String entrada){
			this.lombriga = new AquarioLombriga(entrada.substring(0, 6));
			this.comandos = entrada.substring(6);
			this.viva = true;
		}
	  
		boolean isAlive() {
			return viva;
		}
		
		String apresenta() {
			return lombriga.apresenta();
		}
		
		void passo() {
			char c = comandos.charAt(0);
			
			if (c == 'C') {
				lombriga.crescer();
			}
			else if (c == 'M') {
				if (lombriga.naBorda())
					lombriga.virar();
				else
					lombriga.mover();
			}
			else if (c == 'V') {
				lombriga.virar();
			}
			
			if (comandos.length() > 1)
				comandos = comandos.substring(1);
			else {
				comandos = "";
				viva = false;
			}
		}
		
}