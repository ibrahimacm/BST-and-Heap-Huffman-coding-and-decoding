import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;

//this class for interface

public class secondWindow extends JPanel implements ActionListener,KeyListener{
	private JFrame window = new JFrame();
	
	public secondWindow() {
		setBackground(new Color(0, 0, 51));
		window.getContentPane().setBackground(new Color(51, 0, 0));
		window.setForeground(new Color(0, 0, 51));
		window.setLocation(50, 50);
		window.setUndecorated(true);
		window.setSize(450, 450);
		window.setVisible(true);
		
		window.getContentPane().add(this);
		
		JPanel lbStart = new JPanel();
		lbStart.setForeground(new Color(0, 0, 51));
		lbStart.addMouseListener(new panelButtonWindow(lbStart));
		lbStart.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				window.dispose();
				startWindow stratWindow = new startWindow();
			}
		});
		lbStart.setBackground(new Color(0, 0, 51));
		
		JPanel lbStart_1 = new JPanel();
		lbStart_1.setForeground(new Color(0, 0, 51));
		lbStart_1.addMouseListener(new panelButtonWindow(lbStart_1));
		lbStart_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				window.dispose();
				infoWindow iw = new infoWindow();
			}
		});
		lbStart_1.setBackground(new Color(0, 0, 51));
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		GroupLayout gl_lbStart_1 = new GroupLayout(lbStart_1);
		gl_lbStart_1.setHorizontalGroup(
			gl_lbStart_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 70, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_lbStart_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblInfo, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(63))
		);
		gl_lbStart_1.setVerticalGroup(
			gl_lbStart_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 42, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_lbStart_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInfo)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		lbStart_1.setLayout(gl_lbStart_1);
		
		JPanel lbStart_2 = new JPanel();
		lbStart_2.addMouseListener(new panelButtonWindow(lbStart_2));
		lbStart_2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				window.dispose();
			}
		});
		
		lbStart_2.setBackground(new Color(0, 0, 51));
		
		JLabel lblExit = new JLabel("Exit");
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		GroupLayout gl_lbStart_2 = new GroupLayout(lbStart_2);
		gl_lbStart_2.setHorizontalGroup(
			gl_lbStart_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_lbStart_2.createSequentialGroup()
					.addGap(18)
					.addComponent(lblExit, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_lbStart_2.setVerticalGroup(
			gl_lbStart_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lbStart_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblExit)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		lbStart_2.setLayout(gl_lbStart_2);
		
		JPanel lbStart_1_1 = new JPanel();
		lbStart_1_1.setBackground(new Color(0, 0, 51));
		lbStart_1_1.addMouseListener(new panelButtonWindow(lbStart_1_1));
		lbStart_1_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				window.dispose();
				aboutWindow aw = new aboutWindow();
			}
		});
		
		JLabel lblAbout = new JLabel("Project");
		lblAbout.setForeground(Color.WHITE);
		lblAbout.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		GroupLayout gl_lbStart_1_1 = new GroupLayout(lbStart_1_1);
		gl_lbStart_1_1.setHorizontalGroup(
			gl_lbStart_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_lbStart_1_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblAbout)
					.addContainerGap())
		);
		gl_lbStart_1_1.setVerticalGroup(
			gl_lbStart_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lbStart_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAbout)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		lbStart_1_1.setLayout(gl_lbStart_1_1);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(158)
							.addComponent(lbStart, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(lbStart_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(222, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(206, Short.MAX_VALUE)
					.addComponent(lbStart_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(164))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(174)
					.addComponent(lbStart_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(206, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(lbStart, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(lbStart_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(lbStart_1_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(lbStart_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(94, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Start\r\n");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		GroupLayout gl_lbStart = new GroupLayout(lbStart);
		gl_lbStart.setHorizontalGroup(
			gl_lbStart.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_lbStart.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(63))
		);
		gl_lbStart.setVerticalGroup(
			gl_lbStart.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_lbStart.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		lbStart.setLayout(gl_lbStart);
		setLayout(groupLayout);
		window.setBackground(new Color(0, 0, 51));
		
	}
	
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

	
