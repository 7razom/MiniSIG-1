package IHM;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class Model extends AbstractTableModel{
    private Object[][] data;
    private String[] title;

    //Constructeur
    public Model(Object[][] data, String[] title){
    	
      this.data = data;
      this.title = title;
    }

    //Retourne le nombre de colonnes
    public int getColumnCount() {
      return this.title.length;
    }

    //Retourne le nombre de lignes
    public int getRowCount() {
      return this.data.length;
    }

    //Retourne la valeur � l'emplacement sp�cifi�
    public Object getValueAt(int row, int col) {
      return this.data[row][col];
    } 
    
    /**
    * Retourne le titre de la colonne � l'indice sp�cifi�
    */
    public String getColumnName(int col) {
      return this.title[col];
    }
    
    public Class getColumnClass(int col){
    	  //On retourne le type de la cellule � la colonne demand�e
    	  //On se moque de la ligne puisque les types de donn�es sont les m�mes quelle que soit la ligne
    	  //On choisit donc la premi�re ligne
    	  return this.data[0][col].getClass();
    	}
    public boolean isCellEditable(int row, int col){
    	  //On appelle la m�thode getValueAt qui retourne la valeur d'une cellule
    	  //Et on effectue un traitement sp�cifique si c'est un JButton
    	  if(getValueAt(0, col) instanceof JButton)
    	    return false;
    	  return true; 
    	}
  }