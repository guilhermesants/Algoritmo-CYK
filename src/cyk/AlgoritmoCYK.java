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
		
		String[][] matrizRegra = FormataRetorno(retorno);
		
		int tamanhoDaPalavra = palavra.length();
		
		String[][] matrizTabela = new String[tamanhoDaPalavra][tamanhoDaPalavra];
		
		PreencheMatrizVazia(matrizTabela);
		
		String[] regra = null;
		
		
		for (int p = 0; p < matrizRegra.length; p++)
		{
			for (int j = 0; j < tamanhoDaPalavra; j++) 
			{
				String caracterTerminal = matrizRegra[p][1];

				for (int z = 0; z < tamanhoDaPalavra; z++)
				{
					char simbolo = palavra.charAt(z);
	
					if (caracterTerminal.equals(String.valueOf(simbolo)))
					{
						matrizTabela[z][z] = matrizRegra[p][0];
					}
				}
			}
		}

		for (int i = 2; i < tamanhoDaPalavra; i++)
		{
			for (int h = 1; h < tamanhoDaPalavra - i + 1; h++)
			{
				int j = h + i - 1;
				for (int k = h; k < j; k++)
				{
					String caractere = analizaSubstring(matrizRegra, matrizTabela, h, j, k);
					if (!matrizTabela[h][j].contains(caractere))
					{
						matrizTabela[h][j] += caractere;
					}
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
		
		System.out.println(verificaPalavra(matrizTabela, matrizRegra));

	}
	
	private static String verificaPalavra(String[][] matrizTabela, String[][] matrizRegras)
	{
		if (matrizTabela[1][matrizTabela.length - 1].contains(matrizRegras[0][0]))
		{
			return "Palavra aceita";
		}


		for (int i = 2; i < tamanhoDaPalavra; i++)
		{
			for (int h = 1; h < tamanhoDaPalavra - i + 1; h++)
			{
				int j = h + i - 1;
				for (int k = h; k < j; k++)
				{
					String caractere = analizaSubstring(retorno, matrizTabela, h, j, k);
					if (!matrizTabela[h][j].contains(caractere))
					{
						matrizTabela[h][j] = caractere;
					}
				}
			}
		}

	}
	
	private static String analizaSubstring(List<String> retornoGramatica, String[][] matriz, int inicial, int Final, int divisao)
	{
		String[][] matrizDeRegras = new String[retornoGramatica.size()][retornoGramatica.size()];
		
		for (int i = 0; i < matrizDeRegras.length; i++)
		{

			String[] retorno = retornoGramatica.get(i).split(" ");
			matrizDeRegras[i] = retorno;
		}
		
		
		String ret = "";
		
		for (int i = 0; i < matrizDeRegras.length; i++)
		{
			
			String b = matrizDeRegras[i][2];
			String c = matrizDeRegras[i][3];
			
			var primeiro = matriz[inicial][divisao].contains(b);
			var segundo = matriz[divisao + 1][Final].contains(c);
			
			if (primeiro && segundo)
			{
				ret = ret + " " + matrizDeRegras[i][0];
			}
		}
		
		
		return ret;
	}
	
	
	public static String[][] FormataRetorno(List<String> retorno)
	{
		String[][] matrizRegras = new String[retorno.size()][retorno.size()];
		
		int i = 0;
		for (String regra : retorno)
		{
			String caracterDaEsquerda = simbolosEsquerda(regra);
			String[] caracteresDireita = simbolosDireita(regra);
			
			
			matrizRegras[i][0] = caracterDaEsquerda;

			for (int j = 0; j < caracteresDireita.length; j++)
			{
				matrizRegras[i][j + 1] = caracteresDireita[j];
			}
			i++;
		}
		
		return matrizRegras;
	}
	
	private static String simbolosEsquerda(String regra)
	{
		String[] caracteres = retornaVetor(regra);
		String caracterEsquerdo = caracteres[0];
		return caracterEsquerdo;
	}
	
	private static String[] simbolosDireita(String regra)
	{
		String[] caracteres = retornaVetor(regra);
		String[] caracteresDireita = caracteres[1].split("\\|");
		return caracteresDireita;
	}
	
	private static String[] retornaVetor(String regra)
	{
		String[] caracteres = regra.replace(" ", "").split("=>");
		return caracteres;
	}
	
	private static String analizaSubstring(String[][] matrizDeRegras, String[][] matriz, int inicial, int Final, int divisao)
	{
		
		String ret = "";
		
		for (int i = 0; i < matrizDeRegras.length; i++)
		{
			
			String b = matrizDeRegras[i][2];
			String c = matrizDeRegras[i][3];
			
			var primeiro = matriz[inicial][divisao].contains(b);
			var segundo = matriz[divisao + 1][Final].contains(c);
			
			if (primeiro && segundo)
			{
				ret = ret + "" + matrizDeRegras[i][0];
			}
		}
		
		
		return ret;
	}	
	
	public static String[][] FormataRetorno(List<String> retorno)
	{
		String[][] matrizRegras = new String[retorno.size()][retorno.size()];
		
		int i = 0;
		for (String regra : retorno)
		{
			String caracterDaEsquerda = simbolosEsquerda(regra);
			String[] caracteresDireita = simbolosDireita(regra);
			
			
			matrizRegras[i][0] = caracterDaEsquerda;

			for (int j = 0; j < caracteresDireita.length; j++)
			{
				matrizRegras[i][j + 1] = caracteresDireita[j];
			}
			i++;
		}
		
		substituiNulidade(matrizRegras);
		
		return matrizRegras;
	}
	
	private static String simbolosEsquerda(String regra)
	{
		String[] caracteres = retornaVetor(regra);
		String caracterEsquerdo = caracteres[0];
		return caracterEsquerdo;
	}
	
	private static String[] simbolosDireita(String regra)
	{
		String[] caracteres = retornaVetor(regra);
		String[] caracteresDireita = caracteres[1].split("\\|");
		return caracteresDireita;
	}
	
	private static String[] retornaVetor(String regra)

	{
		String[] caracteres = regra.replace(" ", "").split("=>");
		return caracteres;
	}

	private static void PreencheMatrizVazia(String[][] matrizTabela)
	{
		for (int i = 0; i < matrizTabela.length; i++)
		{
			for (int j = 0; j < matrizTabela.length; j++)
			{
				matrizTabela[i][j] = "";
			}
		}
	}
	
	private static void substituiNulidade(String[][] matrizRegras)
	{
		for (int i = 0; i < matrizRegras.length; i++)
		{
			for (int j = 0; j < matrizRegras.length; j++)
			{
				if (matrizRegras[i][j] == null) matrizRegras[i][j] = "";
			}
		}
	}


}
