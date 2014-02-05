package Metier;

public class POI extends Point
{
	
	public POI(String libelle, String description, String url, String image, int x, int y)
	{
		super(x, y); 
		this.setLibelle(libelle);
		this.setDescription(description);
		this.setUrl(url);
		this.setImage(image);
	}
}
