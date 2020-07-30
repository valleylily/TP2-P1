import java.awt.*;                                                                                                   // I
import java.awt.event.*;                                                                                             // M
import javax.swing.*;                                                                                                // P
import javax.imageio.*;                                                                                              // O
import java.io.*;                                                                                                    // R
import java.util.*;                                                                                                  // T
//IN�CIO DA CLASSE!                                                                                                
public class Janela extends JFrame                                                                                   //In�cio da classe janela.
{                                                                                                                   //
    protected static final long serialVersionUID = 1L;                                                              //N�mero de s�rie da classe.
                                                                                                                    //-----Declara��o de atributos:
    protected JButton btnPonto     = new JButton ("Ponto"),                                                        //Bot�o para desenhar ponto;
                      btnLinha     = new JButton ("Linha"),                                                        //Bot�o para desenhar linha;
                      btnCirculo   = new JButton ("Circulo"),                                                      //Bot�o para desenhar c�rculo;
                      btnElipse    = new JButton ("Elipse"),                                                       //Bot�o para desenhar elipse;
                      btnCorFigura = new JButton ("Fora"),                                                         //Bot�o para escolher a cor do contorno da figura;
                      btnCorDentro = new JButton ("Dentro"),                                                       //Bot�o para escolhr a cor do preenchimento da figura;
                      btnAbrir     = new JButton ("Abrir"),                                                        //Bot�o para abrir uma imagem sua;
                      btnRetangulo = new JButton ("Ret�ngulo"),                                                    //Bot�o para desenhar um ret�ngulo;
                      btnQuadrado  = new JButton ("Quadrado"),                                                     //Bot�o para desenhar um quadrado;
                      btnSalvar    = new JButton ("Salvar");                                                       //Bot�o para salvar a sua imagem;
                                                                                                                   //
    protected MeuJPanel pnlDesenho = new MeuJPanel ();                                                             //Painel onde os desenhos ser�o feitos;
                                                                                                                   //
    protected JLabel statusBar1 = new JLabel ("Mensagem:"),                                                        //Barra que sinaliza mensagens;
                     statusBar2 = new JLabel ("Coordenada:");                                                      //Barra inferior que sinaliza coordenadas do cursor;
                                                                                                                   //
    protected Color corFigura = Color.BLACK;                                                                       //Cor de contorno, iniciada com preto;
    protected Color corDentro = new Color(0, 0, 0, 1);                                                             //Cor de preenchimento, iniciada transparente;
                                                                                                                   //
    protected boolean dentro = false;                                                                              //Vari�vel que indica se a figura deve ou n�o ser preenchida;
    protected boolean arrastado = false;                                                                           //Vari�vel que indica se o cursor foi arrastado;
                                                                                                                   //
    protected Ponto p1;                                                                                            //Vari�vel destinada a guardar um ponto posteriormente
                                                                                                                   //
    protected Situacao situacao = Situacao.DEFAULT;                                                                //Enumera��o que registra qual a situa��o de edi��o em que o
                                                                                                                   //                                       programa se encontra;
    protected Vector<Figura> figuras = new Vector<Figura>();                                                       //Vetor do Java usado para guardar as Figuras criadas;
//-----------------------------------------------------------------------------------------------------------Construtor:
    public Janela ()                                                                                                //Construtor da Janela;
    {                                                                                                              //
        super("Editor Gr�fico");                                                                                   //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnAbrirImg = ImageIO.read(getClass().getResource("resources/abrir.jpg"));                      //pegar o �cone do bot�o Abrir da pasta "resources do programa";
            btnAbrir.setIcon(new ImageIcon(btnAbrirImg));                                                         //colocar o �cone no bot�o Abrir;
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso d� errado:
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem
                                           "Arquivo abrir.jpg n�o foi encontrado",                                //dizendo que n�o encontramos o arquivo do �cone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;
        }                                                                                                         //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnSalvarImg = ImageIO.read(getClass().getResource("resources/salvar.jpg"));                    //pegar o �cone do bot�o Salvar da pasta "resources do programa"; 
            btnSalvar.setIcon(new ImageIcon(btnSalvarImg));                                                       //colocar o �cone no bot�o Salvar;                                
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso d� errado: 
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
                                           "Arquivo salvar.jpg n�o foi encontrado",                               //dizendo que n�o encontramos o arquivo do �cone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,                     
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;                              
        }                                                                                                         //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));                      //pegar o �cone do bot�o Imagem da pasta "resources do programa"; 
            btnPonto.setIcon(new ImageIcon(btnPontoImg));                                                         //colocar o �cone no bot�o Imagem;                                
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso d� errado: 
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
                                           "Arquivo ponto.jpg n�o foi encontrado",                                //dizendo que n�o encontramos o arquivo do �cone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,                     
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;                              
        }                                                                                                         //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnLinhaImg = ImageIO.read(getClass().getResource("resources/linha.jpg"));                      //pegar o �cone do bot�o Linha da pasta "resources do programa"; 
            btnLinha.setIcon(new ImageIcon(btnLinhaImg));                                                         //colocar o �cone no bot�o Linha;                                
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso d� errado: 
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
                                           "Arquivo linha.jpg n�o foi encontrado",                                //dizendo que n�o encontramos o arquivo do �cone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,                     
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;                              
        }                                                                                                         //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnCirculoImg = ImageIO.read(getClass().getResource("resources/circulo.jpg"));                  //pegar o �cone do bot�o C�rculo da pasta "resources do programa"; 
            btnCirculo.setIcon(new ImageIcon(btnCirculoImg));                                                     //colocar o �cone no bot�o C�rculo;                                
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso d� errado: 
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
                                           "Arquivo circulo.jpg n�o foi encontrado",                              //dizendo que n�o encontramos o arquivo do �cone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,                     
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;                              
        }                                                                                                         //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnElipseImg = ImageIO.read(getClass().getResource("resources/elipse.jpg"));                    //pegar o �cone do bot�o Elipse da pasta "resources do programa"; 
            btnElipse.setIcon(new ImageIcon(btnElipseImg));                                                       //colocar o �cone no bot�o Elipse;                                
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso d� errado: 
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
                                           "Arquivo elipse.jpg n�o foi encontrado",                               //dizendo que n�o encontramos o arquivo do �cone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,                     
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;                              
        }                                                                                                         //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnCorFiguraImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));                  //pegar o �cone do bot�o CorFora da pasta "resources do programa"; 
            btnCorFigura.setIcon(new ImageIcon(btnCorFiguraImg));                                                 //colocar o �cone no bot�o CorFora;                                
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso d� errado: 
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
                                           "Arquivo cores.jpg n�o foi encontrado",                                //dizendo que n�o encontramos o arquivo do �cone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,                     
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;                              
        }                                                                                                         //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnCorDentroImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));                  //pegar o �cone do bot�o CorDentro da pasta "resources do programa"; 
            btnCorDentro.setIcon(new ImageIcon(btnCorDentroImg));                                                 //colocar o �cone no bot�o CorDentro;                                
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso d� errado: 
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
                                           "Arquivo cores.jpg n�o foi encontrado",                                //dizendo que n�o encontramos o arquivo do �cone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,                     
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;                              
        }                                                                                                         //
		        																								   //
		try                                                                                                        //Tenta:
		{                                                                                                         //
			Image imgRetangulo = ImageIO.read(getClass().getResource("resources/retangulo.png"));                 //pegar o �cone do bot�o CorDentro da pasta "resources do programa"; 
			btnRetangulo.setIcon(new ImageIcon(imgRetangulo));                                                    //colocar o �cone no bot�o CorDentro;                                
		}                                                                                                         //
		catch (IOException e)                                                                                      //Caso d� errado: 
		{                                                                                                         //
			JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
			"Arquivo retangulo.jpg n�o foi encontrado",                                                           //dizendo que n�o encontramos o arquivo do �cone,
			"Arquivo de imagem ausente",                                                                          //entitulada sugerindo isso,                     
			JOptionPane.WARNING_MESSAGE);                                                                         //do tipo de aviso;                              
		}                                                                                                         //
		                                                                                                           //
		try                                                                                                        //Tenta:
		{                                                                                                         //
			Image imgQuadrado = ImageIO.read(getClass().getResource("resources/quadrado.png"));                   //pegar o �cone do bot�o CorDentro da pasta "resources do programa"; 
			btnQuadrado.setIcon(new ImageIcon(imgQuadrado));                                                     //colocar o �cone no bot�o CorDentro;                                
		}                                                                                                         //
		catch (IOException e)                                                                                      //Caso d� errado: 
		{                                                                                                         //
			JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
			"Arquivo quadrado.jpg n�o foi encontrado",                     								          //dizendo que n�o encontramos o arquivo do �cone,
			"Arquivo de imagem ausente",                                    							          //entitulada sugerindo isso,                     
			JOptionPane.WARNING_MESSAGE);                                                                         //do tipo de aviso;                              
		}                                                                                                         //
                                                                                                                   //
                                                                                                                   //
        btnPonto.addActionListener     (new DesenhoDePonto());                                                     //Adicionamos um tratamento de eventos ao bot�o Ponto;
        btnLinha.addActionListener     (new DesenhoDeReta ());                                                     //Adicionamos um tratamento de eventos ao bot�o Linha;
        btnCirculo.addActionListener   (new DesenhoDeCirculo());                                                   //Adicionamos um tratamento de eventos ao bot�o C�rculo;
        btnElipse.addActionListener    (new DesenhoDeElipse());                                                    //Adicionamos um tratamento de eventos ao bot�o Elipse;
        btnRetangulo.addActionListener (new DesenhoDeRetangulo());                                                 //Adicionamos um tratamento de eventos ao bot�o CorFora;  
        btnQuadrado.addActionListener  (new DesenhoDeQuadrado());                                                  //Adicionamos um tratamento de eventos ao bot�o CorDentro;
        btnCorFigura.addActionListener (new PegarCorDeFora());                                                     //Adicionamos um tratamento de eventos ao bot�o CorFora;
        btnCorDentro.addActionListener (new PegarCorDeDentro());                                                   //Adicionamos um tratamento de eventos ao bot�o Elipse;          
                                                                                                                   //
        JPanel     pnlBotoes = new JPanel();                                                                       //Instanciamos um novo painel;
        FlowLayout flwBotoes = new FlowLayout();                                                                   //Instanciamos um novo Layout;
        pnlBotoes.setLayout (flwBotoes);                                                                           //Colocamos o layout criado no novo painel;
                                                                                                                   //
        pnlBotoes.add (btnAbrir);                                                                                  //Adicionamos ao novo painel o bot�o Abrir;
        pnlBotoes.add (btnSalvar);                                                                                 //Adicionamos ao novo painel o bot�o Salvar;
        pnlBotoes.add (btnPonto);                                                                                  //Adicionamos ao novo painel o bot�o Ponto;
        pnlBotoes.add (btnLinha);                                                                                  //Adicionamos ao novo painel o bot�o Linha;
        pnlBotoes.add (btnCirculo);                                                                                //Adicionamos ao novo painel o bot�o C�rculo;
        pnlBotoes.add (btnElipse);                                                                                 //Adicionamos ao novo painel o bot�o Elipse;
        pnlBotoes.add (btnRetangulo);                                                                              //Adicionamos ao novo painel o bot�o Retangulo; 
        pnlBotoes.add (btnQuadrado);                                                                               //Adicionamos ao novo painel o bot�o Quadrado;  
        pnlBotoes.add (btnCorFigura);                                                                              //Adicionamos ao novo painel o bot�o CorFora;
        pnlBotoes.add (btnCorDentro);                                                                              //Adicionamos ao novo painel o bot�o CorDentro;
        
        
                                                                                                                   //
        JPanel     pnlStatus = new JPanel();                                                                       //Instanciamos um novo painel;
        GridLayout grdStatus = new GridLayout(1,2);                                                                //Instanciamos um novo Layout;                  
        pnlStatus.setLayout(grdStatus);                                                                            //Colocamos o layout criado no novo painel;     
                                                                                                                   //
        pnlStatus.add(statusBar1);                                                                                 //Adicionamos as barras de status anteriormente criadas 
                                                                                                                   //                                        no novo painel;
        pnlStatus.add(statusBar2);                                                                                 //Adicionamos as barras de status anteriormente criadas
                                                                                                                   //                                        no novo painel;
        Container cntForm = this.getContentPane();                                                                 //Instanciamos um container;
        cntForm.setLayout (new BorderLayout());                                                                    //Inserimos nele um layout;
        cntForm.add (pnlBotoes,  BorderLayout.NORTH);                                                              //Adicionamos ao container o painel criado para os bot�es
                                                                                                                   //                                                  no norte;
        cntForm.add (pnlDesenho, BorderLayout.CENTER);                                                             //Adicionamos ao container o painel criado para os desenhos
                                                                                                                   //                                                  no centro;
        cntForm.add (pnlStatus,  BorderLayout.SOUTH);                                                              //Adicionamos ao container o painel criado para as barras de status
                                                                                                                   //                                                  no sul;
        this.addWindowListener (new FechamentoDeJanela());                                                         //Adicionamos � janela o tratamento do evento de fechar-se;
                                                                                                                   //
        this.setSize (1100,600);                                                                                    //Com um tamanho inicial de 800x600,
        this.setVisible (true);                                                                                    //tornamos a janela criada vis�vel;
    }                                                                                                              //
