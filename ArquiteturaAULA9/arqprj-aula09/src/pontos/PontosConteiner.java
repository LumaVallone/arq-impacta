package pontos;

import pontos.buisness.ParticipanteArq;
import pontos.desktop.PontosDesktop;
import pontos.interfaces.IPontosBuisness;
import pontos.interfaces.IPontosProcess;
import pontos.process.PontosProcessFacade;

public class PontosConteiner {
	public static void main(String[] args) {
		IPontosBuisness negocios = new ParticipanteArq("Pontos.txt");
		IPontosProcess processo = new PontosProcessFacade(negocios);
		PontosDesktop desktop = new PontosDesktop(processo);
		desktop.consultarPontos();
	}
}
