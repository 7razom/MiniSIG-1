package Metier;
import java.sql.ResultSet;
import java.sql.SQLException;

import Data.CAD;
import Data.mpg_Lieu;
import Data.mpg_POI;
import Data.mpg_Parcours;
import IHM.Model;

public class Pcs_recherche 
{
	private CAD oCAD;
	private mpg_POI oMpg_poi;
	private mpg_Parcours oMpg_parcours;
	private mpg_Lieu oMpg_lieu;
	ResultSet result;
	
	public Pcs_recherche()
	{
		oCAD = new CAD("jdbc:mysql://127.0.0.1/minisig", "root", "", "com.mysql.jdbc.Driver");
		oMpg_poi = new mpg_POI();
		oMpg_lieu = new mpg_Lieu();
		oMpg_parcours = new mpg_Parcours();
		
	}
	
	public Affichable SelectOne(String type, int id) 
	{
		Affichable aff = null;
		ResultSet result;
		try {
			switch(type)
			{
			case "Parcours" :
				result = oCAD.getRows(oMpg_parcours.SelectOne(id));
				// à implémenter
				break;
			case "POI" :
				result = oCAD.getRows(oMpg_poi.SelectOne(id));
				result.next();
				aff = new POI(result.getString("Libelle_poi"),result.getString("Description_poi"),result.getString("Url_poi"),result.getString("Image_poi"),result.getInt("X_poi"),result.getInt("Y_poi") );
				break;
			case "Lieu" :
				result = oCAD.getRows(oMpg_lieu.SelectOne(id));
				// à implémenter
				break;
			}
		} catch (Exception e) {}
		
		return aff;
	}
	
	public Model Recherche(String recherche)
	{
		Model model= null;
		int z = 0;
		if(recherche.length() != 0)
		{
			try {
				result = oCAD.getRows(oMpg_poi.SelectCount(recherche));
				result.next();
				z = result.getInt(1);
				result = oCAD.getRows(oMpg_lieu.SelectCount(recherche));
				result.next();
				z += result.getInt(1);
				result = oCAD.getRows(oMpg_parcours.SelectCount(recherche));
				result.next();
				z += result.getInt(1);
			} catch (Exception e) {}
		}
		
		System.out.println(z);
		
		Object[][] element = new Object[z][4];
		String[] titre = {"Type", "Libelle", "Voir", "Id"};
		if(recherche.length() != 0)
		{
			try
			{
				int i = 0;
				result = oCAD.getRows(oMpg_lieu.SelectAll(recherche));
				
				while(result.next() && i < 25)
				{
					element[i][0] = "Lieu";
					element[i][1] = result.getString(2);
					element[i][2] = "Voir plus";
					element[i][3] = result.getInt(1);
					i++;
				}
				
				result = oCAD.getRows(oMpg_parcours.SelectAll(recherche));
				while(result.next() && i < 25)
				{
					element[i][0] = "Parcours";
					element[i][1] = result.getString(2);
					element[i][2] = "Voir plus";
					element[i][3] = result.getInt(1);
					i++;
				}
				result = oCAD.getRows(oMpg_poi.SelectAll(recherche));
				
				while(result.next() && i < 25)
				{
					element[i][0] = "POI";
					element[i][1] = result.getString(2);
					element[i][2] = "Voir plus";
					element[i][3] = result.getInt(1);
					i++;
				}
				
			}
			catch (SQLException e)
			{
				
			}
		}
		model = new Model(element, titre);
		
		return model;
	}
}