//-----------------------------------------------------------------------------------------------------------Auxiliares:  
    protected class MeuJPanel extends    JPanel                                                                     //Vers�o nova nossa, que extende painel, incluindo nossas 
                              implements MouseListener,                                                             //particularidades. Ela implementa tratamentos de eventos
                                         MouseMotionListener                                                        //e de movimento de mouse.
    {                                                                                                              //
		private static final long serialVersionUID = -6253339646021811311L;                                        //N�mero de s�rie da classe.
                                                                                                                   //
		public MeuJPanel()                                                                                         //Construtor:
        {                                                                                                         //
            super();                                                                                              //Aciona o construtor herdado de JPanel;
                                                                                                                  //
            this.addMouseListener       (this);                                                                   //Configura como tratadora de eventos 
            this.addMouseMotionListener (this);                                                                   //de mouse a pr�pria classe;
        }                                                                                                         //
                                                                                                                   //
        public void paint (Graphics g)                                                                             //M�todo usado para "pintar" no painel as figuras feitas:
        {                                                                                                         //
            for (int i=0 ; i<figuras.size(); i++)                                                                 //Para cada elemento do nosso vetor de figuras:
                figuras.get(i).torneSeVisivel(g);                                                                //tornamos a figura da vez vis�vel no painel.
        }                                                                                                         //
                                                                                                                   //
        public void mousePressed (MouseEvent e)                                                                    //Quando o mouse � pressionado
        {                                                                                                         //tratamos esse evento assim:
        	switch(situacao) {                                                                                    //Caso estejamos...
	        	case ESPERANDO_PONTO:                                                                             // - Esperando por um ponto:
	        		figuras.add (new Ponto (e.getX(), e.getY(), corFigura));                                     //Adicionamos o ponto coas coordenadas do cursor no vetor de figuras
	        		figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());                      //e o tornamos vis�vel no painel;
	        		situacao = Situacao.DEFAULT;                                                                 //Retornamos a situa��o ao estado inicial;
	        		break;                                                                                       //E pronto;
	        	case ESPERANDO_INICIO_RETA:                                                                       // - Esperando o in�cio de uma reta:
	        		p1 = new Ponto (e.getX(), e.getY(), corFigura);                                              //Guardamos as coordenadas atuais do cursor no ponto antes criado;
	        		situacao = Situacao.ESPERANDO_FIM_RETA;                                                      //Indicamos na situa��o que temos o in�cio. Esperamos pelo fim;
	        		statusBar1.setText("Mensagem: clique o ponto final da reta");                                //Indicamos ao usu�rio que clique no desejado ponto final da reta;
	        		break;                                                                                       //E pronto;
	        	case ESPERANDO_FIM_RETA:                                                                          // - Esperando o fim de uma reta:
	        		fimLinha(e);                                                                                 //Chamamos o m�todo auxiliar que desenha a linha;
	                break;                                                                                       //E pronto;  
	        	case ESPERANDO_INICIO_CIRCULO:                                                                    // - Esperando o in�cio de um c�rculo:
	        		p1 = new Ponto (e.getX(), e.getY(), corFigura);                                              //Guardamos as coordenadas atuais do cursor no ponto antes criado; 
	        		situacao = Situacao.ESPERANDO_FIM_CIRCULO;                                                   //Indicamos na situa��o que temos o in�cio. Esperamos pelo fim;    
	        		statusBar1.setText("Mensagem: clique o ponto final do c�rculo");                             //Indicamos ao usu�rio que clique no desejado ponto final do c�rculo; 
	        		break;                                                                                       //E pronto;  
	        	case ESPERANDO_FIM_CIRCULO:                                                                       // - Esperando o fim de um c�rculo:
	        		fimCirculo(e);                                                                               //Chamamos o m�todo auxiliar que desenha o c�rculo;
	                break;                                                                                       //E pronto;  
	        	case ESPERANDO_INICIO_ELIPSE:                                                                     // - Esperando o in�cio de uma elipse:
	        		p1 = new Ponto (e.getX(), e.getY(), corFigura);                                              //Guardamos as coordenadas atuais do cursor no ponto antes criado; 
	        		situacao = Situacao.ESPERANDO_FIM_ELIPSE;                                                    //Indicamos na situa��o que temos o in�cio. Esperamos pelo fim;    
	        		statusBar1.setText("Mensagem: clique o ponto final da elipse");                              //Indicamos ao usu�rio que clique no desejado ponto final da elipse; 
	        		break;                                                                                       //E pronto;  
	        	case ESPERANDO_FIM_ELIPSE:                                                                        // - Esperando o fim de uma elipse:
	        		fimElipse(e);                                                                                //Chamamos o m�todo auxiliar que desenha a elipse;
	                break;                                                                                       //E pronto;  
	            case ESPERANDO_INICIO_RETANGULO:                                                                  // - Esperando o in�cio de um c�rculo:                               
	            	p1 = new Ponto (e.getX(), e.getY(), corFigura);                                              //Guardamos as coordenadas atuais do cursor no ponto antes criado;    
	            	situacao = Situacao.ESPERANDO_FIM_RETANGULO;                                                 //Indicamos na situa��o que temos o in�cio. Esperamos pelo fim;       
	            	statusBar1.setText("Mensagem: clique o ponto final do ret�ngulo");                           //Indicamos ao usu�rio que clique no desejado ponto final do c�rculo; 
	            	break;                                                                                       //E pronto;                                                           
	            case ESPERANDO_FIM_RETANGULO:                                                                     // - Esperando o fim de um c�rculo:                                  
	            	fimRetangulo(e);                                                                             //Chamamos o m�todo auxiliar que desenha o c�rculo;                   
	                break;                                                                                       //E pronto;                                                           
	            case ESPERANDO_INICIO_QUADRADO:                                                                   // - Esperando o in�cio de uma elipse:                               
	            	p1 = new Ponto (e.getX(), e.getY(), corFigura);                                              //Guardamos as coordenadas atuais do cursor no ponto antes criado;    
	            	situacao = Situacao.ESPERANDO_FIM_QUADRADO;                                                  //Indicamos na situa��o que temos o in�cio. Esperamos pelo fim;       
	            	statusBar1.setText("Mensagem: clique o ponto final da c�rculo");                             //Indicamos ao usu�rio que clique no desejado ponto final da elipse;  
	            	break;                                                                                       //E pronto;                                                           
	            case ESPERANDO_FIM_QUADRADO:                                                                      // - Esperando o fim de uma elipse:                                  
	            	fimQuadrado(e);                                                                              //Chamamos o m�todo auxiliar que desenha a elipse;                    
	                break;                                                                                       //E pronto;            
	        	case DEFAULT:                                                                                     // - Em um caso diferente:
	        		statusBar1.setText("Mensagem:");                                                             //Apenas retornamos o status da mensagem a nada.
	        		break;                                                                                       //E pronto;  
				default: break;                                                                                  // - Em um defaulf, apenas por precau��o;
        	}                                                                                                     //
        }                                                                                                          //
        public void mouseReleased (MouseEvent e)                                                                   //Quando o mouse � pressionado 
        {                                                                                                         //tratamos esse evento assim:   
        	if(arrastado)                                                                                         //Apenas se o bot�o tiver sido arrastado:
	        	switch(situacao)                                                                                 //Caso estejamos...
	        	{                                                                                               //
	        	case ESPERANDO_FIM_CIRCULO:                                                                     // - Esperando o fim de um c�rculo:                  
	        		fimCirculo(e);	        		                                                           //Chamamos o m�todo auxiliar que desenha o c�rculo;   
	        		break;                                                                                     //E pronto;                                           
	        	case ESPERANDO_FIM_ELIPSE:                                                                      // - Esperando o fim de uma elipse:              
	        		fimElipse(e);                                                                              //Chamamos o m�todo auxiliar que desenha a elipse;
	        		break;                                                                                     //E pronto;                                       
	        	case ESPERANDO_FIM_RETA:                                                                        // - Esperando o fim de uma reta:                        
	        		fimLinha(e);                                                                               //Chamamos o m�todo auxiliar que desenha a linha;         
	        		break;                                                                                     //E pronto;                                               
				default: break;                                                                                // - Em um defaulf, apenas por precau��o;   
	        	}                                                                                               //
        	arrastado = false;                                                                                    //Marcamos que j� tratamos essa vez em que o mouse foi arrastado
        }                                                                                                         //                                                        e solto;
                                                                                                                   //
        public void mouseClicked (MouseEvent e)                                                                    //Tratamento de mouse,
        {}                                                                                                        //vazio, apenas para cumprir a interface.
                                                                                                                   //
        public void mouseEntered (MouseEvent e)                                                                    //Tratamento de mouse,                     
        {}                                                                                                        //vazio, apenas para cumprir a interface.   
                                                                                                                   //
        public void mouseExited (MouseEvent e)                                                                     //Tratamento de mouse,                     
        {}                                                                                                        //vazio, apenas para cumprir a interface.   
                                                                                                                   //
        public void mouseDragged(MouseEvent e)                                                                     //Tratamento do mouse arrastado:  
        {                                                                                                         //
        	arrastado = true;                                                                                     //Marcamos que ele foi arrastado, para quando ele for solto,
        }                                                                                                         //                                                 saibamos disso;
                                                                                                                   //
        public void mouseMoved(MouseEvent e)                                                                       //Tratamento do mouse movido:  
        {                                                                                                         //
            statusBar2.setText("Coordenada: " + e.getX() + "," + e.getY());                                       //Atualizamos as coordenadas do mouse nos status;
        }                                                                                                         //
    }                                                                                                              //
                                                                                                                    //
    protected enum Situacao                                                                                         //Enumera��o de situa��es;
    {                                                                                                              //
    	ESPERANDO_PONTO,                                                                                           //Esperando que se clique no Ponto;
    	ESPERANDO_INICIO_RETA,                                                                                     //Esperando que se clique no In�cio da Reta;
    	ESPERANDO_FIM_RETA,                                                                                        //Esperando que se clique no Fim da Reta;
    	ESPERANDO_INICIO_CIRCULO,                                                                                  //Esperando que se clique no In�cio do C�rculo;
    	ESPERANDO_FIM_CIRCULO,                                                                                     //Esperando que se clique no Fim do C�rculo;
    	ESPERANDO_INICIO_ELIPSE,                                                                                   //Esperando que se clique no In�cio da Elipse;
    	ESPERANDO_FIM_ELIPSE,                                                                                      //Esperando que se clique no Fim da Elipse;
    	ESPERANDO_INICIO_RETANGULO,                                                                                //Esperando que se clique no In�cio do Ret�ngulo;
    	ESPERANDO_FIM_RETANGULO,                                                                                   //Esperando que se clique no Fim do Ret�ngulo;   
    	ESPERANDO_INICIO_QUADRADO,                                                                                 //Esperando que se clique no In�cio da Quadrado; 
    	ESPERANDO_FIM_QUADRADO,                                                                                    //Esperando que se clique no Fim da Quadrado;    
    	DEFAULT;                                                                                                   //Esperando que se clique em algum bot�o;
    }                                                                                                              //
                                                                                                                    //
    protected class DesenhoDePonto implements ActionListener                                                        //Classe que trata o evento do bot�o Ponto:
    {                                                                                                              //
          public void actionPerformed (ActionEvent e)                                                              //M�todo no formato requerido pela implementa��o:
          {                                                                                                       //
              situacao = Situacao.ESPERANDO_PONTO;                                                                //Situamos o programa na espera de um ponto;
                                                                                                                  //
              statusBar1.setText("Mensagem: clique o local do ponto desejado");                                   //Indicamos na barra de status a situa��o;
          }                                                                                                       //
    }                                                                                                              //
                                                                                                                    //
    protected class DesenhoDeReta implements ActionListener                                                         //Classe que trata o evento do bot�o Reta:
    {                                                                                                              //
        public void actionPerformed (ActionEvent e)                                                                //M�todo no formato requerido pela implementa��o:
        {                                                                                                         //                                                
        	situacao = Situacao.ESPERANDO_INICIO_RETA;                                                            //Situamos o programa na espera de uma reta;      
                                                                                                                  //                                                
            statusBar1.setText("Mensagem: clique o ponto inicial da reta");                                       //Indicamos na barra de status a situa��o;        
        }                                                                                                         //
    }                                                                                                              //
                                                                                                                    //
    protected class DesenhoDeCirculo implements ActionListener                                                      //Classe que trata o evento do bot�o C�rculo:
    {                                                                                                              //
    	public void actionPerformed (ActionEvent e)                                                                //M�todo no formato requerido pela implementa��o:
    	{                                                                                                         //                                                
    		situacao = Situacao.ESPERANDO_INICIO_CIRCULO;                                                         //Situamos o programa na espera de um c�rculo;      
                                                                                                                  //                                                
            statusBar1.setText("Mensagem: clique o ponto inicial do c�rculo");                                    //Indicamos na barra de status a situa��o;        
    	}                                                                                                         //
    }                                                                                                              //
                                                                                                                    //
    protected class DesenhoDeElipse implements ActionListener                                                       //Classe que trata o evento do bot�o Elipse:
    {                                                                                                              //
    	public void actionPerformed (ActionEvent e)                                                                //M�todo no formato requerido pela implementa��o:
    	{                                                                                                         //                                                
    		situacao = Situacao.ESPERANDO_INICIO_ELIPSE;                                                          //Situamos o programa na espera de uma elipse;      
                                                                                                                  //                                                
            statusBar1.setText("Mensagem: clique o ponto inicial da elipse");                                     //Indicamos na barra de status a situa��o;        
    	}                                                                                                         //
	}                                                                                                              //
	                                                                                                                //
	protected class DesenhoDeRetangulo implements ActionListener                                                    //Classe que trata o evento do bot�o Ret�ngulo:
	{                                                                                                              //
		public void actionPerformed (ActionEvent e)                                                                //M�todo no formato requerido pela implementa��o:
		{                                                                                                         //                                                
			situacao = Situacao.ESPERANDO_INICIO_RETANGULO;                                                       //Situamos o programa na espera de um ret�ngulo;      
			                                                                                                      //                                                
			statusBar1.setText("Mensagem: clique o ponto inicial do retangulo");                                  //Indicamos na barra de status a situa��o;        
		}                                                                                                         //
	}                                                                                                              //
	                                                                                                                //
	protected class DesenhoDeQuadrado implements ActionListener                                                     //Classe que trata o evento do bot�o Quadrado:
	{                                                                                                              //
		public void actionPerformed (ActionEvent e)                                                                //M�todo no formato requerido pela implementa��o:
		{                                                                                                         //                                                
			situacao = Situacao.ESPERANDO_INICIO_QUADRADO;                                                         //Situamos o programa na espera de uma quadrado;      
	                                                                                                              //                                                
			statusBar1.setText("Mensagem: clique o ponto inicial do quadrado");                                   //Indicamos na barra de status a situa��o;        
		}                                                                                                         //
	}                                                                                                              //
                                                                                                                    //
    protected class PegarCorDeFora implements ActionListener                                                        //Classe que trata o evento do bot�o CorFora:
    {                                                                                                              //
    	public void actionPerformed (ActionEvent e)                                                                //M�todo no formato requerido pela implementa��o:
    	{                                                                                                         //                                                
    		corFigura = JColorChooser.showDialog(Janela.this, "Selecione uma cor", corFigura);                    //Exibimos uma janela para a escolha de uma cor
    		                                                                                                      //              e guardamos seu retorno na vari�vel de cor;
    		dentro = false;                                                                                       //Marcamos que estamos no modo de figuras n�o preenchidas;    
    	}                                                                                                         //    
    }                                                                                                              //
                                                                                                                    //
    protected class PegarCorDeDentro implements ActionListener                                                      //Classe que trata o evento do bot�o CorDentro:
    {                                                                                                              //
    	public void actionPerformed (ActionEvent e)                                                                //M�todo no formato requerido pela implementa��o:
    	{                                                                                                         //                                                
    		corFigura = JColorChooser.showDialog(Janela.this, "Selecione uma cor", corFigura);                    //Exibimos uma janela para a escolha de uma cor                
    		dentro = true;                                                                                        //              e guardamos seu retorno na vari�vel de cor;    
    	}                                                                                                         //Marcamos que estamos no modo de figuras preenchidas;     
    }                                                                                                              //
                                                                                                                    //
    protected class FechamentoDeJanela extends WindowAdapter                                                        //Classe que trata o fechamento da janela:
    {                                                                                                              //
        public void windowClosing (WindowEvent e)                                                                  //M�todo no formato requerido pela implementa��o: 
        {                                                                                                         //
            System.exit(0);                                                                                       //Encerramos a janela;
        }                                                                                                         //
    }                                                                                                              //
                                                                                                                    //
    protected void fimLinha(MouseEvent e)                                                                           //M�todo auxiliar, para desenhar a linha:
    {                                                                                                              //
    	situacao = Situacao.DEFAULT;                                                                               //Retornamos a situa��o do programa ao default;
        figuras.add (new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corFigura));                              //Adicionamos ao vetor de figuras uma linha, cuja coordenada
                                                                                                                   //inicial vem do ponto em que guardamos o come�o da linha e a 
                                                                                                                   //final � extra�da do evendo de mouse, passado como par�metro;
        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());                                    //Tornamos a nova linha vis�vel no painel;
        statusBar1.setText("Mensagem:");                                                                           //Retornamos a barra de mensagem ao default;
    }                                                                                                              //
                                                                                                                    //
    protected void fimCirculo(MouseEvent e)                                                                         //M�todo auxiliar, para desenhar o c�rculo:
    {                                                                                                              //
    	situacao = Situacao.DEFAULT;                                                                               //Retornamos a situa��o do programa ao default; 
		int dimensao;                                                                                              //Criamos vari�vel para guardar a dimens�o do c�rculo;
		if((e.getX() - p1.getX()) < (e.getY() - p1.getY()))                                                        //Se o lado, dado pela sele��o do usu�rio, vertical for maior:
			dimensao = (e.getY() - p1.getY());                                                                    //escolhemos ele como dimens�o;
		else                                                                                                       //caso o contr�rio:
			dimensao = (e.getX() - p1.getX());                                                                    //sempre escolhemos o maior lado.
		Circulo circulo = new Circulo(p1.getX(), p1.getY(), dimensao, corFigura);                                  //Criamos um c�rculo, cuja coordenada   
		                                                                                                           //inicial vem do ponto em que guardamos o come�o da linha e a   
                                                                                                                   //final � extra�da do evendo de mouse, passado como par�metro;
        circulo.setPreenchido(dentro); 																			   //Informamos se o c�rculo deve ser preenchido ou n�o;
        figuras.add (circulo);                                                                                     //Adicionamos ao vetor de figuras o c�rculo;
        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());                                    //Tornamos o novo c�rculo vis�vel no painel;                      
        statusBar1.setText("Mensagem:");                                                                           //Retornamos a barra de mensagem ao default;                    
    }                                                                                                              //
                                                                                                                    //
    protected void fimElipse(MouseEvent e)                                                                          //
    {                                                                                                              //
    	situacao = Situacao.DEFAULT;                                                                               //Retornamos a situa��o do programa ao default;                
        Elipse elipse = new Elipse(p1.getX(), p1.getY(), (e.getX() - p1.getX()),                                   //Criamos uma uma elipse, cuja coordenada   
        		(e.getY() - p1.getY()), corFigura);                                                                //inicial vem do ponto em que guardamos o come�o da linha e a  
                                                                                                                   //final � extra�da do evendo de mouse, passado como par�metro;
		elipse.setPreenchido(dentro);                                                                              //Informamos se a elipse deve ser preenchido ou n�o;     
		figuras.add (elipse);                                                                                      //Adicionamos ao vetor de figuras a elipse;              
		figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());                                    //Tornamos a nova linha vis�vel no painel;
		statusBar1.setText("Mensagem:");                                                                           //Retornamos a barra de mensagem ao default;               
    }                                                                                                              //
    protected void fimQuadrado(MouseEvent e)                                                                       //M�todo auxiliar, para desenhar o quadrado:                        
    {                                                                                                              //                                                                  
    	situacao = Situacao.DEFAULT;                                                                               //Retornamos a situa��o do programa ao default;                     
    	int dimensao;                                                                                              //Criamos vari�vel para guardar a dimens�o do quadrado;              
    	if((e.getX() - p1.getX()) < (e.getY() - p1.getY()))                                                        //Se o lado, dado pela sele��o do usu�rio, vertical for maior:      
    		dimensao = (e.getY() - p1.getY());                                                                    //escolhemos ele como dimens�o;                                      
    	else                                                                                                       //caso o contr�rio:                                                 
    		dimensao = (e.getX() - p1.getX());                                                                    //sempre escolhemos o maior lado.                                    
    	Quadrado quadrado = new Quadrado(p1.getX(), p1.getY(), dimensao, corFigura);                              //Criamos um quadrado, cuja coordenada                               
    	                                                                                                           //inicial vem do ponto em que guardamos o come�o da linha e a       
                                                                                                                   //final � extra�da do evendo de mouse, passado como par�metro;      
    	quadrado.setPreenchido(dentro); 																		   //Informamos se o quadrado deve ser preenchido ou n�o;               
        figuras.add (quadrado);                                                                                    //Adicionamos ao vetor de figuras o quadrado;                        
        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());                                    //Tornamos o novo quadrado vis�vel no painel;                        
        statusBar1.setText("Mensagem:");                                                                           //Retornamos a barra de mensagem ao default;                        
    }                                                                                                              //                                                                  
                                                                                                                    //                                                                 
    protected void fimRetangulo(MouseEvent e)                                                                       //                                                                 
    {                                                                                                              //                                                                  
    	situacao = Situacao.DEFAULT;                                                                               //Retornamos a situa��o do programa ao default;                     
        Retangulo retangulo = new Retangulo(p1.getX(), p1.getY(), (e.getX() - p1.getX()),                          //Criamos um retangulo, cuja coordenada                           
        		(e.getY() - p1.getY()), corFigura);                                                                //inicial vem do ponto em que guardamos o come�o da linha e a       
                                                                                                                   //final � extra�da do evendo de mouse, passado como par�metro;      
        retangulo.setPreenchido(dentro);                                                                           //Informamos se o retangulo deve ser preenchido ou n�o;               
    	figuras.add (retangulo);                                                                                   //Adicionamos ao vetor de figuras o retangulo;                        
    	figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());                                    //Tornamos a nova linha vis�vel no painel;                          
    	statusBar1.setText("Mensagem:");                                                                           //Retornamos a barra de mensagem ao default;                        
    }                                                                                                              //         
}                                                                                                                   //
//FIM DA CLASSE!                                                                                                    