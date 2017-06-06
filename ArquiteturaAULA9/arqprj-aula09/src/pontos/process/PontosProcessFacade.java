package pontos.process;

import pontos.interfaces.*;

public class PontosProcessFacade implements IPontosProcess {
	
	private IPontosBuisness negocios;
	private Mapeador mapeador;
	
	public PontosProcessFacade(IPontosBuisness negocios){
		this.negocios = negocios;
		mapeador = new Mapeador();
	}
	
	@Override
	public Mapeamento getMapeamento() {
		return mapeador.gerarMapeamento();
	}

	@Override
	public int getPontos(int identificador, String letras, Mapeamento mapeamento) {
		int pontos = -1;
		Participante p = negocios.find(identificador);
		String senha = p.getSenha();
		boolean autorizado = mapeador.validar(mapeamento, letras, senha);
		if(autorizado){
			pontos = p.getPontos();
		}
		return pontos;
	}

}
