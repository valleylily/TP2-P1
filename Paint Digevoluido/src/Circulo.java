import java.awt.Color;

public class Circulo extends Elipse
{
	public Circulo (int x, int y, int dimensao)
    {
        this (x, y, dimensao, Color.BLACK);
    }
	
    public Circulo (int x, int y,  int dimensao, Color cor)
    {
        super(x, y, dimensao, dimensao, cor);
    }

    public Circulo (String s)
    {
        super(s);
    }
    
    public void setDimensao(int dimensao){
    	this.altura = this.largura = dimensao;
    }
    
    @Override
    public void setAltura(int altura) {
    	setDimensao(altura);
	}
    
    @Override
	public void setLargura(int largura) {
		setDimensao(largura);
	}
    
    public int getDimensao()
    {
        return this.altura;
    }

    @Override
    public String toString()
    {
        return "Círculo:" + this.x                   +
               ":"        + this.y                   +
               ":"        + this.getCor().getRed()   +
               ":"        + this.getCor().getGreen() +
               ":"        + this.getCor().getBlue()  +
               ":"        + this.altura              +
               ":"        + this.largura             ;
    } 
}