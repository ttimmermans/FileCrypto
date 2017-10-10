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

/**
 * @author Thomas Timmermans
 * @version 06-10-2017
 */
public class FrameTEST {
	
	private JFrame frame;
	private JPanel mainCardPanel;
	//private FyleChooserTEST chooser = new FyleChooserTEST();
	
	/* encryptMode indicates if files chosen by user should be encrypted or 
	 * decrypted. This property is checked by the "next" button in the panel
	 * with the radio buttons and toggled by the "encrypt" and "decrypt" buttons
	 * in the startPanel being clicked. */
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
		
		StartPanel startPanel = new StartPanel(mainCardPanel, cardLayout);
	 	cardLayout.addLayoutComponent(startPanel, "startPanel");
		mainCardPanel.add(startPanel);
		
		EncryptPanel encryptPanel = new EncryptPanel(mainCardPanel, cardLayout);
		cardLayout.addLayoutComponent(encryptPanel, "encryptPanel");
		mainCardPanel.add(encryptPanel);
		
		DecryptPanel decryptPanel = new DecryptPanel(mainCardPanel, cardLayout);
		cardLayout.addLayoutComponent(decryptPanel, "decryptPanel");
		mainCardPanel.add(decryptPanel);
		
		RadioButtonTEST radioButtonz = new RadioButtonTEST(mainCardPanel, cardLayout);
		cardLayout.addLayoutComponent(radioButtonz, "radioButtons");
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

}
