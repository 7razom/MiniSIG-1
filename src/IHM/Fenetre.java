package IHM;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	
	private PanelCarte carte;
	private PanelInfo info;
	
	public Fenetre() {
		this.setTitle("MiniSIG");
		this.setSize(1086,768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		carte = new PanelCarte();
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());
		JPanel map = new JPanel();
		map.add(carte);
		
		//Panel INFO
		info = new PanelInfo();
		
		
		root.add(map, BorderLayout.CENTER);
		root.add(info, BorderLayout.EAST);
		
		
    
		this.getContentPane().add(root);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
