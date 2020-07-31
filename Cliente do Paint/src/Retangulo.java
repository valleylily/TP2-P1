import java.awt.Color;                                                   
import java.awt.Graphics;                                                
import java.util.StringTokenizer;                                        
/**<p>A classe <b>Retângulo</b> representa <i>Figuras</i> dotadas de duas dimensões – altura e largura –, de formato, como sugere o nome, retangular.</p>
 * <p>Por serem implementações da classe abstrata <i>Figura</i>, necessariamente, <b>retângulos</b> possuem uma cor e podem ser desenhados, tornados visíveis
 * em um elemento da classe <i>Graphics</i>, sendo ou não preenchidos. Seu propósito original de criação, portanto, foi trabalhar com figuras que
 * devessem ser desenhadas em uma instância de <i>Graphics</i>, entretanto, seu possível uso extende-se ao armazenamento e tratamento das principais
 * qualidades de um retângulo comum, como altula, largura e posição em um plano.</p>                                                                
 * @author Ian de Almeida Pinheiro & Gustavo Silveira Moda
 * @version 1.0
 * @since jul 2020
 */
public class Retangulo extends Bidimensional {
	public Retangulo(int x, int y, int largura, int altura) {
		this(x, y, largura, altura, Color.black);
	}
	public Retangulo(int x, int y, int largura, int altura, Color cor) {
		super(x, y, largura, altura, cor);
	}
	public Retangulo(String s) {
		super(s);
	}

	public void torneSeVisivel(Graphics g) {                             
		g.setColor(this.cor);                                            
		if(preenchido)                                                   
			g.fillRect(this.coordenadas.getX(), this.coordenadas.getY(), this.largura, this.altura);       
		else                                                             
			g.drawRect(this.coordenadas.x, this.coordenadas.y, this.largura, this.altura);       
	}                                                                    
                                                                         
	public String toString() {                                           
		return "Retangulo:" + this.coordenadas.x       +                    
				":"         + this.coordenadas.y       +                    
				":"         + this.getCor().getRed()   +                    
				":"         + this.getCor().getGreen() +                    
				":"         + this.getCor().getBlue()  +                    
	            ":"         + this.altura              +                    
	            ":"         + this.largura             ;                    
	}
}                                 