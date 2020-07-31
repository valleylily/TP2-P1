import java.util.Vector;

public class PedidoDeSalvamento extends Comunicado
{
    private String eMailDoDono;
    private String nome;
    private Vector<String> figuras;
    
    public PedidoDeSalvamento (String eMailDoDono, String nome, Vector<String> figuras)
    {
        this.eMailDoDono = eMailDoDono;
        this.nome    = nome;
        this.figuras    = figuras;
    }
    
    public String getEMailDoDono ()
    {
        return this.eMailDoDono;
    }
    
    public String getNome ()
    {
        return this.nome;
    }

	public Vector<String> getFiguras() {
		return this.figuras;
	}
    
    public String toString ()
    {
        return (""+this.eMailDoDono+this.nome);
    }
}
