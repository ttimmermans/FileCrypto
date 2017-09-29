package net.codejava.crypto;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartPanel extends JPanel {
	
	private JPanel mainCardPanel;
	private CardLayout cards;
	
	public StartPanel(JPanel mainCardPanel, CardLayout cards) {
		this.mainCardPanel = mainCardPanel;
		this.cards = cards;
		this.setLayout(new GridLayout(1, 2));
		this.add(new EncryptButton());
		this.add(new DecryptButton());
	}
	
	public void nextCard() {
		//CardLayout cards = (CardLayout)mainCardPanel.getLayout();
		cards.next(mainCardPanel);
	}
	
	private class EncryptButton extends JButton {
		
		public EncryptButton() {
			this.setText("Encrypt Files");
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("EncryptButton (main menu) Clicked");
					nextCard();
				}
			});
		}
	}

	private class DecryptButton extends JButton {
		
		public DecryptButton() {
			this.setText("Decrypt Files");
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("DecryptButton (main menu) Clicked");
					nextCard();
					nextCard();
				}
			});
		}
	}
	
}
