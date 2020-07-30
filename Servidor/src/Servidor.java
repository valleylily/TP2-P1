import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Servidor {
	public static void main(String args[]) {
		Socket cliente = null;
		ServerSocket servidor = null;
		Scanner entrada = null;
		
		try {
			servidor = new ServerSocket(1313);
			cliente = servidor.accept();
			entrada = new Scanner(cliente.getInputStream());
		} catch (Exception e) {
			System.out.println("Deu errado ._.");
		}
		
		while(entrada.hasNextLine()) {
			System.out.println(entrada.nextLine());
		}
		
		entrada.close();
		try {
			servidor.close();
		} catch (IOException e) {
			System.out.println("Num quer fechar");
		}
	}
		
}
