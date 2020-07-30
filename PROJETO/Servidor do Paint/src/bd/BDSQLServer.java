package bd;


public class BDSQLServer
{
	public static final MeuPreparedStatement COMANDO;

    static
    {
    	MeuPreparedStatement comando = null;

    	try
        {
    		comando =
    	            new MeuPreparedStatement (
    	            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
    	            "jdbc:sqlserver://regulus.cotuca.unicamp.br;databasename=BD19179",
    	            "BD19179", "BD19179");
        }
        catch (Exception erro)
        {
        	System.out.println(erro);
            System.err.println ("Problemas de conexão com o Banco");
            erro.printStackTrace();
            System.exit(0); // aborta o programa
        }
        
        COMANDO = comando;
    }
}