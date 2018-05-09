package net.codejava.crypto;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

//search-term was: "runnable jar with custom icon"
//https://stackoverflow.com/questions/19927509/set-icon-for-executable-jar-file
//test 09-05-2018
/**
 * @author Thomas Timmermans
 * @version 13-10-2017
 */
public class FrameTEST {
	
	private JFrame frame;
	private JPanel mainCardPanel;
	private FyleChooserTEST chooser;
	
	/* encryptMode indicates if files are to be encrypted or decrypted, it's 
	 * checked by multiple other classes to assign the right actions to buttons, 
	 * set appropriate label texts and so on. */ 
	static boolean encryptMode;
	
	/**
	 * Constructor. Build GUI-components.
	 */
	public FrameTEST() {
		frame = new JFrame("File Crypto");
		
		JPanel contentPane = (JPanel)frame.getContentPane();
		contentPane.setLayout(new GridBagLayout());
		
		CardLayout cardLayout = new CardLayout();
		mainCardPanel = new JPanel(cardLayout);
		contentPane.add(mainCardPanel);
		
		chooser = new FyleChooserTEST(frame, mainCardPanel, cardLayout);
		
		RadioButtonTEST radioButtonz = new RadioButtonTEST(mainCardPanel, cardLayout);
		StartPanel startPanel = new StartPanel(chooser, radioButtonz);
		EncryptPanel encryptPanel = new EncryptPanel(mainCardPanel, cardLayout);
		DecryptPanel decryptPanel = new DecryptPanel(mainCardPanel, cardLayout);
		
	 	cardLayout.addLayoutComponent(startPanel, "startPanel");
		cardLayout.addLayoutComponent(encryptPanel, "encryptPanel");
		cardLayout.addLayoutComponent(decryptPanel, "decryptPanel");
		cardLayout.addLayoutComponent(radioButtonz, "radioButtons");
		
		mainCardPanel.add(startPanel);
		mainCardPanel.add(encryptPanel);
		mainCardPanel.add(decryptPanel);
		mainCardPanel.add(radioButtonz);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(580, 220); // 580, 220 is current (29-09-2017) optimal size for encrypt panel
		//frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	

	public static void main(String[] args) {
		
		FrameTEST test = new FrameTEST();

	}
	
	/*
	 * https://stackoverflow.com/questions/3519151/how-to-limit-the-number-of-characters-in-jtextfield
	 * 
	 * http://docs.oracle.com/javase/tutorial/uiswing/components/generaltext.html#filter
	 */

}
