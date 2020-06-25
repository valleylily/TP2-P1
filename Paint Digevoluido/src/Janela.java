import java.awt.*;                                                                                         //
import java.awt.event.*;                                                                                   //
import javax.swing.*;                                                                                      //
import javax.imageio.*;                                                                                    //
import java.io.*;                                                                                          //
import java.util.*;                                                                                        //
//INÍCIO DA CLASSE!
public class Janela extends JFrame                                                                         //Início da classe janela.
{                                                                                                          //
    protected static final long serialVersionUID = 1L;                                                     //Número de série da classe.
//-----------------------------------------------------------------------------------------------------------Declaração de atributos:
    protected JButton btnPonto     = new JButton ("Ponto"),                                                //------------------------botões;
                      btnLinha     = new JButton ("Linha"),                                                //-----------------------/
                      btnCirculo   = new JButton ("Circulo"),                                              //-----------------------/
                      btnElipse    = new JButton ("Elipse"),                                               //-----------------------/
                      btncorFigura   = new JButton ("Fora"),                                                 //-----------------------/
                      btnCorDentro = new JButton ("Dentro"),                                               //-----------------------/
                      btnAbrir     = new JButton ("Abrir"),                                                //-----------------------/
                      btnSalvar    = new JButton ("Salvar");                                               //-----------------------/
                                                                                                           //-----------------------/
    protected MeuJPanel pnlDesenho = new MeuJPanel ();                                                     //------------------------painéis;
                                                                                                           //-----------------------/
    protected JLabel statusBar1 = new JLabel ("Mensagem:"),                                                //------------------------labels;
                     statusBar2 = new JLabel ("Coordenada:");                                              //-----------------------/
                                                                                                           //-----------------------/
    protected Color corFigura = Color.BLACK;                                                                 //------------------------cores;
    protected Color corDentro = new Color(0, 0, 0, 1);
    
    protected boolean dentro = false;
    
    protected Ponto p1;                                                                                    //------------------------pontos;
                                                                                                           //-----------------------/
    protected Situacao situacao = Situacao.DEFAULT;                                                        //------------------------situação;
    protected Vector<Figura> figuras = new Vector<Figura>();                                               //------------------------Vector de Figuras;
//-----------------------------------------------------------------------------------------------------------Construtores:
    public Janela ()                                                                                       //------------------------Janela;
    {                                                                                                      //-----------------------/
        super("Editor Gráfico");                                                                           //------------------------Construtor herdado de JFrame;
                                                                                                           //-----------------------/
        try                                                                                                //-----------------------tenta:
        {                                                                                                  //----------------------/
            Image btnAbrirImg = ImageIO.read(getClass().getResource("resources/abrir.jpg"));
            btnAbrir.setIcon(new ImageIcon(btnAbrirImg));
        }                                                                                                  //----------------------/
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo abrir.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }                                                                                                  //----------------------/

