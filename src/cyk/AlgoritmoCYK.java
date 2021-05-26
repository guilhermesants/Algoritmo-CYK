package cyk;

import java.util.ArrayList;
import java.util.List;

import services.LeituraArquivo;

public class AlgoritmoCYK {
	
	public static void verificaPalavra(String palavra)
	{
		List<String> retorno = new ArrayList<String>();
		
		try {
			retorno = LeituraArquivo.retornaDadosArquivo("C:\\Repositorio\\Algoritmo-CYK\\src\\gramatica.txt");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		int tamanhoDaPalavra = palavra.length();
		
		String[][] matrizTabela = new String[tamanhoDaPalavra][tamanhoDaPalavra];
		
		String[] regra = null;
		
		for (int j = 0; j < tamanhoDaPalavra; j++) 
		{
			if (j < retorno.size()) 
			{
				regra = retorno.get(j).split(" ");
			}

			var simboloTerminal = regra[2];
			for (int z = 0; z < tamanhoDaPalavra; z++)
			{
				char simbolo = palavra.charAt(z);

				if (simboloTerminal.equals(String.valueOf(simbolo)))
				{
					matrizTabela[z][z] = regra[0];
				}
			}
		}

		
		// exibindo tabela
		for (int x = 0; x < matrizTabela.length; x++)
		{
			for (int z = 0; z < matrizTabela.length; z++)
			{
				System.out.print(matrizTabela[x][z] + "	");
			}
			System.out.println();
		}
	}

}
