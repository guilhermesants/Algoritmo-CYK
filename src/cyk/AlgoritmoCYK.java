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
		
		// criando um vetor de caracteres com tamanhdo da string passado
		char[] vetorCaracteres = new char[tamanhoDaPalavra];
		
		
		for (int a = 0; a < tamanhoDaPalavra; a++) {
			vetorCaracteres[a] = palavra.charAt(a);
		}
		
		
		String[][] matrizTabela = new String[tamanhoDaPalavra][tamanhoDaPalavra];
		
		String[] regra = null;
		for (int i = 0; i < tamanhoDaPalavra; i++)
		{
			
			if (i < retorno.size()) 
			{
				regra = retorno.get(i).split(" ");
			}
			
			String caractere = String.valueOf(palavra.charAt(i));

			for (int j = 0; j < regra.length; j++) 
			{
				if (regra[j].equals(caractere))
				{
					matrizTabela[i][i] = regra[0];
				}
			}

		}


		for (int x = 0; x < matrizTabela.length; x++)
		{
			for (int z = 0; z < matrizTabela.length; z++)
			{
				System.out.print(matrizTabela[x][z] + " ");
			}
			System.out.println();
		}
		
		
	}

}
