package services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeituraArquivo {
	
	// "C:\\Repositorio\\Algoritmo-CYK\\src\\gramatica.txt";
	
	
	public static List<String> retornaDadosArquivo(String caminhoArquivo) throws IOException
	{
		List<String> retornoGramatica = new ArrayList<String>();
		
		FileInputStream arquivo = new FileInputStream(caminhoArquivo);
		InputStreamReader input = new InputStreamReader(arquivo);
		BufferedReader br = new BufferedReader(input);
		
		String line = br.readLine();
		
		while (true)
		{
			if (line != null) 
			{
				retornoGramatica.add(line);
			} 
			else 
			{
				break;
			}
			
			line = br.readLine();
		}
		br.close();

		return retornoGramatica;
	}
	
}
