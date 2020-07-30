import java.awt.*;                                                                                                   // I
import java.awt.event.*;                                                                                             // M
import javax.swing.*;                                                                                                // P
import javax.imageio.*;                                                                                              // O
import java.io.*;                                                                                                    // R
import java.util.*;                                                                                                  // T
//INÍCIO DA CLASSE!                                                                                                
public class Janela extends JFrame                                                                                   //Início da classe janela.
{                                                                                                                   //
    protected static final long serialVersionUID = 1L;                                                              //Número de série da classe.
                                                                                                                    //-----Declaração de atributos:
    protected JButton btnPonto     = new JButton ("Ponto"),                                                        //Botão para desenhar ponto;
                      btnLinha     = new JButton ("Linha"),                                                        //Botão para desenhar linha;
                      btnCirculo   = new JButton ("Circulo"),                                                      //Botão para desenhar círculo;
                      btnElipse    = new JButton ("Elipse"),                                                       //Botão para desenhar elipse;
                      btnCorFigura = new JButton ("Fora"),                                                         //Botão para escolher a cor do contorno da figura;
                      btnCorDentro = new JButton ("Dentro"),                                                       //Botão para escolhr a cor do preenchimento da figura;
                      btnAbrir     = new JButton ("Abrir"),                                                        //Botão para abrir uma imagem sua;
                      btnRetangulo = new JButton ("Retângulo"),                                                    //Botão para desenhar um retângulo;
                      btnQuadrado  = new JButton ("Quadrado"),                                                     //Botão para desenhar um quadrado;
                      btnSalvar    = new JButton ("Salvar");                                                       //Botão para salvar a sua imagem;
                                                                                                                   //
    protected MeuJPanel pnlDesenho = new MeuJPanel ();                                                             //Painel onde os desenhos serão feitos;
                                                                                                                   //
    protected JLabel statusBar1 = new JLabel ("Mensagem:"),                                                        //Barra que sinaliza mensagens;
                     statusBar2 = new JLabel ("Coordenada:");                                                      //Barra inferior que sinaliza coordenadas do cursor;
                                                                                                                   //
    protected Color corFigura = Color.BLACK;                                                                       //Cor de contorno, iniciada com preto;
    protected Color corDentro = new Color(0, 0, 0, 1);                                                             //Cor de preenchimento, iniciada transparente;
                                                                                                                   //
    protected boolean dentro = false;                                                                              //Variável que indica se a figura deve ou não ser preenchida;
    protected boolean arrastado = false;                                                                           //Variável que indica se o cursor foi arrastado;
                                                                                                                   //
    protected Ponto p1;                                                                                            //Variável destinada a guardar um ponto posteriormente
                                                                                                                   //
    protected Situacao situacao = Situacao.DEFAULT;                                                                //Enumeração que registra qual a situação de edição em que o
                                                                                                                   //                                       programa se encontra;
    protected Vector<Figura> figuras = new Vector<Figura>();                                                       //Vetor do Java usado para guardar as Figuras criadas;
//-----------------------------------------------------------------------------------------------------------Construtor:
    public Janela ()                                                                                                //Construtor da Janela;
    {                                                                                                              //
        super("Editor Gráfico");                                                                                   //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnAbrirImg = ImageIO.read(getClass().getResource("resources/abrir.jpg"));                      //pegar o ícone do botão Abrir da pasta "resources do programa";
            btnAbrir.setIcon(new ImageIcon(btnAbrirImg));                                                         //colocar o ícone no botão Abrir;
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso dê errado:
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem
                                           "Arquivo abrir.jpg não foi encontrado",                                //dizendo que não encontramos o arquivo do ícone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;
        }                                                                                                         //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnSalvarImg = ImageIO.read(getClass().getResource("resources/salvar.jpg"));                    //pegar o ícone do botão Salvar da pasta "resources do programa"; 
            btnSalvar.setIcon(new ImageIcon(btnSalvarImg));                                                       //colocar o ícone no botão Salvar;                                
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso dê errado: 
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
                                           "Arquivo salvar.jpg não foi encontrado",                               //dizendo que não encontramos o arquivo do ícone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,                     
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;                              
        }                                                                                                         //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));                      //pegar o ícone do botão Imagem da pasta "resources do programa"; 
            btnPonto.setIcon(new ImageIcon(btnPontoImg));                                                         //colocar o ícone no botão Imagem;                                
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso dê errado: 
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
                                           "Arquivo ponto.jpg não foi encontrado",                                //dizendo que não encontramos o arquivo do ícone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,                     
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;                              
        }                                                                                                         //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnLinhaImg = ImageIO.read(getClass().getResource("resources/linha.jpg"));                      //pegar o ícone do botão Linha da pasta "resources do programa"; 
            btnLinha.setIcon(new ImageIcon(btnLinhaImg));                                                         //colocar o ícone no botão Linha;                                
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso dê errado: 
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
                                           "Arquivo linha.jpg não foi encontrado",                                //dizendo que não encontramos o arquivo do ícone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,                     
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;                              
        }                                                                                                         //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnCirculoImg = ImageIO.read(getClass().getResource("resources/circulo.jpg"));                  //pegar o ícone do botão Círculo da pasta "resources do programa"; 
            btnCirculo.setIcon(new ImageIcon(btnCirculoImg));                                                     //colocar o ícone no botão Círculo;                                
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso dê errado: 
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
                                           "Arquivo circulo.jpg não foi encontrado",                              //dizendo que não encontramos o arquivo do ícone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,                     
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;                              
        }                                                                                                         //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnElipseImg = ImageIO.read(getClass().getResource("resources/elipse.jpg"));                    //pegar o ícone do botão Elipse da pasta "resources do programa"; 
            btnElipse.setIcon(new ImageIcon(btnElipseImg));                                                       //colocar o ícone no botão Elipse;                                
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso dê errado: 
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
                                           "Arquivo elipse.jpg não foi encontrado",                               //dizendo que não encontramos o arquivo do ícone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,                     
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;                              
        }                                                                                                         //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnCorFiguraImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));                  //pegar o ícone do botão CorFora da pasta "resources do programa"; 
            btnCorFigura.setIcon(new ImageIcon(btnCorFiguraImg));                                                 //colocar o ícone no botão CorFora;                                
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso dê errado: 
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
                                           "Arquivo cores.jpg não foi encontrado",                                //dizendo que não encontramos o arquivo do ícone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,                     
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;                              
        }                                                                                                         //
                                                                                                                   //
        try                                                                                                        //Tenta:
        {                                                                                                         //
            Image btnCorDentroImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));                  //pegar o ícone do botão CorDentro da pasta "resources do programa"; 
            btnCorDentro.setIcon(new ImageIcon(btnCorDentroImg));                                                 //colocar o ícone no botão CorDentro;                                
        }                                                                                                         //
        catch (IOException e)                                                                                      //Caso dê errado: 
        {                                                                                                         //
            JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
                                           "Arquivo cores.jpg não foi encontrado",                                //dizendo que não encontramos o arquivo do ícone,
                                           "Arquivo de imagem ausente",                                           //entitulada sugerindo isso,                     
                                           JOptionPane.WARNING_MESSAGE);                                          //do tipo de aviso;                              
        }                                                                                                         //
		        																								   //
		try                                                                                                        //Tenta:
		{                                                                                                         //
			Image imgRetangulo = ImageIO.read(getClass().getResource("resources/retangulo.png"));                 //pegar o ícone do botão CorDentro da pasta "resources do programa"; 
			btnRetangulo.setIcon(new ImageIcon(imgRetangulo));                                                    //colocar o ícone no botão CorDentro;                                
		}                                                                                                         //
		catch (IOException e)                                                                                      //Caso dê errado: 
		{                                                                                                         //
			JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
			"Arquivo retangulo.jpg não foi encontrado",                                                           //dizendo que não encontramos o arquivo do ícone,
			"Arquivo de imagem ausente",                                                                          //entitulada sugerindo isso,                     
			JOptionPane.WARNING_MESSAGE);                                                                         //do tipo de aviso;                              
		}                                                                                                         //
		                                                                                                           //
		try                                                                                                        //Tenta:
		{                                                                                                         //
			Image imgQuadrado = ImageIO.read(getClass().getResource("resources/quadrado.png"));                   //pegar o ícone do botão CorDentro da pasta "resources do programa"; 
			btnQuadrado.setIcon(new ImageIcon(imgQuadrado));                                                     //colocar o ícone no botão CorDentro;                                
		}                                                                                                         //
		catch (IOException e)                                                                                      //Caso dê errado: 
		{                                                                                                         //
			JOptionPane.showMessageDialog (null,                                                                  //exibimos uma mensagem                          
			"Arquivo quadrado.jpg não foi encontrado",                     								          //dizendo que não encontramos o arquivo do ícone,
			"Arquivo de imagem ausente",                                    							          //entitulada sugerindo isso,                     
			JOptionPane.WARNING_MESSAGE);                                                                         //do tipo de aviso;                              
		}                                                                                                         //
                                                                                                                   //
                                                                                                                   //
        btnPonto.addActionListener     (new DesenhoDePonto());                                                     //Adicionamos um tratamento de eventos ao botão Ponto;
        btnLinha.addActionListener     (new DesenhoDeReta ());                                                     //Adicionamos um tratamento de eventos ao botão Linha;
        btnCirculo.addActionListener   (new DesenhoDeCirculo());                                                   //Adicionamos um tratamento de eventos ao botão Círculo;
        btnElipse.addActionListener    (new DesenhoDeElipse());                                                    //Adicionamos um tratamento de eventos ao botão Elipse;
        btnRetangulo.addActionListener (new DesenhoDeRetangulo());                                                 //Adicionamos um tratamento de eventos ao botão CorFora;  
        btnQuadrado.addActionListener  (new DesenhoDeQuadrado());                                                  //Adicionamos um tratamento de eventos ao botão CorDentro;
        btnCorFigura.addActionListener (new PegarCorDeFora());                                                     //Adicionamos um tratamento de eventos ao botão CorFora;
        btnCorDentro.addActionListener (new PegarCorDeDentro());                                                   //Adicionamos um tratamento de eventos ao botão Elipse;          
                                                                                                                   //
        JPanel     pnlBotoes = new JPanel();                                                                       //Instanciamos um novo painel;
        FlowLayout flwBotoes = new FlowLayout();                                                                   //Instanciamos um novo Layout;
        pnlBotoes.setLayout (flwBotoes);                                                                           //Colocamos o layout criado no novo painel;
                                                                                                                   //
        pnlBotoes.add (btnAbrir);                                                                                  //Adicionamos ao novo painel o botão Abrir;
        pnlBotoes.add (btnSalvar);                                                                                 //Adicionamos ao novo painel o botão Salvar;
        pnlBotoes.add (btnPonto);                                                                                  //Adicionamos ao novo painel o botão Ponto;
        pnlBotoes.add (btnLinha);                                                                                  //Adicionamos ao novo painel o botão Linha;
        pnlBotoes.add (btnCirculo);                                                                                //Adicionamos ao novo painel o botão Círculo;
        pnlBotoes.add (btnElipse);                                                                                 //Adicionamos ao novo painel o botão Elipse;
        pnlBotoes.add (btnRetangulo);                                                                              //Adicionamos ao novo painel o botão Retangulo; 
        pnlBotoes.add (btnQuadrado);                                                                               //Adicionamos ao novo painel o botão Quadrado;  
        pnlBotoes.add (btnCorFigura);                                                                              //Adicionamos ao novo painel o botão CorFora;
        pnlBotoes.add (btnCorDentro);                                                                              //Adicionamos ao novo painel o botão CorDentro;
        
        
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
        cntForm.add (pnlBotoes,  BorderLayout.NORTH);                                                              //Adicionamos ao container o painel criado para os botões
                                                                                                                   //                                                  no norte;
        cntForm.add (pnlDesenho, BorderLayout.CENTER);                                                             //Adicionamos ao container o painel criado para os desenhos
                                                                                                                   //                                                  no centro;
        cntForm.add (pnlStatus,  BorderLayout.SOUTH);                                                              //Adicionamos ao container o painel criado para as barras de status
                                                                                                                   //                                                  no sul;
        this.addWindowListener (new FechamentoDeJanela());                                                         //Adicionamos à janela o tratamento do evento de fechar-se;
                                                                                                                   //
        this.setSize (1100,600);                                                                                    //Com um tamanho inicial de 800x600,
        this.setVisible (true);                                                                                    //tornamos a janela criada visível;
    }                                                                                                              //
