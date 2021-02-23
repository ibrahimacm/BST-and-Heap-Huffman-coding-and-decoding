import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;


// this class for interface

public class aboutWindow extends JPanel{
		private JFrame window = new JFrame();
	public aboutWindow() {
		window.setLocation(50, 50);
		window.setUndecorated(true);
		window.setSize(450, 450);
		window.setVisible(true);
		
		
		setBackground(new Color(0, 0, 51));
		window.getContentPane().add(this);
		
		JLabel lbIcon = new JLabel("");
		lbIcon.setIcon(new ImageIcon("infoWindow2.png"));
		
		JEditorPane dtrpnWelcomeNPuzzle = new JEditorPane();
		dtrpnWelcomeNPuzzle.setEditable(false);
		dtrpnWelcomeNPuzzle.setText("           Algorithem Project\r\n   \r\nIt's Huffman coding and decoding by BST\r\nand Heap. \r\n\r\n\r\n\r\nThe project done by:\r\nIbrahim Alabdulwahab.\r\nRayan Alakeel\r\n\r\nSupervised by:\r\nDr. Mohammed Ismail");
		dtrpnWelcomeNPuzzle.setForeground(new Color(255, 255, 255));
		dtrpnWelcomeNPuzzle.setFont(new Font("Monospaced", Font.BOLD, 17));
		dtrpnWelcomeNPuzzle.setBackground(new Color(0, 0, 51));
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new panelButtonWindow(panel_1));
		panel_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				window.dispose();
				secondWindow m = new secondWindow();
			}
		});
		panel_1.setBackground(new Color(0, 0, 51));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbIcon)
							.addGap(18)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(dtrpnWelcomeNPuzzle, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(dtrpnWelcomeNPuzzle, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addComponent(lbIcon, GroupLayout.PREFERRED_SIZE, 84, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		JLabel lblNewLabel = new JLabel("Back");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel.setBackground(new Color(51, 0, 0));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		setLayout(groupLayout);
	}
}