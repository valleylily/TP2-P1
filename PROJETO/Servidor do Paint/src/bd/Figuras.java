package bd;

public class Figuras {
	public static Figura getFigura(int idFigura, long idDesenho) throws Exception 
    {
		Figura figura = null;
        try 
        {
                String sql = "select * from Figura where Id = ? and IdDoDesenho = ?";
                BDSQLServer.COMANDO.prepareStatement(sql);
                BDSQLServer.COMANDO.setInt(1, idFigura);
                BDSQLServer.COMANDO.setLong(2, idDesenho);
                MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
                if(!resultado.first())
                        throw new Exception("Não cadastrado");
     
                figura = new Figura(idDesenho, 
                                          resultado.getString("Figura"),
                                          idFigura);
        }
        catch(Exception ex) 
        {
        		ex.printStackTrace();
                throw new Exception("Erro ao procurar Figura");
        }
        return figura;
    }
    
    public static boolean registrado(int idFigura, long idDesenho) throws Exception
    {
            boolean retorno = false;
            try 
            {
                    String sql;
                    sql = "select * from Figura where Id = ? and IdDoDesenho = ?";
                    BDSQLServer.COMANDO.prepareStatement(sql);
                    BDSQLServer.COMANDO.setInt(1,idFigura);
                    BDSQLServer.COMANDO.setLong(2,idDesenho);
                    MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
                    retorno = resultado.first();
            }
            catch(Exception ex) 
            {
                    throw new Exception("Erro ao verificar Figura");
            }

            return retorno;
    }
    
    public static void alterar(Figura figura) throws Exception
    {
            if(figura == null)
                    throw new Exception("Preencha todos os espaÃ§os");

            try 
            {
                    String sql;
                    sql = "update Figura set Figura = ? where Id = ? and IdDoDesenho = ?";

                    BDSQLServer.COMANDO.prepareStatement(sql);
                    BDSQLServer.COMANDO.setString(1, figura.getFigura());
                    BDSQLServer.COMANDO.setInt(2, figura.getIdFigura());
                    BDSQLServer.COMANDO.setLong(3, figura.getIdDesenho());

                    
                    BDSQLServer.COMANDO.executeUpdate();
                    BDSQLServer.COMANDO.commit();
            }
            catch(Exception ex) 
            {
            		ex.printStackTrace();
                    throw new Exception("Erro ao alterar os dados");
            }
    }
    
    public static void incluir(Figura figura) throws Exception
    {
            if(figura == null)
                    throw new Exception("Valores nÃ£o fornecidos");
            if(Figuras.registrado(figura.getIdFigura(), figura.getIdDesenho()))
                    throw new Exception("Voo jÃ¡ registrado");
            try 
            {
                    String sql;
                    sql = "insert into Figura values(?, ?, ?)";
                    BDSQLServer.COMANDO.prepareStatement(sql);
                    BDSQLServer.COMANDO.setLong(1, figura.getIdDesenho());
                    BDSQLServer.COMANDO.setInt(2, figura.getIdFigura());
                    BDSQLServer.COMANDO.setString(3, figura.getFigura());

                    BDSQLServer.COMANDO.executeUpdate();
                    BDSQLServer.COMANDO.commit();
            }
            catch(Exception ex) 
            {
            		ex.printStackTrace();
                    throw new Exception("Erro ao incluir/ Verifique todos os campos");
            }
    }
    
    public static void deletar(int idFigura, long idDesenho) throws Exception
    {
        if(0 > idFigura)
            throw new Exception("Figura inválido");
        if(!Figuras.registrado(idFigura, idDesenho))
            throw new Exception("Figura não registrado");
        try 
        {
                String sql;
                sql = "delete from Voo where Id = ? and IdDoDesenho = ?";
                BDSQLServer.COMANDO.prepareStatement(sql);
                BDSQLServer.COMANDO.setInt(1, idFigura);
                BDSQLServer.COMANDO.setLong(2, idDesenho);
                BDSQLServer.COMANDO.executeUpdate();
                BDSQLServer.COMANDO.commit();
        }
        catch(Exception ex) 
        {
                throw new Exception("Erro ao deletar/ Verifique todos os campos");
        }
    }
}