//-----------------------------------------------------------------------------------------------------------Auxiliares:  
    protected class MeuJPanel extends    JPanel                                                                     //Versão nova nossa, que extende painel, incluindo nossas 
                              implements MouseListener,                                                             //particularidades. Ela implementa tratamentos de eventos
                                         MouseMotionListener                                                        //e de movimento de mouse.
    {                                                                                                              //
		private static final long serialVersionUID = -6253339646021811311L;                                        //Número de série da classe.
                                                                                                                   //
		public MeuJPanel()                                                                                         //Construtor:
        {                                                                                                         //
            super();                                                                                              //Aciona o construtor herdado de JPanel;
                                                                                                                  //
            this.addMouseListener       (this);                                                                   //Configura como tratadora de eventos 
            this.addMouseMotionListener (this);                                                                   //de mouse a própria classe;
        }                                                                                                         //
                                                                                                                   //
        public void paint (Graphics g)                                                                             //Método usado para "pintar" no painel as figuras feitas:
        {                                                                                                         //
            for (int i=0 ; i<figuras.size(); i++)                                                                 //Para cada elemento do nosso vetor de figuras:
                figuras.get(i).torneSeVisivel(g);                                                                //tornamos a figura da vez visível no painel.
        }                                                                                                         //
                                                                                                                   //
        public void mousePressed (MouseEvent e)                                                                    //Quando o mouse é pressionado
        {                                                                                                         //tratamos esse evento assim:
        	switch(situacao) {                                                                                    //Caso estejamos...
	        	case ESPERANDO_PONTO:                                                                             // - Esperando por um ponto:
	        		figuras.add (new Ponto (e.getX(), e.getY(), corFigura));                                     //Adicionamos o ponto coas coordenadas do cursor no vetor de figuras
	        		figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());                      //e o tornamos visível no painel;
	        		situacao = Situacao.DEFAULT;                                                                 //Retornamos a situação ao estado inicial;
	        		break;                                                                                       //E pronto;
	        	case ESPERANDO_INICIO_RETA:                                                                       // - Esperando o início de uma reta:
	        		p1 = new Ponto (e.getX(), e.getY(), corFigura);                                              //Guardamos as coordenadas atuais do cursor no ponto antes criado;
	        		situacao = Situacao.ESPERANDO_FIM_RETA;                                                      //Indicamos na situação que temos o início. Esperamos pelo fim;
	        		statusBar1.setText("Mensagem: clique o ponto final da reta");                                //Indicamos ao usuário que clique no desejado ponto final da reta;
	        		break;                                                                                       //E pronto;
	        	case ESPERANDO_FIM_RETA:                                                                          // - Esperando o fim de uma reta:
	        		fimLinha(e);                                                                                 //Chamamos o método auxiliar que desenha a linha;
	                break;                                                                                       //E pronto;  
	        	case ESPERANDO_INICIO_CIRCULO:                                                                    // - Esperando o início de um círculo:
	        		p1 = new Ponto (e.getX(), e.getY(), corFigura);                                              //Guardamos as coordenadas atuais do cursor no ponto antes criado; 
	        		situacao = Situacao.ESPERANDO_FIM_CIRCULO;                                                   //Indicamos na situação que temos o início. Esperamos pelo fim;    
	        		statusBar1.setText("Mensagem: clique o ponto final do círculo");                             //Indicamos ao usuário que clique no desejado ponto final do círculo; 
	        		break;                                                                                       //E pronto;  
	        	case ESPERANDO_FIM_CIRCULO:                                                                       // - Esperando o fim de um círculo:
	        		fimCirculo(e);                                                                               //Chamamos o método auxiliar que desenha o círculo;
	                break;                                                                                       //E pronto;  
	        	case ESPERANDO_INICIO_ELIPSE:                                                                     // - Esperando o início de uma elipse:
	        		p1 = new Ponto (e.getX(), e.getY(), corFigura);                                              //Guardamos as coordenadas atuais do cursor no ponto antes criado; 
	        		situacao = Situacao.ESPERANDO_FIM_ELIPSE;                                                    //Indicamos na situação que temos o início. Esperamos pelo fim;    
	        		statusBar1.setText("Mensagem: clique o ponto final da elipse");                              //Indicamos ao usuário que clique no desejado ponto final da elipse; 
	        		break;                                                                                       //E pronto;  
	        	case ESPERANDO_FIM_ELIPSE:                                                                        // - Esperando o fim de uma elipse:
	        		fimElipse(e);                                                                                //Chamamos o método auxiliar que desenha a elipse;
	                break;                                                                                       //E pronto;  
	            case ESPERANDO_INICIO_RETANGULO:                                                                  // - Esperando o início de um círculo:                               
	            	p1 = new Ponto (e.getX(), e.getY(), corFigura);                                              //Guardamos as coordenadas atuais do cursor no ponto antes criado;    
	            	situacao = Situacao.ESPERANDO_FIM_RETANGULO;                                                 //Indicamos na situação que temos o início. Esperamos pelo fim;       
	            	statusBar1.setText("Mensagem: clique o ponto final do retângulo");                           //Indicamos ao usuário que clique no desejado ponto final do círculo; 
	            	break;                                                                                       //E pronto;                                                           
	            case ESPERANDO_FIM_RETANGULO:                                                                     // - Esperando o fim de um círculo:                                  
	            	fimRetangulo(e);                                                                             //Chamamos o método auxiliar que desenha o círculo;                   
	                break;                                                                                       //E pronto;                                                           
	            case ESPERANDO_INICIO_QUADRADO:                                                                   // - Esperando o início de uma elipse:                               
	            	p1 = new Ponto (e.getX(), e.getY(), corFigura);                                              //Guardamos as coordenadas atuais do cursor no ponto antes criado;    
	            	situacao = Situacao.ESPERANDO_FIM_QUADRADO;                                                  //Indicamos na situação que temos o início. Esperamos pelo fim;       
	            	statusBar1.setText("Mensagem: clique o ponto final da círculo");                             //Indicamos ao usuário que clique no desejado ponto final da elipse;  
	            	break;                                                                                       //E pronto;                                                           
	            case ESPERANDO_FIM_QUADRADO:                                                                      // - Esperando o fim de uma elipse:                                  
	            	fimQuadrado(e);                                                                              //Chamamos o método auxiliar que desenha a elipse;                    
	                break;                                                                                       //E pronto;            
	        	case DEFAULT:                                                                                     // - Em um caso diferente:
	        		statusBar1.setText("Mensagem:");                                                             //Apenas retornamos o status da mensagem a nada.
	        		break;                                                                                       //E pronto;  
				default: break;                                                                                  // - Em um defaulf, apenas por precaução;
        	}                                                                                                     //
        }                                                                                                          //
        public void mouseReleased (MouseEvent e)                                                                   //Quando o mouse é pressionado 
        {                                                                                                         //tratamos esse evento assim:   
        	if(arrastado)                                                                                         //Apenas se o botão tiver sido arrastado:
	        	switch(situacao)                                                                                 //Caso estejamos...
	        	{                                                                                               //
	        	case ESPERANDO_FIM_CIRCULO:                                                                     // - Esperando o fim de um círculo:                  
	        		fimCirculo(e);	        		                                                           //Chamamos o método auxiliar que desenha o círculo;   
	        		break;                                                                                     //E pronto;                                           
	        	case ESPERANDO_FIM_ELIPSE:                                                                      // - Esperando o fim de uma elipse:              
	        		fimElipse(e);                                                                              //Chamamos o método auxiliar que desenha a elipse;
	        		break;                                                                                     //E pronto;                                       
	        	case ESPERANDO_FIM_RETA:                                                                        // - Esperando o fim de uma reta:                        
	        		fimLinha(e);                                                                               //Chamamos o método auxiliar que desenha a linha;         
	        		break;                                                                                     //E pronto;                                               
				default: break;                                                                                // - Em um defaulf, apenas por precaução;   
	        	}                                                                                               //
        	arrastado = false;                                                                                    //Marcamos que já tratamos essa vez em que o mouse foi arrastado
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
    protected enum Situacao                                                                                         //Enumeração de situações;
    {                                                                                                              //
    	ESPERANDO_PONTO,                                                                                           //Esperando que se clique no Ponto;
    	ESPERANDO_INICIO_RETA,                                                                                     //Esperando que se clique no Início da Reta;
    	ESPERANDO_FIM_RETA,                                                                                        //Esperando que se clique no Fim da Reta;
    	ESPERANDO_INICIO_CIRCULO,                                                                                  //Esperando que se clique no Início do Círculo;
    	ESPERANDO_FIM_CIRCULO,                                                                                     //Esperando que se clique no Fim do Círculo;
    	ESPERANDO_INICIO_ELIPSE,                                                                                   //Esperando que se clique no Início da Elipse;
    	ESPERANDO_FIM_ELIPSE,                                                                                      //Esperando que se clique no Fim da Elipse;
    	ESPERANDO_INICIO_RETANGULO,                                                                                //Esperando que se clique no Início do Retângulo;
    	ESPERANDO_FIM_RETANGULO,                                                                                   //Esperando que se clique no Fim do Retângulo;   
    	ESPERANDO_INICIO_QUADRADO,                                                                                 //Esperando que se clique no Início da Quadrado; 
    	ESPERANDO_FIM_QUADRADO,                                                                                    //Esperando que se clique no Fim da Quadrado;    
    	DEFAULT;                                                                                                   //Esperando que se clique em algum botão;
    }                                                                                                              //
                                                                                                                    //
    protected class DesenhoDePonto implements ActionListener                                                        //Classe que trata o evento do botão Ponto:
    {                                                                                                              //
          public void actionPerformed (ActionEvent e)                                                              //Método no formato requerido pela implementação:
          {                                                                                                       //
              situacao = Situacao.ESPERANDO_PONTO;                                                                //Situamos o programa na espera de um ponto;
                                                                                                                  //
              statusBar1.setText("Mensagem: clique o local do ponto desejado");                                   //Indicamos na barra de status a situação;
          }                                                                                                       //
    }                                                                                                              //
                                                                                                                    //
    protected class DesenhoDeReta implements ActionListener                                                         //Classe que trata o evento do botão Reta:
    {                                                                                                              //
        public void actionPerformed (ActionEvent e)                                                                //Método no formato requerido pela implementação:
        {                                                                                                         //                                                
        	situacao = Situacao.ESPERANDO_INICIO_RETA;                                                            //Situamos o programa na espera de uma reta;      
                                                                                                                  //                                                
            statusBar1.setText("Mensagem: clique o ponto inicial da reta");                                       //Indicamos na barra de status a situação;        
        }                                                                                                         //
    }                                                                                                              //
                                                                                                                    //
    protected class DesenhoDeCirculo implements ActionListener                                                      //Classe que trata o evento do botão Círculo:
    {                                                                                                              //
    	public void actionPerformed (ActionEvent e)                                                                //Método no formato requerido pela implementação:
    	{                                                                                                         //                                                
    		situacao = Situacao.ESPERANDO_INICIO_CIRCULO;                                                         //Situamos o programa na espera de um círculo;      
                                                                                                                  //                                                
            statusBar1.setText("Mensagem: clique o ponto inicial do círculo");                                    //Indicamos na barra de status a situação;        
    	}                                                                                                         //
    }                                                                                                              //
                                                                                                                    //
    protected class DesenhoDeElipse implements ActionListener                                                       //Classe que trata o evento do botão Elipse:
    {                                                                                                              //
    	public void actionPerformed (ActionEvent e)                                                                //Método no formato requerido pela implementação:
    	{                                                                                                         //                                                
    		situacao = Situacao.ESPERANDO_INICIO_ELIPSE;                                                          //Situamos o programa na espera de uma elipse;      
                                                                                                                  //                                                
            statusBar1.setText("Mensagem: clique o ponto inicial da elipse");                                     //Indicamos na barra de status a situação;        
    	}                                                                                                         //
	}                                                                                                              //
	                                                                                                                //
	protected class DesenhoDeRetangulo implements ActionListener                                                    //Classe que trata o evento do botão Retângulo:
	{                                                                                                              //
		public void actionPerformed (ActionEvent e)                                                                //Método no formato requerido pela implementação:
		{                                                                                                         //                                                
			situacao = Situacao.ESPERANDO_INICIO_RETANGULO;                                                       //Situamos o programa na espera de um retângulo;      
			                                                                                                      //                                                
			statusBar1.setText("Mensagem: clique o ponto inicial do retangulo");                                  //Indicamos na barra de status a situação;        
		}                                                                                                         //
	}                                                                                                              //
	                                                                                                                //
	protected class DesenhoDeQuadrado implements ActionListener                                                     //Classe que trata o evento do botão Quadrado:
	{                                                                                                              //
		public void actionPerformed (ActionEvent e)                                                                //Método no formato requerido pela implementação:
		{                                                                                                         //                                                
			situacao = Situacao.ESPERANDO_INICIO_QUADRADO;                                                         //Situamos o programa na espera de uma quadrado;      
	                                                                                                              //                                                
			statusBar1.setText("Mensagem: clique o ponto inicial do quadrado");                                   //Indicamos na barra de status a situação;        
		}                                                                                                         //
	}                                                                                                              //
                                                                                                                    //
    protected class PegarCorDeFora implements ActionListener                                                        //Classe que trata o evento do botão CorFora:
    {                                                                                                              //
    	public void actionPerformed (ActionEvent e)                                                                //Método no formato requerido pela implementação:
    	{                                                                                                         //                                                
    		corFigura = JColorChooser.showDialog(Janela.this, "Selecione uma cor", corFigura);                    //Exibimos uma janela para a escolha de uma cor
    		                                                                                                      //              e guardamos seu retorno na variável de cor;
    		dentro = false;                                                                                       //Marcamos que estamos no modo de figuras não preenchidas;    
    	}                                                                                                         //    
    }                                                                                                              //
                                                                                                                    //
    protected class PegarCorDeDentro implements ActionListener                                                      //Classe que trata o evento do botão CorDentro:
    {                                                                                                              //
    	public void actionPerformed (ActionEvent e)                                                                //Método no formato requerido pela implementação:
    	{                                                                                                         //                                                
    		corFigura = JColorChooser.showDialog(Janela.this, "Selecione uma cor", corFigura);                    //Exibimos uma janela para a escolha de uma cor                
    		dentro = true;                                                                                        //              e guardamos seu retorno na variável de cor;    
    	}                                                                                                         //Marcamos que estamos no modo de figuras preenchidas;     
    }                                                                                                              //
                                                                                                                    //
    protected class FechamentoDeJanela extends WindowAdapter                                                        //Classe que trata o fechamento da janela:
    {                                                                                                              //
        public void windowClosing (WindowEvent e)                                                                  //Método no formato requerido pela implementação: 
        {                                                                                                         //
            System.exit(0);                                                                                       //Encerramos a janela;
        }                                                                                                         //
    }                                                                                                              //
                                                                                                                    //
    protected void fimLinha(MouseEvent e)                                                                           //Método auxiliar, para desenhar a linha:
    {                                                                                                              //
    	situacao = Situacao.DEFAULT;                                                                               //Retornamos a situação do programa ao default;
        figuras.add (new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corFigura));                              //Adicionamos ao vetor de figuras uma linha, cuja coordenada
                                                                                                                   //inicial vem do ponto em que guardamos o começo da linha e a 
                                                                                                                   //final é extraída do evendo de mouse, passado como parâmetro;
        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());                                    //Tornamos a nova linha visível no painel;
        statusBar1.setText("Mensagem:");                                                                           //Retornamos a barra de mensagem ao default;
    }                                                                                                              //
                                                                                                                    //
    protected void fimCirculo(MouseEvent e)                                                                         //Método auxiliar, para desenhar o círculo:
    {                                                                                                              //
    	situacao = Situacao.DEFAULT;                                                                               //Retornamos a situação do programa ao default; 
		int dimensao;                                                                                              //Criamos variável para guardar a dimensão do círculo;
		if((e.getX() - p1.getX()) < (e.getY() - p1.getY()))                                                        //Se o lado, dado pela seleção do usuário, vertical for maior:
			dimensao = (e.getY() - p1.getY());                                                                    //escolhemos ele como dimensão;
		else                                                                                                       //caso o contrário:
			dimensao = (e.getX() - p1.getX());                                                                    //sempre escolhemos o maior lado.
		Circulo circulo = new Circulo(p1.getX(), p1.getY(), dimensao, corFigura);                                  //Criamos um círculo, cuja coordenada   
		                                                                                                           //inicial vem do ponto em que guardamos o começo da linha e a   
                                                                                                                   //final é extraída do evendo de mouse, passado como parâmetro;
        circulo.setPreenchido(dentro); 																			   //Informamos se o círculo deve ser preenchido ou não;
        figuras.add (circulo);                                                                                     //Adicionamos ao vetor de figuras o círculo;
        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());                                    //Tornamos o novo círculo visível no painel;                      
        statusBar1.setText("Mensagem:");                                                                           //Retornamos a barra de mensagem ao default;                    
    }                                                                                                              //
                                                                                                                    //
    protected void fimElipse(MouseEvent e)                                                                          //
    {                                                                                                              //
    	situacao = Situacao.DEFAULT;                                                                               //Retornamos a situação do programa ao default;                
        Elipse elipse = new Elipse(p1.getX(), p1.getY(), (e.getX() - p1.getX()),                                   //Criamos uma uma elipse, cuja coordenada   
        		(e.getY() - p1.getY()), corFigura);                                                                //inicial vem do ponto em que guardamos o começo da linha e a  
                                                                                                                   //final é extraída do evendo de mouse, passado como parâmetro;
		elipse.setPreenchido(dentro);                                                                              //Informamos se a elipse deve ser preenchido ou não;     
		figuras.add (elipse);                                                                                      //Adicionamos ao vetor de figuras a elipse;              
		figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());                                    //Tornamos a nova linha visível no painel;
		statusBar1.setText("Mensagem:");                                                                           //Retornamos a barra de mensagem ao default;               
    }                                                                                                              //
    protected void fimQuadrado(MouseEvent e)                                                                       //Método auxiliar, para desenhar o quadrado:                        
    {                                                                                                              //                                                                  
    	situacao = Situacao.DEFAULT;                                                                               //Retornamos a situação do programa ao default;                     
    	int dimensao;                                                                                              //Criamos variável para guardar a dimensão do quadrado;              
    	if((e.getX() - p1.getX()) < (e.getY() - p1.getY()))                                                        //Se o lado, dado pela seleção do usuário, vertical for maior:      
    		dimensao = (e.getY() - p1.getY());                                                                    //escolhemos ele como dimensão;                                      
    	else                                                                                                       //caso o contrário:                                                 
    		dimensao = (e.getX() - p1.getX());                                                                    //sempre escolhemos o maior lado.                                    
    	Quadrado quadrado = new Quadrado(p1.getX(), p1.getY(), dimensao, corFigura);                              //Criamos um quadrado, cuja coordenada                               
    	                                                                                                           //inicial vem do ponto em que guardamos o começo da linha e a       
                                                                                                                   //final é extraída do evendo de mouse, passado como parâmetro;      
    	quadrado.setPreenchido(dentro); 																		   //Informamos se o quadrado deve ser preenchido ou não;               
        figuras.add (quadrado);                                                                                    //Adicionamos ao vetor de figuras o quadrado;                        
        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());                                    //Tornamos o novo quadrado visível no painel;                        
        statusBar1.setText("Mensagem:");                                                                           //Retornamos a barra de mensagem ao default;                        
    }                                                                                                              //                                                                  
                                                                                                                    //                                                                 
    protected void fimRetangulo(MouseEvent e)                                                                       //                                                                 
    {                                                                                                              //                                                                  
    	situacao = Situacao.DEFAULT;                                                                               //Retornamos a situação do programa ao default;                     
        Retangulo retangulo = new Retangulo(p1.getX(), p1.getY(), (e.getX() - p1.getX()),                          //Criamos um retangulo, cuja coordenada                           
        		(e.getY() - p1.getY()), corFigura);                                                                //inicial vem do ponto em que guardamos o começo da linha e a       
                                                                                                                   //final é extraída do evendo de mouse, passado como parâmetro;      
        retangulo.setPreenchido(dentro);                                                                           //Informamos se o retangulo deve ser preenchido ou não;               
    	figuras.add (retangulo);                                                                                   //Adicionamos ao vetor de figuras o retangulo;                        
    	figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());                                    //Tornamos a nova linha visível no painel;                          
    	statusBar1.setText("Mensagem:");                                                                           //Retornamos a barra de mensagem ao default;                        
    }                                                                                                              //         
}                                                                                                                   //
//FIM DA CLASSE!                                                                                                    