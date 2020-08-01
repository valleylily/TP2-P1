import java.util.*;

public class Servidor
{
	public static String PORTA_PADRAO = "3000";
	
    public static void main (String[] args)
    {
    	System.out.println("Rodando, irmão");
        if (args.length>1)
        {
            System.err.println ("Uso esperado: java Servidor [PORTA]\n");
            return;
        }

        String porta=Servidor.PORTA_PADRAO;
        
        if (args.length==1)
            porta = args[0];

        ArrayList<Parceiro> usuarios =
        new ArrayList<Parceiro> ();

        AceitadoraDeConexao aceitadoraDeConexao=null;
        try
        {
            aceitadoraDeConexao =
            new AceitadoraDeConexao (porta, usuarios);
            aceitadoraDeConexao.start();
        }
        catch (Exception erro)
        {
            System.err.println ("Escolha uma porta apropriada e liberada para uso!\n");
            return;
        }
        for(boolean vivo = true;vivo;) {
        	String comando = Teclado.getUmString();
        	if(comando == "morra") {
        		aceitadoraDeConexao.morra();
        		vivo = false;
        	}
        }
        System.exit(0);
    }
}
