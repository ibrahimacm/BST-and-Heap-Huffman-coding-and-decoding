import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;


//this class for interface

public class panelButtonWindow extends MouseAdapter{
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	public panelButtonWindow(JPanel panel1) {
		panel = panel1;
	}
	public panelButtonWindow(JLabel label) {
		this.label = label;
	}
	
	
	public void mouseEntered(MouseEvent arg0) {
		panel.setBackground(new Color(0,102,204));
		label.setForeground(new Color(255, 0, 0));
	}
	
	public void mouseClicked(MouseEvent arg0) {
		//panel.setBackground(new Color(47,79,79));
		//(112,128,144)
	}
	public void mouseExited(MouseEvent arg0) {
		panel.setBackground(new Color(0,0,51));
		label.setForeground(new Color(255, 255, 255));
	}
	public void mouseReleased(MouseEvent arg0) {
		panel.setBackground(new Color(0,0,51));
		label.setForeground(new Color(255, 255, 255));
	}

}
