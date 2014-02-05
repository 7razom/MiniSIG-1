package IHM;
import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.*;
import java.io.*;

public class PanelCarte extends JPanel implements MouseListener , MouseMotionListener{
	
	private JLabel point;
	private JLabel point2;
	private int x;
	private int y;
	
	public PanelCarte()
	{
		this.setLayout(null);
		ImageIcon imgico = new ImageIcon("Capture.PNG");
		ImageIcon pointico = new ImageIcon("Point.PNG");
		
		point = new JLabel(pointico);
		add(point);
		point.setBounds(100,500,pointico.getIconWidth(),pointico.getIconHeight());
		point2 = new JLabel(pointico);
		add(point2);
		point2.setBounds(10,500,pointico.getIconWidth(),pointico.getIconHeight());
		
		JLabel img = new JLabel(imgico);
		add(img);
		setPreferredSize(new Dimension(imgico.getIconWidth(),imgico.getIconHeight()));
		img.setBounds(0,0,imgico.getIconWidth(),imgico.getIconHeight());
		
		
		
		
		point.addMouseListener(this);
		point.addMouseMotionListener(this);
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void mouseClicked(MouseEvent e){ }

    public void mousePressed(MouseEvent e){
    	if(e.getSource() == this)
    	{
    		x = e.getX();
    		y = e.getY();
    	}
    }
    
    public void mouseDragged(MouseEvent e)
    {
    	if(e.getSource() == this)
    	{
    		JComponent jc = (JComponent)e.getSource();
        	jc.setLocation(jc.getX()+(e.getX() - x), jc.getY()+(e.getY() - y));
    	}
    }
    
    public void mouseMoved(MouseEvent e){ }
    
    public void mouseReleased(MouseEvent e){ }
    
    public void mouseEntered(MouseEvent e){ 
    	if(e.getSource() == point || e.getSource() == point2)
    	{
    		System.out.println("tagada");
    	}
    }
    
    public void mouseExited(MouseEvent e){ }
}
