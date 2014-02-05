package IHM;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import Metier.Pcs_recherche;

public class ButtonEditor extends DefaultCellEditor {

  protected JButton button;
  private boolean   isPushed;
  private ButtonListener bListener = new ButtonListener();
  private PanelInfo info;
  private Pcs_recherche Pcs;
   
  //Constructeur avec une CheckBox
  public ButtonEditor(JCheckBox checkBox, PanelInfo info, Pcs_recherche Pcs) {
    //Par défaut, ce type d'objet travaille avec un JCheckBox
    super(checkBox);
    //On crée à nouveau un bouton
    button = new JButton();
    button.setOpaque(true);
    //On lui attribue un listener
    button.addActionListener(bListener);
    this.info = info;
    this.Pcs = Pcs;
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) { 
    //On précise le numéro de ligne à notre listener
    bListener.setRow(row);
    //Idem pour le numéro de colonne
    bListener.setColumn(column);
    //On passe aussi le tableau en paramètre pour des actions potentielles
    bListener.setTable(table);
      
    //On réaffecte le libellé au bouton
    button.setText( (value == null) ? "" : value.toString() );
    //On renvoie le bouton
    return button;
  }
   
  //Notre listener pour le bouton
  class ButtonListener implements ActionListener{        
    private int column, row;
    private JTable table;
    private int nbre = 0;
        
    public void setColumn(int col){this.column = col;}
    public void setRow(int row){this.row = row;}
    public void setTable(JTable table){this.table = table;}
        
    public void actionPerformed(ActionEvent event) {
    	info.VisibleDescription(Pcs.SelectOne(table.getValueAt(row, 0).toString(), (int)(table.getValueAt(row, 3))));
    }
  }     
}