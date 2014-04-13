

import java.nio.file.Path;
import java.nio.file.Paths;

import br.org.catolicasc.bsi.labirinto.controle.Controle;

public class App {
	public static void main(String[] args) {

		
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);
		

	}
}