        try                                                                                                //-----------------------tenta:
        {                                                                                                  //----------------------/
            Image btnSalvarImg = ImageIO.read(getClass().getResource("resources/salvar.jpg"));
            btnSalvar.setIcon(new ImageIcon(btnSalvarImg));
        }                                                                                                  //----------------------/
        catch (IOException e)
        {                                                                                                  //----------------------/
            JOptionPane.showMessageDialog (null,
                                           "Arquivo salvar.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }                                                                                                  //----------------------/

        try
        {                                                                                                  //----------------------/
            Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));
            btnPonto.setIcon(new ImageIcon(btnPontoImg));
        }                                                                                                  //----------------------/
        catch (IOException e)
        {                                                                                                  //----------------------/
            JOptionPane.showMessageDialog (null,
                                           "Arquivo ponto.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }                                                                                                  //----------------------/

        try                                                                                                //-----------------------tenta:
        {                                                                                                  //----------------------/
            Image btnLinhaImg = ImageIO.read(getClass().getResource("resources/linha.jpg"));
            btnLinha.setIcon(new ImageIcon(btnLinhaImg));
        }                                                                                                  //----------------------/
        catch (IOException e)
        {                                                                                                  //----------------------/
            JOptionPane.showMessageDialog (null,
                                           "Arquivo linha.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }                                                                                                  //----------------------/

        try                                                                                                //-----------------------tenta:
        {                                                                                                  //----------------------/
            Image btnCirculoImg = ImageIO.read(getClass().getResource("resources/circulo.jpg"));
            btnCirculo.setIcon(new ImageIcon(btnCirculoImg));
        }                                                                                                  //----------------------/
        catch (IOException e)
        {                                                                                                  //----------------------/
            JOptionPane.showMessageDialog (null,
                                           "Arquivo circulo.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }                                                                                                  //----------------------/

        try                                                                                                //-----------------------tenta:
        {                                                                                                  //----------------------/
            Image btnElipseImg = ImageIO.read(getClass().getResource("resources/elipse.jpg"));
            btnElipse.setIcon(new ImageIcon(btnElipseImg));
        }                                                                                                  //----------------------/
        catch (IOException e)
        {                                                                                                  //----------------------/
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }                                                                                                  //----------------------/

        try                                                                                                //-----------------------tenta:
        {                                                                                                  //----------------------/
            Image btncorFiguraImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btncorFigura.setIcon(new ImageIcon(btncorFiguraImg));
        }                                                                                                  //----------------------/
        catch (IOException e)
        {                                                                                                  //----------------------/
            JOptionPane.showMessageDialog (null,
                                           "Arquivo cores.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }                                                                                                  //----------------------/

        try                                                                                                //-----------------------tenta:
        {                                                                                                  //----------------------/
            Image btnCorDentroImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCorDentro.setIcon(new ImageIcon(btnCorDentroImg));
        }
        catch (IOException e)
        {                                                                                                  //----------------------/
            JOptionPane.showMessageDialog (null,
                                           "Arquivo cores.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }                                                                                                  //----------------------/

        
        btnPonto.addActionListener     (new DesenhoDePonto());                                             //------------------------Adiciona função para o clicar do btnPonto
        btnLinha.addActionListener     (new DesenhoDeReta ());                                             //------------------------Adiciona função para o clicar do btnLinha
        btnCirculo.addActionListener   (new DesenhoDeCirculo());
        btnElipse.addActionListener    (new DesenhoDeElipse());
        btncorFigura.addActionListener   (new PegarCorDeFora());
        btnCorDentro.addActionListener (new PegarCorDeDentro());
        
        JPanel     pnlBotoes = new JPanel();
        FlowLayout flwBotoes = new FlowLayout(); 
        pnlBotoes.setLayout (flwBotoes);

        pnlBotoes.add (btnAbrir);
        pnlBotoes.add (btnSalvar);
        pnlBotoes.add (btnPonto);
        pnlBotoes.add (btnLinha);
        pnlBotoes.add (btnCirculo);
        pnlBotoes.add (btnElipse);
        pnlBotoes.add (btncorFigura);
        pnlBotoes.add (btnCorDentro);

        JPanel     pnlStatus = new JPanel();
        GridLayout grdStatus = new GridLayout(1,2);
        pnlStatus.setLayout(grdStatus);

        pnlStatus.add(statusBar1);
        pnlStatus.add(statusBar2);

        Container cntForm = this.getContentPane();
        cntForm.setLayout (new BorderLayout());
        cntForm.add (pnlBotoes,  BorderLayout.NORTH);
        cntForm.add (pnlDesenho, BorderLayout.CENTER);
        cntForm.add (pnlStatus,  BorderLayout.SOUTH);
        
        this.addWindowListener (new FechamentoDeJanela());

        this.setSize (800,600);
        this.setVisible (true);
    }
//-----------------------------------------------------------------------------------------------------------Classes auxiliares internas:
    protected class MeuJPanel extends    JPanel 
                              implements MouseListener,
                                         MouseMotionListener
    {
    	public MeuJPanel()
        {
            super();

            this.addMouseListener       (this);
            this.addMouseMotionListener (this);
        }

        public void paint (Graphics g)
        {
            for (int i=0 ; i<figuras.size(); i++)
                figuras.get(i).torneSeVisivel(g);
        }
        
        public void mousePressed (MouseEvent e)
        {
        	switch(situacao) {
	        	case ESPERANDO_PONTO:
	        		figuras.add (new Ponto (e.getX(), e.getY(), corFigura));
	        		figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
	        		situacao = Situacao.DEFAULT;
	        		break;
	        	case ESPERANDO_INICIO_RETA:
	        		p1 = new Ponto (e.getX(), e.getY(), corFigura);
	        		situacao = Situacao.ESPERANDO_FIM_RETA;
	        		statusBar1.setText("Mensagem: clique o ponto final da reta"); 
	        		break;
	        	case ESPERANDO_FIM_RETA:
	        		situacao = Situacao.DEFAULT;
	                figuras.add (new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corFigura));
	                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
	                statusBar1.setText("Mensagem:");
	                break;
	        	case ESPERANDO_INICIO_CIRCULO:
	        		p1 = new Ponto (e.getX(), e.getY(), corFigura);
	        		situacao = Situacao.ESPERANDO_FIM_CIRCULO;
	        		statusBar1.setText("Mensagem: clique o ponto final do círculo"); 
	        		break; 
	        	case ESPERANDO_FIM_CIRCULO:
	        		situacao = Situacao.DEFAULT;
	        		int dimensao;
	        		if((e.getX() - p1.getX()) > (e.getY() - p1.getY()))
	        			dimensao = (e.getY() - p1.getY());
	        		else
	        			dimensao = (e.getX() - p1.getX());
	        		Circulo circulo = new Circulo(p1.getX(), p1.getY(), dimensao, corFigura);
	        		circulo.setPreenchido(dentro);
	                figuras.add (circulo);
	                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
	                statusBar1.setText("Mensagem:");
	                break;
	        	case ESPERANDO_INICIO_ELIPSE:
	        		p1 = new Ponto (e.getX(), e.getY(), corFigura);
	        		situacao = Situacao.ESPERANDO_FIM_ELIPSE;
	        		statusBar1.setText("Mensagem: clique o ponto final da elipse"); 
	        		break;
	        	case ESPERANDO_FIM_ELIPSE:
	        		situacao = Situacao.DEFAULT;
	        		Elipse elipse = new Elipse(p1.getX(), p1.getY(), (e.getX() - p1.getX()), (e.getY() - p1.getY()), corFigura);
	        		elipse.setPreenchido(dentro);
	        		figuras.add (elipse);
	                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
	                statusBar1.setText("Mensagem:");
	                break;
	        	case DEFAULT: 
	        		statusBar1.setText("Mensagem:");
	        		break;
				default: break;
        	}
        } 
        public void mouseReleased (MouseEvent e)
        {}
        
        public void mouseClicked (MouseEvent e)
        {}
        
        public void mouseEntered (MouseEvent e)
        {}

        public void mouseExited (MouseEvent e)
        {}
        
        public void mouseDragged(MouseEvent e)
        {}

        public void mouseMoved(MouseEvent e)
        {
            statusBar2.setText("Coordenada: " + e.getX() + "," + e.getY());
        }
    }
    
    protected enum Situacao{
    	ESPERANDO_PONTO,
    	ESPERANDO_INICIO_RETA,
    	ESPERANDO_FIM_RETA,
    	ESPERANDO_INICIO_CIRCULO,
    	ESPERANDO_FIM_CIRCULO,
    	ESPERANDO_INICIO_ELIPSE,
    	ESPERANDO_FIM_ELIPSE,
    	DEFAULT;
    }
    
    protected class DesenhoDePonto implements ActionListener
    {
          public void actionPerformed (ActionEvent e)    
          {
              situacao = Situacao.ESPERANDO_PONTO;

              statusBar1.setText("Mensagem: clique o local do ponto desejado");
          }
    }

    protected class DesenhoDeReta implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
        	situacao = Situacao.ESPERANDO_INICIO_RETA;

            statusBar1.setText("Mensagem: clique o ponto inicial da reta");
        }
    }
    
    protected class DesenhoDeCirculo implements ActionListener
    {
    	public void actionPerformed (ActionEvent e)
    	{
    		situacao = Situacao.ESPERANDO_INICIO_CIRCULO;

            statusBar1.setText("Mensagem: clique o ponto inicial do círculo");
    	}
    }
    
    protected class DesenhoDeElipse implements ActionListener
    {
    	public void actionPerformed (ActionEvent e)
    	{
    		situacao = Situacao.ESPERANDO_INICIO_ELIPSE;

            statusBar1.setText("Mensagem: clique o ponto inicial da elipse");
    	}
    }
    
    protected class PegarCorDeFora implements ActionListener
    {
    	public void actionPerformed (ActionEvent e)
    	{
    		corFigura = JColorChooser.showDialog(Janela.this, "Selecione uma cor", corFigura);
    		dentro = false;
    	}
    }
    
    protected class PegarCorDeDentro implements ActionListener
    {
    	public void actionPerformed (ActionEvent e)
    	{
    		corFigura = JColorChooser.showDialog(Janela.this, "Selecione uma cor", corFigura);
    		dentro = true;
    	}
    }

    protected class FechamentoDeJanela extends WindowAdapter
    {
        public void windowClosing (WindowEvent e)
        {
            System.exit(0);
        }
    }
}
//FIM DA CLASSE!