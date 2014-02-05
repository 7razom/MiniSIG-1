package Data;

public class mpg_Parcours
{
	private String rq_sql;
	
	public mpg_Parcours()
	{
		this.rq_sql = null;
	}
	
	public String SelectAll(String recherche)
	{
		this.rq_sql = "SELECT Id_parcours, Libelle_parcours FROM parcours WHERE Libelle_parcours LIKE '%"+recherche+"%' OR Description_parcours = '%"+recherche+"%'";
		return this.rq_sql;
	}
	
	public String SelectOne(int id)
	{
		this.rq_sql = "SELECT * FROM parcours WHERE Id_parcours = "+id+"";
		return this.rq_sql;
	}
	
	//Requête pour recherche
	public String SelectCount(String recherche)
	{
		this.rq_sql = "SELECT count(*) from parcours WHERE Libelle_parcours LIKE '%"+recherche+"%' OR Description_parcours = '%"+recherche+"%'";
		return rq_sql;
	}
}
