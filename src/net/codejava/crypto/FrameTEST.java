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
import javax.swing.Timer;

//search-term was: "runnable jar with custom icon"
//https://stackoverflow.com/questions/19927509/set-icon-for-executable-jar-file

public class FrameTEST {
	
	private JFrame frame;
	private JPanel mainCardPanel;
	//private FyleChooserTEST chooser = new FyleChooserTEST();
	//TimerListener timerListener;
	
	public FrameTEST() {
		frame = new JFrame("File Crypto");
		
		JPanel contentPane = (JPanel)frame.getContentPane();
		contentPane.setLayout(new GridBagLayout());
		
		CardLayout cardLayout = new CardLayout();
		mainCardPanel = new JPanel(cardLayout);
		contentPane.add(mainCardPanel);
		
		StartPanel startPanel = new StartPanel(mainCardPanel, cardLayout);
		mainCardPanel.add(startPanel);
		
		EncryptPanel encryptPanel = new EncryptPanel(mainCardPanel, cardLayout);
		mainCardPanel.add(encryptPanel);
		
		DecryptPanel decryptPanel = new DecryptPanel(mainCardPanel, cardLayout);
		mainCardPanel.add(decryptPanel);
		
		//timerListener = new TimerListener();
		//Timer timer = new Timer(4000, timerListener);
	 	//timer.setDelay(4000);
		//timer.start();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(580, 220); // 580, 220 is current (29-09-2017) optimal size for encrypt panel
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	/*
	class TimerListener implements ActionListener {
		
		CardLayout cards = (CardLayout)mainCardPanel.getLayout();

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Timer werkt!");
			cards.next(mainCardPanel);
		}
		
	}
    */
	
	/*
	public void nextCard() {
		CardLayout cards = (CardLayout)mainCardPanel.getLayout();
		cards.next(mainCardPanel);
	}
	*/

	
	public static void main(String[] args) {
		
		FrameTEST test = new FrameTEST();

	}

}
