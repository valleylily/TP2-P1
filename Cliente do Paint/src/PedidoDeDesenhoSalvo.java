public class PedidoDeDesenhoSalvo extends Comunicado{
	private String eMailDoDono;
    private String nome;
    
    public PedidoDeDesenhoSalvo (String eMailDoDono, String nome)
    {
        this.eMailDoDono = eMailDoDono;
        this.nome    = nome;
    }
    
    public String getEMailDoDono ()
    {
        return this.eMailDoDono;
    }
    
    public String getNome ()
    {
        return this.nome;
    }

    
    public String toString ()
    {
        return (""+this.eMailDoDono+this.nome);
    }
}
