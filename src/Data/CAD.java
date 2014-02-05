package Data;
import java.sql.*;

public class CAD 
{
    private String url;
    private String user;
    private String passwd; 
    private String name;
    private Connection conn;
    private Statement state;
    
    //Constructeur surcharg�
    public CAD(String url, String user, String passwd, String name)
    {
        this.url = url;
        this.user = user;
        this.passwd = passwd;
        this.name = name;
        
        connexion();
    }
    
    //Essai de connexion
    public void connexion()
    {
	    try
		{
		    Class.forName(name);
		    System.out.println("Le chargement du driver JDBC fonctionne");
	                
	            this.conn = DriverManager.getConnection(url, user, passwd);
	               
	            state = this.conn.createStatement();
	            System.out.println("Connexion effective !");
		 }
		 catch (Exception ex) 
		 {
		    System.out.println("Erreur du driver JDBC");
		 }
    }
    
    //getRows : Requ�te de selection
    public ResultSet getRows(String gr_requete) throws SQLException
    {
        //On d�clare d'abord les objets ici
        
        ResultSet result = null;
        
        try 
        {
        	state = this.conn.createStatement();
            
            //L'objet ResultSet contient le r�sultat de la requ�te SQL
            result = state.executeQuery(gr_requete);
            
			

        } 
        catch (SQLException ex) 
        {
        	 ex.printStackTrace();
        }  
        
        return result;
    }
    
    /*//Recuperer les metadata
    public ResultSetMetaData getMetaData(String gmd_requete)
    {
    	Statement state;
    	ResultSetMetaData meta = null;
    	ResultSet result = null;
    	
    	try
    	{
    		state = this.conn.createStatement();
	    	result = state.executeQuery(gmd_requete);
	    	meta = result.getMetaData();
    	}
    	catch (SQLException ex)
    	{
    		
    	}
    	return meta;
    }*/
    
    //actionRows : Requ�te INSERT, UPDATE, DELETE
    public void actionRows(String ar_requete) throws SQLException
    {
    	Statement state;
    	
    	try
    	{
    		state = this.conn.createStatement();
    		state.executeUpdate(ar_requete);
    	}
    	catch (SQLException ex)
    	{
    		
    	}
    }
}