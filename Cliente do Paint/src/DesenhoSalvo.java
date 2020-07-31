import java.util.Vector;

public class DesenhoSalvo extends Comunicado
{
    private Vector<String> desenhoSalvo;

    public DesenhoSalvo (Vector<String> desenhoSalvo)
    {
        this.desenhoSalvo = desenhoSalvo;
    }

    public Vector<String> getFiguras ()
    {
        return this.desenhoSalvo;
    }
    
    public String toString ()
    {
		return (""+this.desenhoSalvo);
	}

}
