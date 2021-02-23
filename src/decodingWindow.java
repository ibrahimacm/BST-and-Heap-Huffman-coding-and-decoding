import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Timer;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.JTable;
import java.awt.Canvas;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;

//this class for interface

public class decodingWindow extends JPanel{
		private JFrame window = new JFrame();
		private JTextField nInput;
		private JFileChooser openFile;
		
	@SuppressWarnings("unchecked")
	public decodingWindow() {
		
		window.getContentPane().setBackground(new Color(0, 0, 51));
		
		openFile = new JFileChooser();
		openFile.setCurrentDirectory(new File("C:\\Users\\IBRA_M\\Desktop\\NewStart\\Algorithems\\"));
		openFile.setFileFilter(new FileNameExtensionFilter("TXT files", "txt"));
		
		JPanel panelBack = new JPanel();
		panelBack.addMouseListener(new panelButtonWindow(panelBack));
		panelBack.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				window.dispose();
				startWindow m = new startWindow();
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
		

		JLabel lblNewLabel_1 = new JLabel("Choose File:");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblFileMust = new JLabel("* File must end with .txt");
		lblFileMust.setForeground(new Color(255, 255, 255));
		
		JLabel lblFileDecodingHas = new JLabel("");
		lblFileDecodingHas.setBackground(new Color(255, 255, 255));
		lblFileDecodingHas.setForeground(new Color(255, 255, 255));
		
		JLayeredPane layeredPane = new JLayeredPane();
		
		JLabel lblPressHere = new JLabel("");
		
		lblPressHere.setForeground(new Color(255, 255, 255));
		
		JLabel lblToOpenIt = new JLabel("");
		lblToOpenIt.setForeground(new Color(255, 255, 255));
		
		
		final JLabel exceptionTXT_1 = new JLabel("");
		exceptionTXT_1.setForeground(Color.RED);
		
		nInput = new JTextField();
		nInput.setColumns(10);
		
		JPanel panelOK = new JPanel();
		panelOK.addMouseListener(new panelButtonWindow(panelOK));
		panelOK.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				String text = "";
				String st = openFile.getSelectedFile().toString();
				try {
				for(int i = st.length()-1; i>0;i--) {
					if(st.charAt(i) == '.') {
						if(!st.substring(i, st.length()).equals(".txt"))
							throw new customException(1);
						
							break;
					}
				}
				
					
				      File myObj = openFile.getSelectedFile();
				     
				      Scanner myReader = new Scanner(myObj);
				      String data;
				      while (myReader.hasNextLine()) { 
				    	  data = myReader.nextLine();
				    	  text += data + "\n";
				      }
				      myReader.close();
				      
				         File file = new File("Decoding.txt");
						 file.delete();
					     Path path = Paths.get("Decoding.txt");
					    
					    
					    try (
					         BufferedWriter writer = Files.newBufferedWriter(path,
					            StandardCharsets.UTF_8, StandardOpenOption.CREATE);
					    ) {
					    	// put total (the text) in file.
					        writer.write(text);
					        writer.close();
					        lblFileDecodingHas.setText("File Decoding has been created.");
					        lblPressHere.setText("Press here");
					        lblToOpenIt.setText("to open it.");
					        
					        
					    }catch(Exception x) {x.getStackTrace();}
				      
				     
				    } catch (FileNotFoundException x) {
				      System.out.println("An error occurred.");
				      x.printStackTrace();
				      
				    } catch(customException x) {
					if(x.getN() == 1)
						exceptionTXT_1.setText("Choose file end with .txt");
				} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				//BatchFile bf = new BatchFile();
			}
		});
		
		panelOK.setBackground(new Color(0, 0, 51));
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = openFile.showOpenDialog(getParent());
				if (value == JFileChooser.APPROVE_OPTION ) {
					nInput.setText(openFile.getSelectedFile().toString());
				}
				else {
					exceptionTXT_1.setText("Choose File");
				}
				
				//window.dispose();
				
			}
		});
		lblPressHere.addMouseListener(new panelButtonWindow(lblPressHere));
		lblPressHere.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				
				      
				        
					     Path path = Paths.get("Decoding.txt");
					     Desktop dt = Desktop.getDesktop();
					     try {
							dt.open(path.toFile());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    
					  
				      
			}
		});
		
		
		JLabel lblOK = new JLabel("OK\r\n");
		lblOK.setForeground(Color.WHITE);
		lblOK.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblOK.setBackground(new Color(0, 0, 51));
		GroupLayout gl_panelOK = new GroupLayout(panelOK);
		gl_panelOK.setHorizontalGroup(
			gl_panelOK.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOK.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOK)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelOK.setVerticalGroup(
			gl_panelOK.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOK.createSequentialGroup()
					.addComponent(lblOK)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelOK.setLayout(gl_panelOK);
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(lblFileMust))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(lblFileDecodingHas)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPressHere)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblToOpenIt))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(panelBack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(panelOK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(49)
									.addComponent(exceptionTXT_1, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnBrowse)
									.addGap(18)
									.addComponent(nInput, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)))))
					.addGap(220))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(87)
					.addComponent(lblNewLabel_1)
					.addGap(6)
					.addComponent(lblFileMust)
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBrowse)
						.addComponent(nInput, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(exceptionTXT_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelOK, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFileDecodingHas)
						.addComponent(lblPressHere)
						.addComponent(lblToOpenIt))
					.addGap(48)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(94)
					.addComponent(panelBack, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		window.getContentPane().setLayout(groupLayout);
		window.setLocation(50, 50);
		window.setUndecorated(true);
		window.setSize(450, 450);
		window.setVisible(true);
	}
}
