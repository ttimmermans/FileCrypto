package net.codejava.crypto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecryptPanel extends EnterKeyPanel {
	
	public DecryptPanel() {
		super("Decrypt!", labelTxt);
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
	+"there is no way to decrypt and recover your files if you forget this!<br>"
	+"<br>The password must be <i>AT LEAST</i> 16 characters long.</html>";
	/*
	"<html>Please choose a password to encrypt the file with!<br>"
	+"Be <i>VERY CAREFUL</i> to remember this password as <br>"
	+"there is no way to decrypt and recover your files if you forget this!<br>"
    +"<br>The password must be <i>AT LEAST</i> 16 characters long.</html>";
    */

}