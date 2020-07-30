package bd;

public class Desenhos {
	public static Desenho getDesenho(long idDesenho) throws Exception 
    {
		Desenho desenho = null;
        try 
        {
                String sql = "select * from Desenho where Id = ?";
                BDSQLServer.COMANDO.prepareStatement(sql);
                BDSQLServer.COMANDO.setLong(1, idDesenho);
                MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
                if(!resultado.first())
                        throw new Exception("N�o cadastrado");
     
                desenho = new Desenho(idDesenho, 
                                          resultado.getString("eMailDoDono"),
                      	                  resultado.getString("Nome"));
        }
        catch(Exception ex) 
        {
        		ex.printStackTrace();
                throw new Exception("Erro ao procurar desenho");
        }
        return desenho;
    }
    
    public static boolean registrado(long idDesenho) throws Exception
    {
            boolean retorno = false;
            try 
            {
                    String sql;
                    sql = "select * from Desenho where Id = ?";
                    BDSQLServer.COMANDO.prepareStatement(sql);
                    BDSQLServer.COMANDO.setLong(1,idDesenho);
                    MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
                    retorno = resultado.first();
            }
            catch(Exception ex) 
            {
                    throw new Exception("Erro ao verificar Desenho");
            }

            return retorno;
    }
    
    public static void alterar(Desenho desenho) throws Exception
    {
            if(desenho == null)
                    throw new Exception("Preencha todos os espa�os");

            try 
            {
                    String sql;
                    sql = "update Desenho set eMailDoDono = ?, Nome = ? where Id = ?";

                    BDSQLServer.COMANDO.prepareStatement(sql);
                    BDSQLServer.COMANDO.setString(1, desenho.getEMailDoDono());
                    BDSQLServer.COMANDO.setString(2, desenho.getNome());
                    BDSQLServer.COMANDO.setLong(3, desenho.getIdDesenho());

                    
                    BDSQLServer.COMANDO.executeUpdate();
                    BDSQLServer.COMANDO.commit();
            }
            catch(Exception ex) 
            {
            		ex.printStackTrace();
                    throw new Exception("Erro ao alterar os dados");
            }
    }
    
    public static void incluir(Desenho desenho) throws Exception
    {
            if(desenho == null)
                    throw new Exception("Valores n�o fornecidos");
            if(Desenhos.registrado(desenho.getIdDesenho()))
                    throw new Exception("Desenho j� registrado");
            try 
            {
                    String sql;
                    sql = "insert into Desenho values(?, ?, ?)";
                    BDSQLServer.COMANDO.prepareStatement(sql);
                    BDSQLServer.COMANDO.setLong  (1, desenho.getIdDesenho());
                    BDSQLServer.COMANDO.setString(2, desenho.getEMailDoDono());
                    BDSQLServer.COMANDO.setString(3, desenho.getNome());

                    BDSQLServer.COMANDO.executeUpdate();
                    BDSQLServer.COMANDO.commit();
            }
            catch(Exception ex) 
            {
            		ex.printStackTrace();
                    throw new Exception("Erro ao incluir/ Verifique todos os campos");
            }
    }
    
    public static void deletar(long idDesenho) throws Exception
    {
        if(0 > idDesenho)
            throw new Exception("Desenho inv�lido");
        if(!Desenhos.registrado(idDesenho))
            throw new Exception("Desenho n�o registrado");
        try 
        {
                String sql;
                sql = "delete from Desenhos where Id = ?";
                BDSQLServer.COMANDO.prepareStatement(sql);
                BDSQLServer.COMANDO.setLong(1, idDesenho);
                BDSQLServer.COMANDO.executeUpdate();
                BDSQLServer.COMANDO.commit();
        }
        catch(Exception ex) 
        {
                throw new Exception("Erro ao deletar/ Verifique todos os campos");
        }
    }
}
