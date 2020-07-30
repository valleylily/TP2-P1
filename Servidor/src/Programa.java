
import java.net.Socket;
import java.io.PrintStream;

public class Programa {
	static Socket cliente;
	public static void main(String args[]) {
		try {
			cliente = new Socket("localhost", 1313);
			PrintStream escreve = new PrintStream(cliente.getOutputStream());
			escreve.println("Modafugg");
		} catch (Exception e) {
			System.out.println("Deu errado ._.");
		}
	}
}
