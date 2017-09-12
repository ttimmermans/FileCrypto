package net.codejava.crypto;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//search-term was: "runnable jar with custom icon"
//https://stackoverflow.com/questions/19927509/set-icon-for-executable-jar-file

public class FrameTEST {
	
	private JFrame frame;
	private JPanel mainCardPanel;
	TimerListener timerListener;
	
	public FrameTEST() {
		frame = new JFrame("File Crypto");
		
		JPanel contentPane = (JPanel)frame.getContentPane();
		contentPane.setLayout(new GridBagLayout());
		
		mainCardPanel = new JPanel(new CardLayout());
		contentPane.add(mainCardPanel);
		
		EncryptPanel encryptPanel = new EncryptPanel();
		mainCardPanel.add(encryptPanel);
		
		DecryptPanel decryptPanel = new DecryptPanel();
		mainCardPanel.add(decryptPanel);
		
		timerListener = new TimerListener();
		Timer timer = new Timer(100, timerListener);
	 	timer.setDelay(3000);
		timer.start();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(580, 220);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	class TimerListener implements ActionListener {
		
		CardLayout cards = (CardLayout)mainCardPanel.getLayout();

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Timer werkt!");
			cards.next(mainCardPanel);
		}
		
	}

	public static void main(String[] args) {
		
		FrameTEST test = new FrameTEST();

	}

}
