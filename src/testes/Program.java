package testes;

import java.util.ArrayList;
import java.util.List;

import cyk.AlgoritmoCYK;
import services.LeituraArquivo;

public class Program {

	public static void main(String[] args) {

		String caminhoArquivo = "C:\\Repositorio\\Algoritmo-CYK\\src\\gramatica.txt";
			
		List<?> retorno = new ArrayList<String>();
		

		try {
			retorno = LeituraArquivo.retornaDadosArquivo(caminhoArquivo);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Object a : retorno) {
			System.out.println(a);
		}

		AlgoritmoCYK.verificaPalavra("abaab");

	}

}
