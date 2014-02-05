package IHM;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Metier.Pcs_recherche;


public class PanelRecherche extends JPanel implements ActionListener{
	private JTable table;
	private Model model;
	private Pcs_recherche oPcs;
	private JTextField tRecherche;
	private JButton button;
	private PanelInfo info;
	private JScrollPane scroll;
	
	public PanelRecherche(Pcs_recherche oPcs, PanelInfo info)
	{
		this.info = info;
		tRecherche = new JTextField("m");
		this.oPcs = oPcs;
		model = oPcs.Recherche(tRecherche.getText());
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(1,2));
		button = new JButton("Rechercher");
		button.addActionListener(this);
		table = new JTable(model);
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		table = new JTable(model);
		table.setDefaultRenderer(JButton.class, new TableComponent());
		table.getColumn("Voir").setCellRenderer(new ButtonRenderer());
		table.getColumn("Voir").setCellEditor(new ButtonEditor(new JCheckBox(), info, oPcs));
		pane.add(tRecherche);
		pane.add(button);
		this.add(pane);
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(200, 200));
		this.add(scroll);
		tRecherche.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button)
		table.setModel(oPcs.Recherche(tRecherche.getText()));
		table.setDefaultRenderer(JButton.class, new TableComponent());
		table.getColumn("Voir").setCellRenderer(new ButtonRenderer());
		table.getColumn("Voir").setCellEditor(new ButtonEditor(new JCheckBox(), info, oPcs));
	}
}
