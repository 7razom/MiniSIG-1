package IHM;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class PanelDescription extends Panel implements ActionListener{
	private JLabel Libelle;
	private JTextArea Description;
	private JButton Back;
	private JButton Generate;
	private JLabel URL;
	private ImageIcon img;
	private PanelInfo info;
	
	public PanelDescription(PanelInfo info)
	{
		this.info = info;
		this.setLayout(new GridLayout(4,1));
		Libelle = new JLabel("");
		Description = new JTextArea("Description : tagada oizjhe' floizjeof jzeohj qzmeoejf mqozeihjf qmozejhfmo zhe'mofqjz h'moqz emvo ");
		URL = new JLabel("http://google.fr");
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(1,2));
		Back = new JButton("Fermer");
		Back.addActionListener(this);
		Generate = new JButton("Générer");
		pane.add(Generate);
		pane.add(Back);
		Description.setPreferredSize(new Dimension(25, 25));
		Description.setLineWrap(true);
		Description.setEditable(false);
		Description.setBackground(null);
		add(Libelle);
		add(Description);
		add(URL);
		add(pane);
	}
	
	public void setLibelle(String str)
	{
		Libelle.setText("Libelle : " + str);
	}
	
	public void setDescription(String str)
	{
		Description.setText(str);
	}
	
	public void setURL(String str)
	{
		URL.setText("URL : " + str);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Back)
		{
			info.UnVisibleDescription();
		}
		else if(e.getSource() == Generate)
		{
			
		}
		
	}
}
