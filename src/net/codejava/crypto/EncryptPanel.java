package net.codejava.crypto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptPanel extends EnterKeyPanel {
	
	public EncryptPanel() {
		super("Encrypt!", labelTxt);
	}
	
	public void addListenerToButton() {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ENCRYPT BUTTON CLICKED !!!");
			}
			
		});
	}
	
	private static String labelTxt = 
	"<html>Please choose a password to encrypt the file with!<br>"
	+"Be <i>VERY CAREFUL</i> to remember this password as <br>"
	+"there is no way to decrypt and recover your files if you forget this!<br>"
    +"<br>The password must be <i>AT LEAST</i> 16 characters long.</html>";

}
