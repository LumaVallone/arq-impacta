package pontos.desktop;

import java.util.Scanner;

import pontos.interfaces.IPontosProcess;
import pontos.interfaces.Mapeamento;

public class PontosDesktop {
	private IPontosProcess processo;
	
	public PontosDesktop(IPontosProcess processo){
		this.processo = processo;
	}
	
	public void consultarPontos(){
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite seu número identificador: ");
		
		int identificador = Integer.parseInt(entrada.nextLine());
		Mapeamento mapeamento = processo.getMapeamento();
		System.out.println();
		for(Character letra : mapeamento.getMapa().keySet()){
			Integer[] nums = mapeamento.getMapa().get(letra);
			System.out.println(nums[0] + " ou " + nums[1] + " > " + letra);
		}
		
		System.out.print("\nEntre as letras correspondentes aos números de sua senha: ");
		String letrasDigitadas = entrada.nextLine();
		int pontos = processo.getPontos(identificador, letrasDigitadas, mapeamento);
		System.out.println("Total de pontos: " + pontos);
		entrada.close();
	}
	
}
