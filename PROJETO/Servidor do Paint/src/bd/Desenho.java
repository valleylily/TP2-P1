package bd;

public class Desenho {
	private long idDesenho;
	private String eMailDoDono;
	private String nome;
	
	public Desenho(long idDesenho, String eMailDoDono, String nome) throws Exception {
		this.setIdDesenho(idDesenho);
		this.setEMailDoDono(eMailDoDono);
		this.setnome(nome);
	}
	
	public Desenho(Desenho antigoAeroporto) throws Exception {
		this.setIdDesenho(antigoAeroporto.idDesenho);
		this.setEMailDoDono(antigoAeroporto.eMailDoDono);
		this.setnome(antigoAeroporto.nome);
	}
	
	

	public long getIdDesenho() {return idDesenho;}

	public String getEMailDoDono() {return eMailDoDono;}

	public String getNome() {return nome;}
	
	
	public void setIdDesenho(long idDesenho) throws Exception {
		if(idDesenho<=0)
			throw new Exception("Código do desenho inválido.");
		this.idDesenho = idDesenho;
	}

	public void setEMailDoDono(String eMailDoDono) throws Exception {
		if(""==eMailDoDono || eMailDoDono.length() >= 100)
			throw new Exception("Tamanho inválido para email.");
		this.eMailDoDono = eMailDoDono;
	}

	public void setnome(String nome) throws Exception {
		if(""==nome || nome.length() > 100)
			throw new Exception("Tamanho inválido para nome.");
		this.nome = nome.toUpperCase();
	}
	
	public boolean equals(Desenho outroVoo){
		if(this != outroVoo)
			if((this.idDesenho != outroVoo.idDesenho) || (this.eMailDoDono != outroVoo.eMailDoDono) || (this.nome != outroVoo.nome))
				return false;
		return true;
	}
	public Object clone(){
		Desenho clone = null;
		try {clone = new Desenho(this);}
		catch (Exception e){}
		return clone;
	}
	@SuppressWarnings("deprecation")
	public int hashCode(){
		int hash = 0;
		hash += 13*new Long(idDesenho).hashCode();
		hash += 13*eMailDoDono.hashCode();
		hash += 13*nome.hashCode();
		return hash;
		
	}
	public String toString(){
		return "Número do aeroporto: " + idDesenho   +
			   "; eMailDoDono: "       + eMailDoDono +
			   "; nome: "              + nome        + ".";
	}
}
