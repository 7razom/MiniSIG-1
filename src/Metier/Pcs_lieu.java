package Metier;

import java.sql.ResultSet;
import java.sql.SQLException;

import Data.CAD;


public class Pcs_lieu 
{
	private Data.mpg_Lieu oMpg_Lieu;
	private Data.CAD oCAD = new CAD("jdbc:mysql://127.0.0.1/minisig", "root", "", "com.mysql.jdbc.Driver");

	
	public Pcs_lieu()
	{
		this.oMpg_Lieu = new Data.mpg_Lieu();
		this.oCAD = new Data.CAD("jdbc:mysql://127.0.0.1/minisig", "root", "", "com.mysql.jdbc.Driver");
		
	}
	
	
	public void Consulter_Lieu(ResultSet result) throws SQLException 
	{
		 result = oCAD.getRows(oMpg_Lieu.SelectAll());
	}
	
	/*public ResultSet Ajouter_Lieu(ResultSet result, String image, char libelle, char description, String Url) throws SQLException 
	{
	    //result = oCAD.actionRows(oMpg_Lieu.Ajout_lieu(image, libelle, description, Url));
	}*/
	
	public void Modifier_Lieu() 
	{
		
	}
	
	public void Supprimer_Lieu(ResultSet result, String image, char libelle, char description, String Url) 
	{
		//result = oCAD.actionRows(oMpg_Lieu.Supprimer_lieu(libelle));
	}
	
	public void Afficher_Lieu() 
	{
		
	}
}
