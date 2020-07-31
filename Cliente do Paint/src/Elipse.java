import java.awt.Color;                                                   
import java.awt.Graphics;                                     
                                                                         
public class Elipse extends Bidimensional {                                     
	public Elipse(int x, int y, int largura, int altura) {               
		this(x, y, largura, altura, Color.BLACK);                        
	}                                                                    
                                                                         
	public Elipse(int x, int y, int largura, int altura, Color cor) {    
		super(x, y, largura, altura, cor);                                                    
	}                                                                    
                                                                         
	public Elipse(String s) {                                            
		super(s);         
	}                                                                                                 
                                                                         
	public void torneSeVisivel(Graphics g) {                             
		g.setColor(this.cor);                                            
		if(preenchido)                                                   
			g.fillOval(this.coordenadas.x, this.coordenadas.y, this.largura, this.altura);       
		else                                                             
			g.drawOval(this.coordenadas.x, this.coordenadas.y, this.largura, this.altura);       
	}                                                                    
                                                                         
	public String toString() {                                           
		return "Elipse:" + this.coordenadas.x       +                    
				":"      + this.coordenadas.y       +                    
				":"      + this.getCor().getRed()   +                    
				":"      + this.getCor().getGreen() +                    
				":"      + this.getCor().getBlue()  +                    
	            ":"      + this.altura              +                    
	            ":"      + this.largura             ;                    
	}                                                                    
}                                                                        