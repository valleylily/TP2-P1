package bd;

public class Figura {
	private long idDesenho;
	private String figura;
	private int idFigura;
	
	public Figura(long idDesenho, String figura, int idFigura) throws Exception {
		this.setIdDesenho(idDesenho);
		this.setFigura(figura);
		this.setIdFigura(idFigura);
	}
	
	public Figura(long idDesenho, String figura, String sigla) throws Exception {
		this.setIdDesenho(idDesenho);
		this.setFigura(figura);
	}
	
	public Figura(Figura antigoFigura) throws Exception {
		this.setIdDesenho(antigoFigura.idDesenho);
		this.setFigura(antigoFigura.figura);
		this.setIdFigura(antigoFigura.idFigura);
	}
	
	

	public long getIdDesenho() {return idDesenho;}

	public String getFigura() {return figura;}

	public int getIdFigura() {return idFigura;}
	
	public void setIdFigura(int idFigura) throws Exception {
		if(idFigura < 1)
			throw new Exception("Valores não positivos não podem ser códigos Figura");
		this.idFigura = idFigura;
	}
	
	public void setIdDesenho(long idDesenho) throws Exception {
		if(idDesenho < 1)
			throw new Exception("Valores não positivos não são aceitos como códigos de Desenhos");
		this.idDesenho = idDesenho;
	}

	public void setFigura(String figura) throws Exception {
		if(""==figura || figura.length() > 50)
			throw new Exception("Tamanho do texto muito grande para uma Figura!");
		this.figura = figura;
	}
	
	public boolean equals(Figura outroVoo){
		if(this != outroVoo)
			if((this.idDesenho != outroVoo.idDesenho) || (this.figura != outroVoo.figura) || (this.idFigura != idFigura))
				return false;
		return true;
	}
	public Object clone(){
		Figura clone = null;
		try {clone = new Figura(this);}
		catch (Exception e){}
		return clone;
	}
	@SuppressWarnings("deprecation")
	public int hashCode(){
		int hash = 0;
		hash += 13*new Long(idDesenho).hashCode();
		hash += 13*figura.hashCode();
		hash += 13*new Integer(idFigura).hashCode();
		return hash;
		
	}
	public String toString(){
		return "Número do Figura: " + idDesenho +
			   "; figura: "         + figura    +
			   "; idFigura: "       + idFigura  + ".";
	}
}

