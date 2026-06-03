package aplicacao;

import entidades.Chamado;
import entidades.Tecnico;

public class Program {

	public static void main(String[] args) {
		// 1. Criando o chamado
		Chamado chamado1 = new Chamado(1, "Roteador", "Sinal vermelho no equipamento");  
		
		// 2. Criando o objeto do técnico utilizando o construtor dele
		Tecnico tech1 = new Tecnico(1000, "Rodrigo", "Equipamentos de Redes");
		
		// 3. Passando o OBJETO completo para o chamado
		chamado1.atribuirTecnico(tech1);
		
		// 4. Testando a saída
		System.out.println(chamado1.toString());
		
		chamado1.resolverChamado();
		System.out.println(chamado1.toString());
	}
}
