package services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeituraArquivo {
	
	private static String path = "/Algoritmo CYK/arquivo/gramatica";
	
	public static ArrayList<?> retornaDadosArquivo() {
		
		List<String> retornoGramatica = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "ISO-8859-1")))
		{
			
		}
		catch (IOException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		return null;

	}

}
