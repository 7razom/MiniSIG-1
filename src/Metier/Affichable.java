package Metier;


//Interface qui instancie 4 attributs utilis� dans POI, Parcours et Lieu
public abstract class Affichable
{
	private String libelle;
	private String description;
	private String url; //A CHANGER ! Quel type mettre pour une image ?
	private String image;
	
	//Get
	public String getLibelle()
	{
		return this.libelle;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public String getUrl()
	{
		return this.url;
	}
	
	public String getImage()
	{
		return this.image;
	}
	
	
	//Set
	public void setLibelle(String str)
	{
		this.libelle = str;
	}
	
	public void setDescription(String str)
	{
		this.description = str;
	}
	
	public void setUrl(String str)
	{
		this.url = str;
	}
	
	public void setImage(String str)
	{
		this.image = str;
	}
}
