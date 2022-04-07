package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      Animacao lombriga;
      
      for (int l = 0; l < lombrigas.length; l++) {
    	  tk.gravaPasso("=====");
      	  lombriga = new Animacao(lombrigas[l]);
      	  tk.gravaPasso(lombriga.apresenta());
      	  for (int i = 0; lombriga.isAlive(); i++) {
      		  lombriga.passo();
      		  tk.gravaPasso(lombriga.apresenta());
      	  }
      }
      
      tk.stop();
   }

}
