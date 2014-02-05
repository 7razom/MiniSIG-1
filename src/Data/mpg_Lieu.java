package Data;

public class mpg_Lieu 
{
	private String rq_sql;
	
	public mpg_Lieu()
	
	{
		this.rq_sql = null;
	}
	
	//Affiche un lieu
	public String SelectAll()
	{
		this.rq_sql = "SELECT Id_lieu, Libelle_lieu FROM lieu";
		return this.rq_sql;
	}
	
	public String SelectAll(String recherche)
	{
		this.rq_sql = "SELECT Id_lieu, Libelle_lieu FROM lieu WHERE Libelle_lieu LIKE '%"+recherche+"%' OR Description_lieu = '%"+recherche+"%'";
		return this.rq_sql;
	}
	
	public String SelectOne(int id)
	{
		this.rq_sql = "SELECT * FROM lieu WHERE Id_lieu = "+id+"";
		return this.rq_sql;
	}
	
	//Requête pour recherche
	public String SelectCount(String recherche)
	{
		this.rq_sql = "SELECT count(*) from lieu WHERE Libelle_lieu LIKE '%"+recherche+"%' OR Description_lieu = '%"+recherche+"%'";
		return rq_sql;
	}
	
	//Ajouter un lieu
	public String Ajout_lieu(String image, char libelle, char description, String Url)
	{
		this.rq_sql = "INSERT INTO lieu (Image_grd_lieu, Libelle_lieu, Description_lieu, Url_lieu VALUES (" + image + "," + libelle + "," + description + "," + Url + ")";
		return this.rq_sql;
	}
	
	public String Modif_lieu(char libelle )
	{
		this.rq_sql = "SELECT Image_grd_lieu, Libelle_lieu, Description_lieu, Url_lieu FROM lieu WHERE Libelle_Lieu = "+ libelle +"";
		return this.rq_sql;
	}
	
	public String Supprimer_lieu(char libelle )
	{
		this.rq_sql = "DELETE Id_lieu, Image_grd_lieu, Libelle_lieu, Description_lieu, Url_lieu FROM lieu WHERE Libelle_Lieu = "+ libelle +"";
		return this.rq_sql;
	}
}
