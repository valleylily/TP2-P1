import java.io.*;
import java.net.*;
import java.util.*;

import bd.Desenho;
import bd.Desenhos;
import bd.Figura;
import bd.Figuras;

public class SupervisoraDeConexao extends Thread
{
    private Vector<String>         valor;
    private Parceiro             usuario;
    private Socket               conexao;
    private ArrayList<Parceiro> usuarios;

    public SupervisoraDeConexao
    (Socket conexao, ArrayList<Parceiro> usuarios)
    throws Exception
    {
        if (conexao==null)
            throw new Exception ("Conexao ausente");

        if (usuarios==null)
            throw new Exception ("Usuarios ausentes");

        this.conexao  = conexao;
        this.usuarios = usuarios;
    }
    private boolean vivo = true;

    public void run ()
    {

        ObjectOutputStream transmissor;
        try
        {
            transmissor =
            new ObjectOutputStream(
            this.conexao.getOutputStream());
        }
        catch (Exception erro)
        {
            return;
        }
        
        ObjectInputStream receptor=null;
        try
        {
            receptor=
            new ObjectInputStream(
            this.conexao.getInputStream());
        }
        catch (Exception err0)
        {
            try
            {
                transmissor.close();
            }
            catch (Exception falha)
            {} // so tentando fechar antes de acabar a thread
            
            return;
        }

        try
        {
            this.usuario =
            new Parceiro (this.conexao,
                          receptor,
                          transmissor);
        }
        catch (Exception erro)
        {} // sei que passei os parametros corretos
        
        try
        {
            synchronized (this.usuarios)
            {
                this.usuarios.add (this.usuario);
            }


            for(;vivo;) {
            	Comunicado comunicado = usuario.envie();
            	if(comunicado instanceof PedidoDeSalvamento) {
            		PedidoDeSalvamento pedido = (PedidoDeSalvamento) comunicado;
            		long hash = pedido.getNome().hashCode() + pedido.getEMailDoDono().hashCode();
            		Desenho desenho = new Desenho(hash, pedido.getEMailDoDono(), pedido.getNome());
            		Desenhos.incluir(desenho);
            	}
            	else if(comunicado instanceof PedidoDeDesenhoSalvo) {
            		PedidoDeDesenhoSalvo pedido = (PedidoDeDesenhoSalvo) comunicado;
            		long hash = pedido.getNome().hashCode() + pedido.getEMailDoDono().hashCode();
            		Desenho desenho = Desenhos.getDesenho(hash);
            		Vector<String> figuras = null;
            		for(int i = 0;;i++) {
            			Figura figura = Figuras.getFigura(i, hash);
            			if(!Figuras.registrado(i, hash))
            				break;
            			figuras.add(figura.getFigura());
            		}
            		usuario.receba(new DesenhoSalvo(figuras));
            	}
            }
            this.usuario.adeus();
        }
        catch(Exception erro) {
        	try {
        		transmissor.close();
        		receptor.close();
        	}
        	catch(Exception falha) {}
        	return;
        }
    }
    public void morra() {
    	vivo = false;
    }
}
