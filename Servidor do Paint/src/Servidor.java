import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class Servidor
{
	public static String PORTA_PADRAO = "40000";
    private static AceitadoraDeConexao aceitadoraDeConexao = null;
	private static JFrame frame = new JFrame();
    private static boolean vivo = true;
	
    @SuppressWarnings("deprecation")
	public static void main (String[] args)
    {
    	frame.setSize(200, 200);
    	JButton btnMorra = new JButton("Morra");
    	Matadora matadora = new Matadora();
    	btnMorra.addActionListener(matadora);
    	frame.show();
    	
    	frame.add(btnMorra);
    	
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
        for(;vivo;) {}
        System.exit(0);
    }
    @SuppressWarnings("deprecation")
	private static void morra() {
    	if(aceitadoraDeConexao != null)
    		aceitadoraDeConexao.morra();
    	frame.hide();
		vivo = false;
		
    }
    private static class Matadora implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			morra();
		}
	}
}
