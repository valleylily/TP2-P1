import java.awt.Color;                                                   
import java.awt.Graphics;                                                
import java.util.StringTokenizer;                                        
                                                                         
public class Elipse extends Figura {                                     
	protected int x, y, altura, largura;                                 
	protected boolean preenchido = false;                                
                                                                         
	public Elipse(int x, int y, int largura, int altura) {               
		this(x, y, largura, altura, Color.BLACK);                        
	}                                                                    
                                                                         
	public Elipse(int x, int y, int largura, int altura, Color cor) {    
		super(cor);                                                      
		this.altura = altura;                                            
		this.largura = largura;                                          
		this.x = x;                                                      
		this.y = y;                                                      
	}                                                                    
                                                                         
	public Elipse(String s) {                                            
		StringTokenizer quebrador = new StringTokenizer(s, ":");         
                                                                         
		quebrador.nextToken();                                           
                                                                         
		this.x = Integer.parseInt(quebrador.nextToken());                
		this.y = Integer.parseInt(quebrador.nextToken());                
                                                                         
		this.cor = new Color(Integer.parseInt(quebrador.nextToken()),    
				Integer.parseInt(quebrador.nextToken()),                 
				Integer.parseInt(quebrador.nextToken()));                
		this.setLargura(Integer.parseInt(quebrador.nextToken()));        
		this.setAltura(Integer.parseInt(quebrador.nextToken()));         
	}                                                                    
                                                                         
	public void setX(int x) {                                            
		this.x = x;                                                      
	}                                                                    
                                                                         
	public void setY(int y) {                                            
		this.y = y;                                                      
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
		return this.x;                                                   
	}                                                                    
                                                                         
	public int getY() {                                                  
		return this.y;                                                   
	}                                                                    
                                                                         
	public int getAltura() {                                             
		return this.altura;                                              
	}                                                                    
	                                                                     
	public int getLargura() {                                            
		return this.largura;                                             
	}                                                                    
                                                                         
	public void torneSeVisivel(Graphics g) {                             
		g.setColor(this.cor);                                            
		if(preenchido)                                                   
			g.fillOval(this.x, this.y, this.largura, this.altura);       
		else                                                             
			g.drawOval(this.x, this.y, this.largura, this.altura);       
	}                                                                    
                                                                         
	public String toString() {                                           
		return "Elipse:" + this.x                   +                    
				":"      + this.y                   +                    
				":"      + this.getCor().getRed()   +                    
				":"      + this.getCor().getGreen() +                    
				":"      + this.getCor().getBlue()  +                    
	            ":"      + this.altura              +                    
	            ":"      + this.largura             ;                    
	}                                                                    
}                                                                        