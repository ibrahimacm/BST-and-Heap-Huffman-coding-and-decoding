import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Timer;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.JTable;
import java.awt.Canvas;

//this class for interface

public class encodingWindow extends JPanel{
		private JFrame window = new JFrame();
		private JTextField nInput;
	@SuppressWarnings("unchecked")
	public encodingWindow() {
		window.getContentPane().setBackground(new Color(0, 0, 51));
		
		JPanel panelBack = new JPanel();
		panelBack.addMouseListener(new panelButtonWindow(panelBack));
		panelBack.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				window.dispose();
				startWindow s = new startWindow();
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
				.addGap(0, 63, Short.MAX_VALUE)
				.addGroup(gl_panelBack.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelBack.setVerticalGroup(
			gl_panelBack.createParallelGroup(Alignment.LEADING)
				.addGap(0, 29, Short.MAX_VALUE)
				.addGroup(gl_panelBack.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelBack.setLayout(gl_panelBack);
		
		JPanel panelStart = new JPanel();
		
		
		panelStart.setBackground(new Color(0, 0, 51));
		
		
		JLabel lblPlay = new JLabel("show Graph Tree\r\n");
		
		
		
		lblPlay.setForeground(Color.WHITE);
		lblPlay.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblPlay.setBackground(new Color(51, 0, 0));
		GroupLayout gl_panelStart = new GroupLayout(panelStart);
		gl_panelStart.setHorizontalGroup(
			gl_panelStart.createParallelGroup(Alignment.LEADING)
				.addGap(0, 63, Short.MAX_VALUE)
				.addGroup(gl_panelStart.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPlay, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelStart.setVerticalGroup(
			gl_panelStart.createParallelGroup(Alignment.LEADING)
				.addGap(0, 29, Short.MAX_VALUE)
				.addGroup(gl_panelStart.createSequentialGroup()
					.addComponent(lblPlay)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelStart.setLayout(gl_panelStart);
		
		JLabel txtEnterNNumber = new JLabel("Enter Text to encoding:");
		txtEnterNNumber.setForeground(Color.WHITE);
		txtEnterNNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtEnterNNumber.setBackground(new Color(51, 0, 0));
		
		nInput = new JTextField();
		nInput.setColumns(10);
		
		final JLabel exceptionTXT = new JLabel("");
		exceptionTXT.setForeground(Color.RED);
		JLabel doneTXT = new JLabel("");
		JLabel lblPressHereTo = new JLabel("");
		lblPressHereTo.setForeground(Color.WHITE);
		
		JLabel lblToOpenIt = new JLabel("");
		lblToOpenIt.setForeground(new Color(255, 255, 255));
		
		doneTXT.setForeground(new Color(255, 255, 255));
		
		JPanel panelBack_1 = new JPanel();
		panelBack_1.addMouseListener(new panelButtonWindow(panelBack_1));
		panelBack_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				try {
					if(nInput.getText().length()<=1)
						throw new customException(1);
					
				Huffman huff = new Huffman(nInput.getText());
				huff.saveEncodingFile();
				huff.graphTree();
				
				doneTXT.setText("Done. Will Find it in same dir for project.");
				lblPressHereTo.setText("Press here");
				lblToOpenIt.setText("to open it direct.");
				}
				catch(customException c) {
					exceptionTXT.setText("Empty Text! try again");
				}
				catch(Exception e) {
					exceptionTXT.setText("Something Wrong...");
				};
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		
		panelStart.addMouseListener(new panelButtonWindow(panelStart));
		panelStart.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				try {
					if(nInput.getText().length()<=1)
						throw new customException(1);
					
				Huffman huff = new Huffman(nInput.getText());
				
					huff.graphTree();
				
				JOptionPane x = new JOptionPane();
				  x.showMessageDialog(null, "You need to have graphViz to show the graph or the file will open it with word. \n"
				  		+ "Or you can open it on graphViz manuelly");
				        
					     Path path = Paths.get("graphTree.dot");
					     Desktop dt = Desktop.getDesktop();
					     
							dt.open(path.toFile());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							lblNewLabel_1.setText("File doesn't exist. Create one.");
						} catch (customException e) {
							exceptionTXT.setText("Empty Text! try again");
						}
					    
					  
				      
			}
		});
		
		panelBack_1.setBackground(new Color(0, 0, 51));
		
		JLabel lblBatchfile = new JLabel("\r\nsave as File");
		lblBatchfile.setForeground(Color.WHITE);
		lblBatchfile.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblBatchfile.setBackground(new Color(51, 0, 0));
		GroupLayout gl_panelBack_1 = new GroupLayout(panelBack_1);
		gl_panelBack_1.setHorizontalGroup(
			gl_panelBack_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 63, Short.MAX_VALUE)
				.addGroup(gl_panelBack_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBatchfile, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelBack_1.setVerticalGroup(
			gl_panelBack_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 29, Short.MAX_VALUE)
				.addGroup(gl_panelBack_1.createSequentialGroup()
					.addComponent(lblBatchfile)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelBack_1.setLayout(gl_panelBack_1);
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(exceptionTXT, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(nInput, Alignment.LEADING)
									.addComponent(txtEnterNNumber, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panelBack_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblPressHereTo)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblToOpenIt))
										.addComponent(doneTXT, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(panelStart, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(panelBack, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(127)
					.addComponent(txtEnterNNumber)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(nInput, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(exceptionTXT, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelBack_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(doneTXT)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPressHereTo)
								.addComponent(lblToOpenIt))))
					.addGap(34)
					.addComponent(panelStart, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(panelBack, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(71))
		);
		
		lblPressHereTo.addMouseListener(new panelButtonWindow(lblPressHereTo));
		lblPressHereTo.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				
				      
				        
					     Path path = Paths.get("Encoding.txt");
					     Desktop dt = Desktop.getDesktop();
					     try {
							dt.open(path.toFile());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							lblNewLabel_1.setText("File doesn't exist. Create one.");
						}
					    
					  
				      
			}
		});
		
		window.getContentPane().setLayout(groupLayout);
		window.setBackground(new Color(0, 0, 51));
		window.setLocation(50, 50);
		window.setUndecorated(true);
		window.setSize(450, 450);
		window.setVisible(true);
	}
}
