package net.codejava.crypto;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class DecryptPanel extends EnterKeyPanel {
	
	public DecryptPanel(JPanel mainCardPanel, CardLayout cards) {
		super("Decrypt!", labelTxt);
		this.mainCardPanel = mainCardPanel;
		this.cards = cards;
	}
	
	public void addListenerToButton() {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("DECRYPT BUTTON GEKLIKT !!!");
			}
			
		});
	}
	
	private static String labelTxt =
	"<html>Please enter the password to decrypt the file.<br>"
	+"This must be <i>EXACTLY</i> the same as was used to encrypt it!<br>"
	+"Otherwise your files can not be unlocked!<br>"
	+"<br>Hint: The used password was at least 16 characters long.</html>";

}