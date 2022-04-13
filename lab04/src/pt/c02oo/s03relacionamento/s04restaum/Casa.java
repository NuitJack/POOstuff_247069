package pt.c02oo.s03relacionamento.s04restaum;

public class Casa {
	private boolean valid;
	private boolean haPeca;
	
	Casa(){
		this.valid = true;
		this.haPeca = true;
	}
	
	public void makeUnvalid(boolean terminouInit) {
		if (!terminouInit) {
			valid = false;
			haPeca = false;
		}
	}
	
	public boolean getHaPeca() {
		return haPeca;
	}
	
	public boolean getValid() {
		return valid;
	}
	
	public boolean empty(boolean casaOcupada) {
		if (!casaOcupada) {
			haPeca = false;
			return true;
		}
		else
			return false;
	}
	
	public void eat(boolean pecaMoveu) {
		if (pecaMoveu)
			haPeca = false;
	}
	
	public boolean fill(boolean pecaMoveu) {
		if (pecaMoveu) {
			haPeca = true;
			return true;
		}
		else
			return false;
	}
}
