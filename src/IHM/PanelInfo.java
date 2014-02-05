package IHM;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import Metier.Affichable;
import Metier.POI;
import Metier.Pcs_recherche;


public class PanelInfo extends JPanel{
	private PanelDescription description;
	private PanelRecherche recherche;
	private Pcs_recherche oPcs;
	
	public PanelInfo()
	{
		setPreferredSize(new Dimension(400, this.getY()));
		oPcs = new Pcs_recherche();
		
		
		recherche = new PanelRecherche(oPcs, this);
		
		
		JPanel news = new JPanel();
		news.setBackground(Color.BLACK);
		news.setPreferredSize(new Dimension(this.getX(), 200));
		setLayout(new BorderLayout());
		
		add(recherche, BorderLayout.NORTH);
		//info.add(description, BorderLayout.CENTER);
		add(news, BorderLayout.SOUTH);
		description = new PanelDescription(this);
		add(description);
		description.setVisible(false);
	}
	
	public void VisibleDescription(Affichable aff)
	{
		description.setVisible(true);
		System.out.println(aff.getLibelle());
		description.setLibelle(aff.getLibelle());
		description.setDescription(aff.getDescription());
		description.setURL(aff.getUrl());
	}
	public void UnVisibleDescription()
	{
		description.setVisible(false);
		description.setLibelle("");
		description.setDescription("");
		description.setURL("");
	}
}
