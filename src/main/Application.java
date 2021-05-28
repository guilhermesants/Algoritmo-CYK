package main;

import java.util.Scanner;

import cyk.AlgoritmoCYK;

public class Application {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Informe a cadeia de caracteres (palavra) que deseja verificar: ");
		String palavra = scan.next();

		System.out.print("Informe o caminho do arquivo que contém a gramática: ");
		String caminhoArquivo = scan.next();
		
		AlgoritmoCYK.verificaPalavra(palavra, caminhoArquivo);
	}

}
