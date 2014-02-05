package Data;

public class mpg_POI
{
	private String rq_sql;
	
	public mpg_POI ()
	{
		this.rq_sql = null;
	}
	
	//Selection
	public String SelectAll()
	{
		//Condition si le libelle_poi est = à la recherche de l'utilisateur avec les % pour les carac avant/après
		this.rq_sql = "SELECT Id_poi, Libelle_poi FROM poi";
		return rq_sql;
	}
	
	public String SelectAll(String recherche)
	{
		//Condition si le libelle_poi ou la description est = à la recherche de l'utilisateur avec les % pour les carac avant/après
		this.rq_sql = "SELECT Id_poi, Libelle_poi FROM poi WHERE Libelle_poi LIKE '%"+recherche+"%' OR Description_poi = '%"+recherche+"%';";
		return rq_sql;
	}
	
	public String SelectOne(int id)
	{
		this.rq_sql = "SELECT * FROM poi WHERE Id_poi = "+id+";";
		return rq_sql;
	}
	
	//Requête pour recherche
	public String SelectCount(String recherche)
	{
		this.rq_sql = "SELECT count(*) from poi WHERE Libelle_poi LIKE '%"+recherche+"%' OR Description_poi = '%"+recherche+"%'";
		return rq_sql;
	}
}
