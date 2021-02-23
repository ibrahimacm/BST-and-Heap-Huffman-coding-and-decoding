import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.JTable;
import java.awt.Canvas;


//this class for interface

public class startWindow extends JPanel{
		private JFrame window = new JFrame();
	@SuppressWarnings("unchecked")
	public startWindow() {
		window.getContentPane().setBackground(new Color(0, 0, 51));
		
		JPanel panelBack = new JPanel();
		panelBack.addMouseListener(new panelButtonWindow(panelBack));
		panelBack.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				window.dispose();
				secondWindow m = new secondWindow();
			}
		});
		panelBack.setBackground(new Color(0, 0, 51));
		
		JLabel lblNewLabel = new JLabel("Back");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel.setBackground(new Color(51, 0, 0));
		GroupLayout gl_panelBack = new GroupLayout(panelBack);
		gl_panelBack.setHorizontalGroup(
			gl_panelBack.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBack.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelBack.setVerticalGroup(
			gl_panelBack.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelBack.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addContainerGap())
		);
		panelBack.setLayout(gl_panelBack);
		
		JPanel panelDecoding = new JPanel();
		panelDecoding.addMouseListener(new panelButtonWindow(panelDecoding));
		panelDecoding.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				window.dispose();
				decodingWindow dw = new decodingWindow();
			}
		});
		panelDecoding.setBackground(new Color(0, 0, 51));
		
		JLabel lblBatchfile = new JLabel("Decoding\r\n");
		lblBatchfile.setForeground(Color.WHITE);
		lblBatchfile.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblBatchfile.setBackground(new Color(51, 0, 0));
		GroupLayout gl_panelBack_1 = new GroupLayout(panelDecoding);
		gl_panelBack_1.setHorizontalGroup(
			gl_panelBack_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelBack_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBatchfile, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelBack_1.setVerticalGroup(
			gl_panelBack_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelBack_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblBatchfile)
					.addContainerGap())
		);
		panelDecoding.setLayout(gl_panelBack_1);
		
		JPanel panelEncoding = new JPanel();
		panelEncoding.addMouseListener(new panelButtonWindow(panelEncoding));
		panelEncoding.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				window.dispose();
				encodingWindow ew = new encodingWindow();
			}
		});
		panelEncoding.setBackground(new Color(0, 0, 51));
		
		JLabel lblAbout = new JLabel("Encoding");
		lblAbout.setForeground(Color.WHITE);
		lblAbout.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		GroupLayout gl_panelEncoding = new GroupLayout(panelEncoding);
		gl_panelEncoding.setHorizontalGroup(
			gl_panelEncoding.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 80, Short.MAX_VALUE)
				.addGroup(gl_panelEncoding.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblAbout)
					.addContainerGap())
		);
		gl_panelEncoding.setVerticalGroup(
			gl_panelEncoding.createParallelGroup(Alignment.LEADING)
				.addGap(0, 42, Short.MAX_VALUE)
				.addGroup(gl_panelEncoding.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAbout)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelEncoding.setLayout(gl_panelEncoding);
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(183)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelDecoding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelEncoding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(panelBack, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(174, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(103)
					.addComponent(panelEncoding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(panelDecoding, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(164)
					.addComponent(panelBack, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(81))
		);
		
		window.getContentPane().setLayout(groupLayout);
		window.setBackground(new Color(0, 0, 51));
		window.setLocation(50, 50);
		window.setUndecorated(true);
		window.setSize(450, 450);
		window.setVisible(true);
	}
}
