package testes;

import java.util.ArrayList;
import java.util.List;

import services.LeituraArquivo;

public class Program {

	public static void main(String[] args) {

			
		List<?> retorno = new ArrayList<String>();
		

		try {
			retorno = LeituraArquivo.retornaDadosArquivo();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Object a : retorno) {
			System.out.println(a);
		}


	}

}
