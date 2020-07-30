import java.awt.*;
import java.util.StringTokenizer;

public abstract class Bidimensional extends Figura {
	protected int altura, largura; 
	protected Ponto coordenadas;

	protected boolean preenchido = false;
	
	public Bidimensional(int x, int y, int largura, int altura) {               
		this(x, y, largura, altura, Color.BLACK);                        
	}                                                                    
                                                                         
	public Bidimensional(int x, int y, int largura, int altura, Color cor) {    
		super(cor);                                                      
		this.altura = altura;                                            
		this.largura = largura;                                          
		this.coordenadas = new Ponto(x, y);                                            
	}
	
	public Bidimensional(String s) {     
		StringTokenizer quebrador = new StringTokenizer(s, ":");         
                                                                         
		quebrador.nextToken();                                           
                                                                         
		this.coordenadas.x = Integer.parseInt(quebrador.nextToken());                
		this.coordenadas.y = Integer.parseInt(quebrador.nextToken());                
                                                                         
		this.cor = new Color(Integer.parseInt(quebrador.nextToken()),    
				Integer.parseInt(quebrador.nextToken()),                 
				Integer.parseInt(quebrador.nextToken()));                
		this.setLargura(Integer.parseInt(quebrador.nextToken()));        
		this.setAltura(Integer.parseInt(quebrador.nextToken()));         
	}    
	
	public void setX(int x) {                                            
		this.coordenadas.setX(x);                                                      
	}                                                                    
                                                                         
	public void setY(int y) {                                            
		this.coordenadas.setY(y);                                                   
	}                                                                    
                                                                         
	public void setAltura(int altura) {                                  
		this.altura = altura;                                            
	}                                                                    
	                                                                     
	public void setLargura(int largura) {                                
		this.largura = largura;                                          
	}                                                                    
	                                                                     
	public void setPreenchido(boolean preenchido) {                      
		this.preenchido = preenchido;                                    
	}                                                                    
                                                                         
	public int getX() {                                                  
		return this.coordenadas.getX();                                                   
	}                                                                    
                                                                         
	public int getY() {                                                  
		return this.coordenadas.getY();                                                   
	}                                                                    
                                                                         
	public int getAltura() {                                             
		return this.altura;                                              
	}                                                                    
	                                                                     
	public int getLargura() {                                            
		return this.largura;                                             
	}
}
