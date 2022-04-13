package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(null, null);
      
      String commands[] = tk.retrieveCommands();
      Tabuleiro jogo = new Tabuleiro();
      if (jogo.getInicializouCorretamente()) {
    	  tk.writeBoard("Tabuleiro inicial", jogo.Apresenta());
    	  for (int l = 0; l < commands.length; l++) {
    		  jogo.comando(commands[l]);
    		  tk.writeBoard("source: " + commands[l].substring(0, 2) + "; target: " + commands[l].substring(3, 5), jogo.Apresenta());
    	  }
      }
      
      tk.stop();
   }

}
