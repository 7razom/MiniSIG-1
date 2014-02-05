package Metier;
import Data.*;

import java.sql.*;

public class Pcs_POI 
{
	private CAD oCAD;
	private mpg_POI oMpg;
	private POI oPOI;
	String NomMembre;
	ResultSet result;
	ResultSetMetaData metaData;
	
	String libelle;
	String description;
	String url;
	String image;
	int x;
	int y;
	
	//Constructeur qui fournis les infos de connexion à la BDD
	public Pcs_POI()
	{
		oCAD = new CAD("jdbc:mysql://127.0.0.1/minisig", "root", "", "com.mysql.jdbc.Driver");
		oMpg = new mpg_POI();
	}

	//Charger les POI sur la carte
	public void AfficherPOI()
	{
		
	}
	
	//Créer des POI
	public void CreerPOI()
	{
		
	}
	
	//Modifier des POI
	public void ModifPOI()
	{
		
	}
	
	//Voir un POI dans le panel de droite
	public POI ConsulterPOI()
	{
		POI oPoi = null;
		try
		{
			result = oCAD.getRows(oMpg.SelectAll());
			
			while (result.next()) 
            {
                libelle = result.getString("Libelle_poi");
                description = result.getString("Description_poi");
                url = result.getString("Url_poi");
                image = result.getString("Image_poi");
                x = result.getInt("X_poi");
                y = result.getInt("Y_poi");
                
				System.out.println(libelle + "\t" + description + "\t" + url + "\t" + image + "\t" + x + "\t" + y);
            }
			
			oPoi = new POI(libelle, description, url, image, x, y);
		}
		catch (SQLException ex) 
		{

		}
		
		return oPoi; //On affiche le resultat après le try catch
	}
	
	
	
}
